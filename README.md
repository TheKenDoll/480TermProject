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
    - [Airline Endpoints](#airline-endpoints)
    - [Flight Endpoints](#flight-endpoints)

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
  ![Docker](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=white)

- Database

  ![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?style=for-the-badge&logo=Hibernate&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-3e6e93.svg?style=for-the-badge&logo=MySQL&logoColor=white)

- Testing

  ![JUnit](https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white)
  ![Mockito](https://img.shields.io/badge/Mockito-C5D9C8?style=for-the-badge&logo=Mockito&logoColor=white)

- Continuous Integration

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

#### - DELETE `/api/v1/airline/{id}`

Delete an airline by id.

Sample Response Status Code:

`No Content 204`

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
      "airlineId": 1,
      "createdAt": "2023-11-27T13:36:01.893235",
      "updatedAt": "2023-11-27T13:36:01.893421"
    },
    "crew": {
      "id": 1,
      "pilot": {
        "id": 1,
        "firstName": "Axel",
        "lastName": "Sanchez",
        "address": "3500 24 Ave NW",
        "serviceYears": 12,
        "createdAt": "2023-11-27T13:36:01.904314",
        "updatedAt": "2023-11-27T13:36:01.904319"
      },
      "copilot": {
        "id": 1,
        "firstName": "Anahita",
        "lastName": "Akbari",
        "address": "3500 24 Ave NW",
        "serviceYears": 12,
        "createdAt": "2023-11-27T13:36:01.90236",
        "updatedAt": "2023-11-27T13:36:01.902372"
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
        "isAvailable": true,
        "aircraftId": 1
      },
      {
        "seatNumber": "1B",
        "price": 200.0,
        "isAvailable": true,
        "aircraftId": 1
      },
      {
        "seatNumber": "1C",
        "price": 200.0,
        "isAvailable": true,
        "aircraftId": 1
      },
      {
        "seatNumber": "1D",
        "price": 200.0,
        "isAvailable": true,
        "aircraftId": 1
      },
      {
        "seatNumber": "1E",
        "price": 200.0,
        "isAvailable": true,
        "aircraftId": 1
      },
      {
        "seatNumber": "1F",
        "price": 200.0,
        "isAvailable": true,
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

#### - DELETE `/api/v1/flight/{id}`

Delete a flight by id.

Sample Response Status Code:

`No Content 204`
