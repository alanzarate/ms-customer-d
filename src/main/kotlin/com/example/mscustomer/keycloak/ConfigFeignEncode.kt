package com.example.mscustomer.keycloak

import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean

class ConfigFeignEncode {
    @Bean
    fun encoder(converters: ObjectFactory<HttpMessageConverters>): Encoder {
        return SpringFormEncoder(SpringEncoder(converters))
    }
}