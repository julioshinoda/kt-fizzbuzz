package com.example.FizzBuzz.service

import com.example.FizzBuzz.model.Fizzbuzz
import com.example.FizzBuzz.model.Messages
import org.springframework.stereotype.Service

@Service
class FizzbuzzService() : IService {
    override fun calculate(entries: String?): List<Fizzbuzz>{
        val numbers = entries?.split(",")
        val entriesList = mutableListOf<Fizzbuzz>()
        try {
            for (i in numbers!!) {
                try {
                    val elem = i.toInt()
                    entriesList.add(Fizzbuzz(input = i, output = operation(elem)))
                } catch (e: NumberFormatException) {
                    entriesList.add(Fizzbuzz(input = i, output = Messages.ERROR_INVALID_INPUT))
                }

            }
        }catch (e: NullPointerException){
            return defaultResponse()
        }

        return entriesList
    }

    fun defaultResponse(): List<Fizzbuzz>{
        val entriesList = mutableListOf<Fizzbuzz>()
        for(i in 1..100){
            entriesList.add(Fizzbuzz(input = "${i}", output = operation(i)))
        }

        return entriesList
    }

    fun operation(number :Int): String{
        if ( number %15 == 0) {
            return Messages.FIZZ_BUZZ
        }
        if(number%5 == 0) {
            return Messages.BUZZ
        }
        if(number%3 == 0){
            return Messages.FIZZ
        }
        return "${number}"
    }
}