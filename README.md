# Scalable E-Commerce Backend System

## Overview

A Spring Boot based RESTful backend application for an e-commerce platform.

The application supports secure user authentication, product management, shopping cart functionality, and order processing using Spring Boot, Spring Security, Spring Data JPA, and MySQL.

---

## Features

- User Registration
- User Login
- BCrypt Password Encryption
- JWT Token Generation
- Product CRUD Operations
- Shopping Cart
- Order Placement
- Order Cancellation
- MySQL Database Integration

---

## Tech Stack

- Java 25
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Git
- Postman

---

## Project Structure

Controller

↓

Service

↓

Repository

↓

MySQL Database

---

## Database Tables

- users
- products
- cart
- cart_items
- orders
- order_items

---

## API Endpoints

### Authentication

POST /api/auth/register

POST /api/auth/login

### Products

GET /api/products

POST /api/products

PUT /api/products/{id}

DELETE /api/products/{id}

### Cart

POST /api/cart/add

GET /api/cart/{userId}

DELETE /api/cart/remove/{id}

### Orders

POST /api/orders/place

GET /api/orders/user/{userId}

PUT /api/orders/cancel/{orderId}

---

## Future Improvements

- JWT Authentication Filter
- Role Based Authorization
- Payment Integration
- Inventory Management
- Swagger Documentation
