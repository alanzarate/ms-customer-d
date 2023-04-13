package com.example.mscustomer.api

import com.example.mscustomer.currency.CurrencyService
import com.example.mscustomer.dto.CurrencyServiceDto
import com.example.mscustomer.keycloak.KeycloakService
import com.example.mscustomer.service.OtherClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.print.attribute.standard.MediaSize.Other

@RestController
@RequestMapping("/api/customer")
class CustomerControllerk @Autowired constructor(
    private val other: OtherClient,
    private val keycloak: KeycloakService,
    private val currency: CurrencyService
){


    @GetMapping("/list")
    fun getCustomerList(): List<String> {
        val res = other.getList();
        return listOf("Customer 1", "Customer 2", "Customer 3") + res
    }

    @GetMapping("/nativelist")
    fun getCustomerNativeList(): List<String>{
    return listOf("Customer Native 1", "Customer Native 2")

    }

    @PostMapping("/gettoken")
    fun getTokenn():HashMap<String, String>{
        return other.getToken();
    }

    @GetMapping("/convert")
    fun controllerMethod(@RequestParam customQuery:Map<String, String>):Any{
        val from: String? = customQuery["from"]
        val to = customQuery["to"]
        val amount = customQuery["amount"]

        var boddy: HashMap<String, String> = HashMap<String, String>()
        var headder: HashMap<String, String> = HashMap<String, String>()
        boddy.put("grant_type", "client_credentials")
        boddy.put("response_type", "code")
        boddy.put("client_id", "backend")
        boddy.put("client_secret","J82JDRDUaIyMABThMlFGvQid1jsULeG5")
        headder.put("Content-Type","application/x-www-form-urlencoded")

        val resKeycloak = keycloak.getToken(boddy, headder)


        var header2: HashMap<String, String> = HashMap()
        header2["Authorization"] = "Bearer " + resKeycloak.access_token.toString()
        header2["Content-Type"] = "application/json"
        var queryMapGet: HashMap<String, String> = HashMap()
        queryMapGet["from"] = from.toString()
        queryMapGet["to"] = to.toString()
        queryMapGet["amount"] = amount.toString()

        val res2 = currency.getCurrency(from.toString(), to.toString(), amount.toString(), header2)
        print(res2)
     //   val res2 = currency.getCurrency(  header2)

        return res2
    }
}