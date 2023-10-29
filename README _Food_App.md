
# Food Delivery App:
## Overview

This project provides a basic design for the backend of   Food Delivery App . It includes the following features:
- MVC Structure
- Spring Boot framWork ,Java language .
- user  authentication (sign up, sign in ,sing out)
- user profile management (user orders details)
- user orders data Management(order history )
- using Swagger for calling API 

## Table of Contents

- [Introduction](#introduction)
- [dependency](#dependency)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Contributing](#contributing)


## Introduction

The Food Delivery App   simplifies the creating a user sing up , sing in and  user can order food Item and admin can manage the food Item and track all order genrated by user. 

## Dependency
- Spring web 
- Lombok
- validation
- spring JPA
- Swagger 
- MySql drivers 
## Features
- user sing up with encrypting password .
- user sing in with Authenticate receive a token.
- Used bidirectional Mapping (MnayToOne beetween Orders and user ).
- useed unidirectional Mapping(ManyToMany beetween order and Food) .
- used validation .

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- Mavan jar depandancy file created by spring initializr .
- Your favorite Integrated Development Environment (IDE) for Java (e.g., IntelliJ IDEA, Eclipse).
- A REST client (e.g., Postman, cURL) for testing API endpoints.

## Getting Started

Follow these steps to set up and run the  Food Delivery App:

### Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/shashanklodhi1999/MCT_Project-.git
Open the project in your preferred IDE.

Run the Spring Boot application.

Using Maven:

shell
Copy code
mvn spring-boot:run
The application will start on http://13.127.205.141:8080/

 ### MVC Structure
  #### Controller
  - AdminController
  - UserController
 ### Model
 - User
 - Food
 - Orders
 - Admin
 - AuthenticationToken
 ### Repo
 - AdminRepo
 - UserRepo
 - FoodRepo
 - OrderRepo
 - AuthenticationTokenRepo
 ### Service
 - UserService
 - AdminService
 - OrderService
 - FoodService
 - AuthenticationTokenService
 - PasswordEncryptor 


 ## The following API endpoints are available:
 
### Admin Controller 

- POST :-  Admin sing up
  URL: /Admin 

- POST :-   Adding the food 
  URL: /Foods

- DELETE :- Remove the food
  URL: /Food

 - GET :- get food item   
   URL: /FoodItem

 - GET  :- get All Food Item.
   URL: /ALLFoodItem

 - GET :- get All orders.
   URL:- /AllFoodItem 

 - PUT:- update order status
   URL:-Order_Ststus

 - PUT:-Update Food price
   URL:-Food_Price 


### User controller 

- POST :-  user sing up
  URL: /SignUp 

- POST :-  user sing in
  URL: /SignIn

- DELETE :- user sing out
  URL: /SignOut

 - POST :- place the order  
   URL: /order

 - GET  :- get order details by order id .
   URL: /Order

 - GET :-Get all history of user's order by it id .
   URL: /UserHistory  

 - Delete :-  user can Cancel order 
   URL: /CalcelOrder
 
 
# Contributing
Contributions are welcome! Feel free to open issues or submit pull requests to improve this project.