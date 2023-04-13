package com.example.mscustomer.keycloak

import com.example.mscustomer.dto.CurrencyServiceDto
import com.example.mscustomer.dto.KeycloakServiceDto
import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "keycloak", url = "http://localhost:8080/realms/testing2/protocol/openid-connect" ,
    configuration = [ConfigFeignEncode::class])
interface KeycloakService {
    @PostMapping(value = ["/token"], consumes = arrayOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
    @Headers("Content-Type: application/x-www-form-urlencoded")
    fun getToken(@RequestBody body: Map<String, Any>, @RequestHeader header: Map<String, String>): KeycloakServiceDto;
}