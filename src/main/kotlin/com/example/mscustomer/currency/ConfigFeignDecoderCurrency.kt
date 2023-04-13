package com.example.mscustomer.currency

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import feign.Contract
import feign.Response
import feign.codec.Decoder
import feign.jackson.JacksonDecoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import java.lang.reflect.Type
import java.util.List


class ConfigFeignDecoderCurrency {

}