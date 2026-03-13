package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model

// Data class that matches what the Frankfurter API returns
data class ConversionResult(
    val amount: Double,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)