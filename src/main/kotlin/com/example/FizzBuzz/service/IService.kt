package com.example.FizzBuzz.service

import com.example.FizzBuzz.model.Fizzbuzz
import org.springframework.stereotype.Service


@Service
interface IService {
    fun calculate(entries: String?): List<Fizzbuzz>
}

