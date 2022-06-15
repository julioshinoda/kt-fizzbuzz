@file:Suppress("ClassName")
package com.example.FizzBuzz.integration


import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When

import org.apache.http.HttpStatus
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class FizzbuzzAPTests : BaseTest(){


    @Test
    fun `Return success response for multiple entries` (){

        Given { spec(requestSpecification)
            .log().all()

        }When {

            get("/fizzbuzz?entries=3,5,15")

        }Then {

            statusCode(HttpStatus.SC_OK).body(Matchers.equalTo("[{\"input\":\"3\",\"output\":\"Fizz\"},{\"input\":\"5\",\"output\":\"Buzz\"},{\"input\":\"15\",\"output\":\"FizzBuzz\"}]"))
        }
    }

    @Test
    fun `Return error response for invalid input` (){

        Given { spec(requestSpecification)
            .log().all()

        }When {

            get("/fizzbuzz?entries=not_valid")

        }Then {

            statusCode(HttpStatus.SC_OK).body(Matchers.equalTo("[{\"input\":\"not_valid\",\"output\":\"this operation only accept numbers\"}]"))
        }
    }

    @Test
    fun `Return error response for invalid input and Fizz for a valid input` (){

        Given { spec(requestSpecification)
            .log().all()

        }When {

            get("/fizzbuzz?entries=3,not_valid")

        }Then {

            statusCode(HttpStatus.SC_OK).body(Matchers.equalTo("[{\"input\":\"3\",\"output\":\"Fizz\"},{\"input\":\"not_valid\",\"output\":\"this operation only accept numbers\"}]"))
        }
    }

    @Test
    fun `Return default value when not sending an entry` (){

        Given { spec(requestSpecification)
            .log().all()

        }When {

            get("/fizzbuzz")

        }Then {

            statusCode(HttpStatus.SC_OK).body(Matchers.equalTo("[{\"input\":\"1\",\"output\":\"1\"},{\"input\":\"2\",\"output\":\"2\"},{\"input\":\"3\",\"output\":\"Fizz\"},{\"input\":\"4\",\"output\":\"4\"},{\"input\":\"5\",\"output\":\"Buzz\"},{\"input\":\"6\",\"output\":\"Fizz\"},{\"input\":\"7\",\"output\":\"7\"},{\"input\":\"8\",\"output\":\"8\"},{\"input\":\"9\",\"output\":\"Fizz\"},{\"input\":\"10\",\"output\":\"Buzz\"},{\"input\":\"11\",\"output\":\"11\"},{\"input\":\"12\",\"output\":\"Fizz\"},{\"input\":\"13\",\"output\":\"13\"},{\"input\":\"14\",\"output\":\"14\"},{\"input\":\"15\",\"output\":\"FizzBuzz\"},{\"input\":\"16\",\"output\":\"16\"},{\"input\":\"17\",\"output\":\"17\"},{\"input\":\"18\",\"output\":\"Fizz\"},{\"input\":\"19\",\"output\":\"19\"},{\"input\":\"20\",\"output\":\"Buzz\"},{\"input\":\"21\",\"output\":\"Fizz\"},{\"input\":\"22\",\"output\":\"22\"},{\"input\":\"23\",\"output\":\"23\"},{\"input\":\"24\",\"output\":\"Fizz\"},{\"input\":\"25\",\"output\":\"Buzz\"},{\"input\":\"26\",\"output\":\"26\"},{\"input\":\"27\",\"output\":\"Fizz\"},{\"input\":\"28\",\"output\":\"28\"},{\"input\":\"29\",\"output\":\"29\"},{\"input\":\"30\",\"output\":\"FizzBuzz\"},{\"input\":\"31\",\"output\":\"31\"},{\"input\":\"32\",\"output\":\"32\"},{\"input\":\"33\",\"output\":\"Fizz\"},{\"input\":\"34\",\"output\":\"34\"},{\"input\":\"35\",\"output\":\"Buzz\"},{\"input\":\"36\",\"output\":\"Fizz\"},{\"input\":\"37\",\"output\":\"37\"},{\"input\":\"38\",\"output\":\"38\"},{\"input\":\"39\",\"output\":\"Fizz\"},{\"input\":\"40\",\"output\":\"Buzz\"},{\"input\":\"41\",\"output\":\"41\"},{\"input\":\"42\",\"output\":\"Fizz\"},{\"input\":\"43\",\"output\":\"43\"},{\"input\":\"44\",\"output\":\"44\"},{\"input\":\"45\",\"output\":\"FizzBuzz\"},{\"input\":\"46\",\"output\":\"46\"},{\"input\":\"47\",\"output\":\"47\"},{\"input\":\"48\",\"output\":\"Fizz\"},{\"input\":\"49\",\"output\":\"49\"},{\"input\":\"50\",\"output\":\"Buzz\"},{\"input\":\"51\",\"output\":\"Fizz\"},{\"input\":\"52\",\"output\":\"52\"},{\"input\":\"53\",\"output\":\"53\"},{\"input\":\"54\",\"output\":\"Fizz\"},{\"input\":\"55\",\"output\":\"Buzz\"},{\"input\":\"56\",\"output\":\"56\"},{\"input\":\"57\",\"output\":\"Fizz\"},{\"input\":\"58\",\"output\":\"58\"},{\"input\":\"59\",\"output\":\"59\"},{\"input\":\"60\",\"output\":\"FizzBuzz\"},{\"input\":\"61\",\"output\":\"61\"},{\"input\":\"62\",\"output\":\"62\"},{\"input\":\"63\",\"output\":\"Fizz\"},{\"input\":\"64\",\"output\":\"64\"},{\"input\":\"65\",\"output\":\"Buzz\"},{\"input\":\"66\",\"output\":\"Fizz\"},{\"input\":\"67\",\"output\":\"67\"},{\"input\":\"68\",\"output\":\"68\"},{\"input\":\"69\",\"output\":\"Fizz\"},{\"input\":\"70\",\"output\":\"Buzz\"},{\"input\":\"71\",\"output\":\"71\"},{\"input\":\"72\",\"output\":\"Fizz\"},{\"input\":\"73\",\"output\":\"73\"},{\"input\":\"74\",\"output\":\"74\"},{\"input\":\"75\",\"output\":\"FizzBuzz\"},{\"input\":\"76\",\"output\":\"76\"},{\"input\":\"77\",\"output\":\"77\"},{\"input\":\"78\",\"output\":\"Fizz\"},{\"input\":\"79\",\"output\":\"79\"},{\"input\":\"80\",\"output\":\"Buzz\"},{\"input\":\"81\",\"output\":\"Fizz\"},{\"input\":\"82\",\"output\":\"82\"},{\"input\":\"83\",\"output\":\"83\"},{\"input\":\"84\",\"output\":\"Fizz\"},{\"input\":\"85\",\"output\":\"Buzz\"},{\"input\":\"86\",\"output\":\"86\"},{\"input\":\"87\",\"output\":\"Fizz\"},{\"input\":\"88\",\"output\":\"88\"},{\"input\":\"89\",\"output\":\"89\"},{\"input\":\"90\",\"output\":\"FizzBuzz\"},{\"input\":\"91\",\"output\":\"91\"},{\"input\":\"92\",\"output\":\"92\"},{\"input\":\"93\",\"output\":\"Fizz\"},{\"input\":\"94\",\"output\":\"94\"},{\"input\":\"95\",\"output\":\"Buzz\"},{\"input\":\"96\",\"output\":\"Fizz\"},{\"input\":\"97\",\"output\":\"97\"},{\"input\":\"98\",\"output\":\"98\"},{\"input\":\"99\",\"output\":\"Fizz\"},{\"input\":\"100\",\"output\":\"Buzz\"}]"))
        }
    }

}
