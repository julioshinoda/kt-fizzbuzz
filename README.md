# FizzBuzz

This project is a REST service that expose an endpoint with a  "fizzbuzz" operation

## Requirements

- Java varsion **17( openjdk version "17.0.3" 2022-04-19)**
- Kotlin version **1.7.0-release-281 (JRE 17.0.3+7)**
- Gradle version **7.4.1**
- Docker 

## How to Install

1. Create the docker setup running:
``./gradlew dockerCreateDockerfile
``

2. Build docker image:
``./gradlew dockerBuildImage 
``

3. Run the image: 
``docker run -p 8080:8080 --platform linux/amd64 kt-fizzbuzz``

## How to run the tests

In this project we have unit and integration tests. 
We have added a github actions pipeline for every push in **main** branch the tests are running. 
For running tests locally you can use the command below:

``/gradlew cleanTest test
``

   
## How to use fizzbuzz endpoint

This endpoint use the method GET and the uri is **/fizzbuzz**.

The "fizzbuzz" operation should behave as followed:
- If the entry is a multiple of 3, the output must be "fizz"
- If the entry is a multiple of 5, the output must be "buzz"
- If the entry is a multiple of 3 and 5, the output must be "fizzbuzz"
- Otherwise, the output must be the entry

If you pass the query parameter **entries** the service will return a payload with the response for input.
When you not send the query parameter,the output will be an array with the operation applied to all Integer from 1 to 100. Below examples:

>Example with  query parameter
```curl
curl --request GET \
  --url 'http://localhost:8080/fizzbuzz?entries=1%2C3%2C5%2C15'
```
> Response  with  query parameter
```json
[
  {
    "input": "1",
    "output": "1"
  },
  {
    "input": "3",
    "output": "Fizz"
  },
  {
    "input": "5",
    "output": "Buzz"
  },
  {
    "input": "15",
    "output": "FizzBuzz"
  }
]
```



>Example without  query parameter
```curl
curl --request GET \
  --url 'http://localhost:8080/fizzbuzz
```
> Response  with  query parameter
```
[
	{
		"input": "1",
		"output": "1"
	},
	{
		"input": "2",
		"output": "2"
	},
	{
		"input": "3",
		"output": "Fizz"
	},
	{
		"input": "4",
		"output": "4"
	},
	{
		"input": "5",
		"output": "Buzz"
	},
	.
	.
	.
		{
		"input": "96",
		"output": "Fizz"
	},
	{
		"input": "97",
		"output": "97"
	},
	{
		"input": "98",
		"output": "98"
	},
	{
		"input": "99",
		"output": "Fizz"
	},
	{
		"input": "100",
		"output": "Buzz"
	}
]
```
