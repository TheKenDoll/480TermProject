# 🛩️ Airline Reservation Web Application

[![Continuous Integration](https://github.com/TheKenDoll/480TermProject/actions/workflows/maven.yml/badge.svg)](https://github.com/TheKenDoll/480TermProject/actions/workflows/maven.yml)
![GitHub repo size](https://img.shields.io/github/repo-size/TheKenDoll/480TermProject?logo=github&color=blue)
![Github tag](https://img.shields.io/github/v/tag/TheKenDoll/480TermProject?logo=github&color=red)
![GitHub contributors](https://img.shields.io/github/contributors/TheKenDoll/480TermProject?logo=github&color=yellow)
![Github pull requests](https://img.shields.io/github/issues-pr/TheKenDoll/480TermProject?logo=github)
![Github license](https://img.shields.io/github/license/TheKenDoll/480TermProject?logo=github&color=orange)

## 📖 Table of Contents

- [🔎 Overview](#-overview)
- [📝 Contributors](#-contributors)
- [👨‍💻 Teck Stack](#-teck-stack)
- [🚀 Backend Documentation](#-backend-documentation)
  - [🏃 Quickstart](#-quickstart)
  - [🛠️ Installation](#️-installation)
  - [🌐 Endpoints](#-endpoints)
    - [Authentication Endpoints](#authentication-endpoints)
      - [POST `/api/v1/auth/register`](#---apiv1authregister)
      - [POST `/api/v1/auth/authenticate`](#---apiv1authauthenticate)
    - [Airline Endpoints](#airline-endpoints)
      - [GET `/api/v1/airline`](#---apiv1airline)
      - [POST `/api/v1/airline`](#---apiv1airline-1)
      - [GET `/api/v1/airline/{id}`](#---apiv1airlineid)
      - [DELETE `/api/v1/airline/{id}`](#---apiv1airlineid-1)
    - [Flight Endpoints](#flight-endpoints)
      - [GET `/api/v1/flight`](#---apiv1flight)
      - [POST `/api/v1/flight`](#---apiv1flight-1)
      - [PUT `/api/v1/flight/{id}`](#---apiv1flightid)
      - [DELETE `/api/v1/flight/{id}`](#---apiv1flightid-1)
      - [GET `/api/v1/flight/origin/{origin}`](#---apiv1flightoriginorigin)
      - [GET `/api/v1/flight/destination/{destination}`](#---apiv1flightdestinationdestination)
      - [GET `/api/v1/flight/origin/{origin}/destination/{destination}/date/{date}`](#---apiv1flightoriginorigindestinationdestinationdatedate)
    - [Seat Endpoints](#seat-endpoints)
      - [PUT `/api/v1/seat/{id}`](#---apiv1seatid)
    - [Crew Endpoints](#crew-endpoints)
      - [GET `/api/v1/crew`](#---apiv1crew)
      - [POST `/api/v1/crew`](#---apiv1crew-1)
      - [DELETE `/api/v1/crew/{id}`](#---apiv1crewid)

## 🔎 Overview

The Airline Reservation Web Application is a sophisticated online application designed to serve various users including tourist agents, airline operators and program managers. This application offers a wide range of features aimed at improving experience.

## 📝 Contributors

- [Kenzie Fjestad]() - Frontend Developer
- [Charlie Lang]() - Frontend Developer
- [Bernard Aire]() - Backend Developer
- [Axel Sanchez](https://github.com/Axeloooo) - Backend Developer

## 👨‍💻 Teck Stack

- Frontend

  ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=for-the-badge&logo=JavaScript&logoColor=black)
  ![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)

- Backend

  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white)

- Database

  ![MySQL](https://img.shields.io/badge/MySQL-3e6e93.svg?style=for-the-badge&logo=MySQL&logoColor=white)
  ![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?style=for-the-badge&logo=Hibernate&logoColor=white)

- Testing

  ![JUnit](https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white)
  ![Mockito](https://img.shields.io/badge/Mockito-C5D9C8?style=for-the-badge&logo=Mockito&logoColor=white)

- Continuous Integration

  ![Docker](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=white)
  ![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-000000.svg?style=for-the-badge&logo=GitHub-Actions&logoColor=white)

## 🚀 Backend Documentation

All the code is located in the `backend` folder. The backend is a REST API built using [spring boot](https://spring.io/projects/spring-boot).

### 🏃 Quick Start

1. Open the terminal and clone this repository using HTTPS or SSH (The example below uses SSH).

```bash
git clone git@github.com:TheKenDoll/480TermProject.git
```

2. `cd` into the `backend` directory.

```bash
cd backend
```

3. Ask the repository owner for the `.env` file and place it in the `backend` directory. Otherwise, you will not be able to run the server.

4. Run `docker-compose up -d` to start the database.

```bash
docker-compose up -d
```

5. Run `./mvnw spring-boot:run` to start the server.

```bash
./mvnw spring-boot:run
```

6. Open your browser and navigate to `http://localhost:8080` to see the server running.

```bash
http://localhost:8080
```

## 🛠️ Installation

1. Make sure you have `Java 17` installed. Click [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) to download and install this version of Java.

2. Open the terminal and `java -version` to make sure you have the correct version of Java installed.

```bash
java -version
```

3. If you see the version of Java you installed, you are good to go. If not, make sure you have the correct version of Java installed.

4. Make sure you have `Docker Desktop` installed on your machine. Click [here](https://www.docker.com/products/docker-desktop) to download and install Docker Desktop. Make sure you install the latest version.

5. Open the terminal and run `docker -v` to check if `Docker` is installed.

```bash
docker -v
```

6. In the same terminal run `docker-compose -v` to check if `Docker Compose` is installed.

```bash
docker-compose -v
```

7. If you see the version number of `Docker` and `Docker Compose` then you are good to go. If not, then try to reinstall `Docker Desktop`.

8. Make sure you have `Git` installed on your machine. Click [here](https://git-scm.com/downloads) to download and install Git. Make sure you install the latest version.

9. Open the terminal and run `git -v` to check if `Git` is installed.

```bash
git -v
```

10. If you see the version number of `Git` then you are good to go. If not, then try to reinstall `Git`.

11. Make sure you have `Maven` installed on your machine. Click [here](https://maven.apache.org/download.cgi) to download and install Maven. Make sure you install the latest version.

12. Open the terminal and run `mvn -v` to check if `Maven` is installed.

```bash
mvn -v
```

13. If you see the version number of `Maven` then you are good to go. If not, then try to reinstall `Maven`.

## 🌐 Endpoints

All endpoints are protected by [JWT](https://jwt.io/). You must be authenticated to access them. To authenticate, you must first create a user by sending a `POST` request to `/api/v1/auth/register`. Then, you can authenticate by sending a `POST` request to `/api/v1/auth/authenticate`. You will receive a `JWT` token in the response body. You must include this token in the `Authorization` header type of all requests. The token must be prefixed with `Bearer`. For example, `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmFoaXRhQG1haWwuY29tIiwiaWF0IjoxNjM5MjIwNjQ4LCJleHAiOjE` is a valid token.

### Authentication Endpoints

#### - POST `/api/v1/auth/register`

Create a new user.

Sample Request Body:

```json
{
  "firstName": "user",
  "lastName": "user",
  "email": "axel@mail.com",
  "password": "1234"
}
```

Sample Response Status Code:

`Created 201`

Sample Response Body:

```json
{
  "token": "higvfiyu6hb4j35rvyuvcfiuk4v5y7k654v6kjgvcy23vlv"
}
```

#### - POST `/api/v1/auth/authenticate`

Authenticate a user.

Sample Request Body:

```json
{
  "email": "axel@mail.com",
  "password": "1234"
}
```

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
{
  "token": "higvfiyu6hb4j35rvyuvcfiuk4v5y7k654v6kjgvcy23vlv"
}
```

### Airline Endpoints

#### - GET `/api/v1/airline`

Return all airlines.

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
[
  {
    "id": 1,
    "name": "Air Canada",
    "country": "Canada",
    "crews": [],
    "aircrafts": [],
    "flights": [],
    "createdAt": "2023-11-27T17:39:24.881032",
    "updatedAt": "2023-11-27T17:39:24.881088"
  }
]
```

#### - POST `/api/v1/airline`

Create a new airline.

Sample Request Body:

```json
{
  "name": "Air Canada",
  "country": "Canada"
}
```

Sample Response Status Code:

`Created 201`

#### - GET `/api/v1/airline/{id}`

Return an airline by id.

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
{
  "id": 1,
  "name": "Air Canada",
  "country": "Canada",
  "crews": [
    {
      ...
    }
  ],
  "aircrafts": [
    {
      ...
    }
  ],
  "flights": [
    {
      ...
    }
  ],
  "createdAt": "2023-11-27T17:39:24.881032",
  "updatedAt": "2023-11-27T17:39:24.881088"
}
```

#### - DELETE `/api/v1/airline/{id}`

Delete an airline by id.

Sample Response Status Code:

`Ok 200`

### Flight Endpoints

#### - GET `/api/v1/flight`

Return all flights.

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
[
  {
    "id": 1,
    "number": "AC101",
    "destination": "Toronto",
    "origin": "Calgary",
    "departureTime": "2023-11-29",
    "arrivalTime": "2023-11-29",
    "aircraft": {
      "id": 1,
      "model": "Boeing 737",
      "manufactureYear": 2010,
      "capacity": 200,
      "seats": [
        {
          ...
        }
      ],
      "airlineId": 1,
      "createdAt": "2023-11-27T13:36:01.893235",
      "updatedAt": "2023-11-27T13:36:01.893421"
    },
    "crew": {
      "id": 1,
      "pilot": {
        ...
      },
      "copilot": {
        ...
      },
      "flightAttendants": [],
      "airlineId": 1,
      "createdAt": "2023-11-27T13:36:01.906349",
      "updatedAt": "2023-11-27T13:36:01.906354"
    },
    "airlineId": 1,
    "createdAt": "2023-11-27T13:36:01.908025",
    "updatedAt": "2023-11-27T13:36:01.90803"
  }
]
```

#### POST `/api/v1/flight`

Create a new flight.

Sample Request Body:

```json
{
  "number": "AC101",
  "destination": "Toronto",
  "origin": "Calgary",
  "departureTime": "2023-11-29",
  "arrivalTime": "2023-11-29",
  "aircraft": {
    "model": "Boeing 737",
    "manufactureYear": 2010,
    "capacity": 200,
    "seats": [
      {
        "seatNumber": "1A",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      },
      {
        "seatNumber": "1B",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      },
      {
        "seatNumber": "1C",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      },
      {
        "seatNumber": "1D",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      },
      {
        "seatNumber": "1E",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      },
      {
        "seatNumber": "1F",
        "price": 200.0,
        "available": true,
        "seatClass": "Bussiness",
        "aircraftId": 1
      }
    ],
    "airlineId": 1
  },
  "crew": {
    "pilot": {
      "firstName": "Axel",
      "lastName": "Sanchez",
      "address": "3500 24 Ave NW",
      "serviceYears": 12
    },
    "copilot": {
      "firstName": "Anahita",
      "lastName": "Akbari",
      "address": "3500 24 Ave NW",
      "serviceYears": 12
    },
    "airlineId": 1
  },
  "airlineId": 1
}
```

Sample Response Status Code:

`Created 201`

#### - PUT `/api/v1/flight/{id}`

Update a flight by id.

Sample Request Body:

```json
{
  "number": "AC102",
  "destination": "Mexico City",
  "origin": "Calgary",
  "departureTime": "2023-12-29",
  "arrivalTime": "2023-12-29"
}
```

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
{
  "number": "AC102",
  "destination": "Mexico City",
  "origin": "Calgary",
  "departureTime": "2023-12-29",
  "arrivalTime": "2023-12-29",
  "aircraft": {
    "model": "Boeing 737",
    "manufactureYear": 2010,
    "capacity": 200,
    "seats": [
      {
        ...
      }
    ],
    "airlineId": 1
  },
  "crew": {
    "pilot": {
      ...
    },
    "copilot": {
      ...
    },
    "airlineId": 1
  },
  "airlineId": 1
}
```

#### - DELETE `/api/v1/flight/{id}`

Delete a flight by id.

Sample Response Status Code:

`Ok 200`

#### - GET `/api/v1/flight/origin/{origin}`

Return all flights by origin.

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
[
  {
    "id": 1,
    "number": "AC101",
    "destination": "Vancouver",
    "origin": "Calgary",
    "departureTime": "2023-11-29",
    "arrivalTime": "2023-11-29",
    "aircraft": {
      "id": 1,
      "model": "Boeing 737",
      "manufactureYear": 2010,
      "capacity": 200,
      "seats": [
        {
          ...
        }
      ],
      "airlineId": 1,
      "createdAt": "2023-11-27T21:20:14.196198",
      "updatedAt": "2023-11-27T21:20:14.196356"
    },
    "crew": {
      "id": 1,
      "pilot": {
        ...
      },
      "copilot": {
        ...
      },
      "flightAttendants": [],
      "airlineId": 1,
      "createdAt": "2023-11-27T21:20:14.250589",
      "updatedAt": "2023-11-27T21:20:14.250689"
    },
    "airlineId": 1,
    "createdAt": "2023-11-27T21:20:14.259514",
    "updatedAt": "2023-11-27T21:20:14.259574"
  },
  {
    "id": 3,
    "number": "AC101",
    "destination": "Toronto",
    "origin": "Calgary",
    "departureTime": "2023-11-29",
    "arrivalTime": "2023-11-29",
    "aircraft": {
      "id": 3,
      "model": "Boeing 737",
      "manufactureYear": 2010,
      "capacity": 200,
      "seats": [
        {
          ...
        }
      ],
      "airlineId": 1,
      "createdAt": "2023-11-27T22:53:30.800557",
      "updatedAt": "2023-11-27T22:53:30.800661"
    },
    "crew": {
      "id": 3,
      "pilot": {
        ...
      },
      "copilot": {
        ...
      },
      "flightAttendants": [],
      "airlineId": 1,
      "createdAt": "2023-11-27T22:53:30.851216",
      "updatedAt": "2023-11-27T22:53:30.851229"
    },
    "airlineId": 1,
    "createdAt": "2023-11-27T22:53:30.853032",
    "updatedAt": "2023-11-27T22:53:30.853046"
  }
]
```

#### - GET `/api/v1/flight/destination/{destination}`

Return all flights by destination.

Sample Response Status Code:

`Ok 200`

Sample Response Body

```json
[
  {
    "id": 1,
    "number": "AC101",
    "destination": "Vancouver",
    "origin": "Calgary",
    "departureTime": "2023-11-29",
    "arrivalTime": "2023-11-29",
    "aircraft": {
      "id": 1,
      "model": "Boeing 737",
      "manufactureYear": 2010,
      "capacity": 200,
      "seats": [
        {
          ...
        }
      ],
      "airlineId": 1,
      "createdAt": "2023-11-27T21:20:14.196198",
      "updatedAt": "2023-11-27T21:20:14.196356"
    },
    "crew": {
      "id": 1,
      "pilot": {
        ...
      },
      "copilot": {
        ...
      },
      "flightAttendants": [],
      "airlineId": 1,
      "createdAt": "2023-11-27T21:20:14.250589",
      "updatedAt": "2023-11-27T21:20:14.250689"
    },
    "airlineId": 1,
    "createdAt": "2023-11-27T21:20:14.259514",
    "updatedAt": "2023-11-27T21:20:14.259574"
  },
  {
    "id": 6,
    "number": "AC101",
    "destination": "Vancouver",
    "origin": "Toronto",
    "departureTime": "2023-11-29",
    "arrivalTime": "2023-11-29",
    "aircraft": {
      "id": 6,
      "model": "Boeing 737",
      "manufactureYear": 2010,
      "capacity": 200,
      "seats": [
        {
          ...
        }
      ],
      "airlineId": 1,
      "createdAt": "2023-11-27T23:02:53.553053",
      "updatedAt": "2023-11-27T23:02:53.55341"
    },
    "crew": {
      "id": 6,
      "pilot": {
        ...
      },
      "copilot": {
        ...
      },
      "flightAttendants": [],
      "airlineId": 1,
      "createdAt": "2023-11-27T23:02:53.609365",
      "updatedAt": "2023-11-27T23:02:53.609395"
    },
    "airlineId": 1,
    "createdAt": "2023-11-27T23:02:53.614279",
    "updatedAt": "2023-11-27T23:02:53.614294"
  }
]
```

#### - GET `/api/v1/flight/origin/{origin}/destination/{destination}/date/{date}`

Return all flights by origin, destination and date.

Sample Response Status Code:

`Ok 200`

```json
[
    {
        "id": 1,
        "number": "AC101",
        "destination": "Vancouver",
        "origin": "Calgary",
        "departureTime": "2023-11-29",
        "arrivalTime": "2023-11-29",
        "aircraft": {
            "id": 1,
            "model": "Boeing 737",
            "manufactureYear": 2010,
            "capacity": 200,
            "seats": [
                {
                    ...
                }
            ],
            "airlineId": 1,
            "createdAt": "2023-11-27T21:20:14.196198",
            "updatedAt": "2023-11-27T21:20:14.196356"
        },
        "crew": {
            "id": 1,
            "pilot": {
                ...
            },
            "copilot": {
                ...
            },
            "flightAttendants": [],
            "airlineId": 1,
            "createdAt": "2023-11-27T21:20:14.250589",
            "updatedAt": "2023-11-27T21:20:14.250689"
        },
        "airlineId": 1,
        "createdAt": "2023-11-27T21:20:14.259514",
        "updatedAt": "2023-11-27T21:20:14.259574"
    }
]
```

### Seat Endpoints

#### - PUT `/api/v1/seat/{id}`

Update a seat by id.

Sample Request Body:

```json
{
  "available": false
}
```

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
{
  "id": 1,
  "seatNumber": "1A",
  "price": 200.0,
  "available": false,
  "seatClass": "Bussiness",
  "aircraftId": 1,
  "createdAt": "2023-11-27T21:20:14.196198",
  "updatedAt": "2023-11-27T21:20:14.196356"
}
```

### Crew Endpoints

#### - GET `/api/v1/crew`

Return all crews.

Sample Response Status Code:

`Ok 200`

Sample Response Body:

```json
[
  {
    "id": 1,
    "pilot": {
      "id": 1,
      "firstName": "Axel",
      "lastName": "Sanchez",
      "address": "3500 24 Ave NW",
      "serviceYears": 12,
      "createdAt": "2023-11-30T14:07:32.779914",
      "updatedAt": "2023-11-30T14:07:32.779926"
    },
    "copilot": {
      "id": 1,
      "firstName": "Anahita",
      "lastName": "Akbari",
      "address": "3500 24 Ave NW",
      "serviceYears": 12,
      "createdAt": "2023-11-30T14:07:32.777381",
      "updatedAt": "2023-11-30T14:07:32.777405"
    },
    "flightAttendants": [],
    "airlineId": 1,
    "createdAt": "2023-11-30T14:07:32.782011",
    "updatedAt": "2023-11-30T14:07:32.782024"
  }
]
```

#### - POST `/api/v1/crew`

Sample Request Body:

```json
{
  "pilotId": 1,
  "copilotId": 1,
  "airlineId": 1
}
```

Sample Response Status Code:

`Created 201`

#### - DELETE `/api/v1/crew/{id}`

Delete a crew by id.

Sample Response Status Code:

`Ok 200`
