package com.example.FizzBuzz

import com.example.FizzBuzz.model.Fizzbuzz
import com.example.FizzBuzz.model.Messages
import com.example.FizzBuzz.service.FizzbuzzService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FizzBuzzApplicationTests {

	val service = FizzbuzzService()
	@Test
	fun contextLoads() {
	}

	@Test
	fun whenReceiveMul3_thenReturnFizz() {
		//given
		val entry = 3

		//when
		val result = service.calculate("${entry}")

		//then
		val expected = listOf(
			Fizzbuzz(input = "${entry}", output = Messages.FIZZ)
		)
		assertEquals(expected, result)
	}


	@Test
	fun whenReceiveMul5_thenReturnBuzz() {
		//given
		val entry = 25

		//when
		val result = service.calculate("${entry}")

		//then
		val expected = listOf(
			Fizzbuzz(input = "${entry}", output = Messages.BUZZ)
		)

		assertEquals(expected, result)
	}

	@Test
	fun whenReceiveMul3And5_thenReturnFizzBuzz() {
		//given
		val entry = 15

		//when
		val result = service.calculate("${entry}")

		//then
		val expected = listOf(
			Fizzbuzz(input = "${entry}", output = Messages.FIZZ_BUZZ)
		)
		assertEquals(expected, result)
	}

	/*
	*
	*If there is no entry, the output must be an array with the operation applied to all Integer from 1 to 100.
	*
	*/
	@Test
	fun whenReceiveNull_thenReturnDefaultList() {
		//given
		val entry = null

		//when
		val result = service.calculate(entry)

		//then
		val expected = service.defaultResponse()
		assertEquals(expected, result)
	}


	@Test
	fun whenReceiveNonMul_thenReturnEntry() {
		//given
		val entry = 4

		//when
		val result = service.calculate("${entry}")

		//then
		val expected = listOf(
			Fizzbuzz(input = "${entry}", output = "${entry}")
		)
		assertEquals(expected, result)
	}
}
