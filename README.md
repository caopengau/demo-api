# demo-api
To see the full step by step guide here https://medium.com/@caopengau/vs-code-java-springboot-a-step-by-step-guide-beb61a4eb70c

## Run the project
## Visit http://localhost:8080/ to see the helloworld response
## Make post request to http://localhost:8080/ with below json body
```
{
  "transactionId": "111",
  "customers": [
    {
      
      "name": "Alert",
      "age": 72
    }
  ]
}
```
to see it transformed to
```
{
  "transactionId": "111",
  "tickets": [
    {
      "ticketType": "Senior",
      "quantity": 1,
      "totalCost": 17.5
    }
  ],
  "totalCost": 17.5
}
```


![1_-98btCURBMb5aHPTENcJ-Q](https://user-images.githubusercontent.com/18650321/199451632-b9144253-7784-4d8c-b530-7a1a12122dc3.png)
