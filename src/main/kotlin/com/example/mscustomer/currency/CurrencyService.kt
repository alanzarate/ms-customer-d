package com.example.mscustomer.currency

import com.example.mscustomer.dto.CurrencyServiceDto
import feign.Param
import feign.QueryMap
import feign.RequestLine
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.util.Objects
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@FeignClient(name = "currency", url="http://localhost:7777/api/v1/currency", configuration = [ConfigFeignDecoderCurrency::class])
interface CurrencyService {

    @RequestMapping(method = [RequestMethod.GET],
        value = ["/convert"],
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON])
    fun getCurrency(@RequestParam(value = "from") from:String,
                    @RequestParam(value = "to") to:String,
                    @RequestParam(value = "amount") amount:String ,
                    @RequestHeader header: Map<String, String>): String
}