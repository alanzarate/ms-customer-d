package com.example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CurrencyServiceDto(
    var data: Any,
    var message: String,
    var success: Boolean
) {
}