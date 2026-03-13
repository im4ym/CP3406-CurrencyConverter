package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.ConversionResult
import retrofit2.http.GET
import retrofit2.http.Query

// Defines the API endpoints we'll call using Retrofit
interface FrankfurterApiService {

    // Fetches the latest exchange rate from one currency to another
    // Example: /latest?amount=10&from=USD&to=AUD
    @GET("latest")
    suspend fun getConversionRate(
        @Query("amount") amount: Double,
        @Query("from") from: String,
        @Query("to") to: String
    ): ConversionResult

    // Fetches all available currencies
    // Example: /currencies → returns { "AUD": "Australian Dollar", "USD": ... }
    @GET("currencies")
    suspend fun getCurrencies(): Map<String, String>
}