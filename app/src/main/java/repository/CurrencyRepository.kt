package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.FrankfurterApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Repository handles all data fetching — the ViewModel talks to this, not directly to the API
class CurrencyRepository {

    // Build the Retrofit client pointing at the Frankfurter API
    private val api: FrankfurterApiService = Retrofit.Builder()
        .baseUrl("https://api.frankfurter.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FrankfurterApiService::class.java)

    // Fetch converted amount from API
    suspend fun getConversionRate(amount: Double, from: String, to: String) =
        api.getConversionRate(amount, from, to)

    // Fetch list of all available currencies
    suspend fun getCurrencies() = api.getCurrencies()
}