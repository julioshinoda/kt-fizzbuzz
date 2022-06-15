package com.example.FizzBuzz.controller

import com.example.FizzBuzz.model.Fizzbuzz
import com.example.FizzBuzz.service.FizzbuzzService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FizzbuzzEndpoint(val service: FizzbuzzService) {
    @GetMapping("/fizzbuzz")
    fun fizzbuzz(@RequestParam entries: String?): List<Fizzbuzz> =  service.calculate(entries)
}