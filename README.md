Scope : Ticket booking application similar to bookmyshow


User Creation:
POST http://localhost:8080/api/v1/user/register
{"name":"vineet", "email":"vineet@gmail.com","phone":"7042226212","city":"delhi"}

Theatre/Screen/Seat Creation:
POST http://localhost:8080/api/v1/theatre/register
{"name":"pvr", "city":"lucknow", "screen": {"screen1":["A","B","C"], "screen2":["A","B","D"]} }

Movie Creation:
POST http://localhost:8080/api/v1/movie/register
{"name":"sholey", "description":"kitne aadmi they"}

Theatre wise Movie Listing:
POST http://localhost:8080/api/v1/listing/feed
{"movieId":"2", "theatreId":"1", "showTiming":"2024-06-20T13:00", "price":"100", "screenId":"screen1", "active":"true"}

Inventory Creation:
POST http://localhost:8080/api/v1/inventory/create
{"listingId":"1", "seatNameAvailability":{"A":true, "B":false,"C":true}}


Booking Creation:
GET http://localhost:8080/api/v1/booking/create?userId=2&listingId=1&seats=A1 

Read Booking:
GET http://localhost:8080/api/v1/booking/read?userId=1&bookingId=1

Cancel Booking:
GET http://localhost:8080/api/v1/booking/cancel?userId=1&bookingId=1



Read Listing : 
GET http://localhost:8080/api/v1/listing/search?city=lucknow&movieId=2&date=2024-06-20

GET SEAT Listing:
GET http://localhost:8080/api/v1/listing/offer?listingId=1&seats=A1,A2,C1
