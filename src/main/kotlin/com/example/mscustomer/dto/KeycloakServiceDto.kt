package com.example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class KeycloakServiceDto(
    var access_token: String
) {
}