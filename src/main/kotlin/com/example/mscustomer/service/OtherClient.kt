package com.example.mscustomer.service

import feign.Headers
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "ms-other")
interface OtherClient {



    @GetMapping(value = ["/api/other/list"])
    fun getList(): List<String>

    @PostMapping(value = ["/api/other/gettoken"])
    fun getToken(): HashMap<String, String>
}