package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository.CurrencyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel holds all the UI state and talks to the Repository
class CurrencyViewModel : ViewModel() {

    private val repository = CurrencyRepository()

    // The converted result shown on screen
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    // Loading state — true while API call is in progress
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Error message — shown if something goes wrong
    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    // List of available currencies for the dropdowns
    private val _currencies = MutableStateFlow<List<String>>(emptyList())
    val currencies: StateFlow<List<String>> = _currencies

    // Default currencies from Settings screen
    var defaultFrom = MutableStateFlow("USD")
    var defaultTo = MutableStateFlow("AUD")
    var decimalPlaces = MutableStateFlow(2)

    // Load currencies when ViewModel is first created
    init {
        loadCurrencies()
    }

    // Fetches all available currency codes from the API
    fun loadCurrencies() {
        viewModelScope.launch {
            try {
                val currencyMap = repository.getCurrencies()
                _currencies.value = currencyMap.keys.sorted()
            } catch (e: Exception) {
                _error.value = "Failed to load currencies"
            }
        }
    }

    // Performs the currency conversion by calling the API
    fun convert(amount: Double, from: String, to: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = ""
            _result.value = ""
            try {
                val response = repository.getConversionRate(amount, from, to)
                val convertedAmount = response.rates[to] ?: 0.0
                val decimals = decimalPlaces.value
                _result.value = "%.${decimals}f $to".format(convertedAmount)
            } catch (e: Exception) {
                _error.value = "Conversion failed. Check your internet connection."
            } finally {
                _isLoading.value = false
            }
        }
    }
}