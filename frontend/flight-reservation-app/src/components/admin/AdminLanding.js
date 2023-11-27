import React, { useState } from "react";
import SearchFlights from "../flights/SearchFlightsParameters.js";
import FlightDisplay from "../flights/FlightDisplay.js";
import CrewInfoDisplay from "../employee/CrewInfoDisplay.js";
import AircraftInfoDisplay from "../flights/AircraftInfoDisplay.js";

function AdminLanding() {
    let flights = [
        {
          "flightNumber": "AB123",
          "destination": "Sydney",
          "origin": "Melbourne",
          "aircraftType": "Boeing 737",
          "crew": [
            {
              "name": "John Smith",
              "role": "Pilot"
            },
            {
              "name": "Jane Doe",
              "role": "Flight Attendant"
            }
          ],
          "seatList": [
            {
              "seatNumber": "1A",
              "seatType": "Economy",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "1B",
              "seatType": "Economy",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "2A",
              "seatType": "Economy",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "2B",
              "seatType": "Economy",
              "seatAvailability": "Available"
            }
          ],
          "departureTime": "2021-09-01T12:00:00.000Z",
          "arrivalTime": "2021-09-01T14:00:00.000Z"
        },
        {
          "flightNumber": "CD456",
          "destination": "Tokyo",
          "origin": "Seoul",
          "aircraftType": "Airbus A380",
          "crew": [
            {
              "name": "Emily Kim",
              "role": "Pilot"
            },
            {
              "name": "David Lee",
              "role": "Flight Attendant"
            }
          ],
          "seatList": [
            {
              "seatNumber": "3A",
              "seatType": "Business",
              "seatAvailability": "Occupied"
            },
            {
              "seatNumber": "3B",
              "seatType": "Business",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "4A",
              "seatType": "Economy",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "4B",
              "seatType": "Economy",
              "seatAvailability": "Available"
            }
          ],
          "departureTime": "2021-09-02T09:30:00.000Z",
          "arrivalTime": "2021-09-02T13:00:00.000Z"
        },
        {
          "flightNumber": "EF789",
          "destination": "Paris",
          "origin": "London",
          "aircraftType": "Boeing 777",
          "crew": [
            {
              "name": "Sophie Miller",
              "role": "Pilot"
            },
            {
              "name": "Oliver Turner",
              "role": "Flight Attendant"
            }
          ],
          "seatList": [
            {
              "seatNumber": "5A",
              "seatType": "First Class",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "5B",
              "seatType": "First Class",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "6A",
              "seatType": "Business",
              "seatAvailability": "Available"
            },
            {
              "seatNumber": "6B",
              "seatType": "Business",
              "seatAvailability": "Available"
            }
          ],
          "departureTime": "2021-09-03T15:45:00.000Z",
          "arrivalTime": "2021-09-03T18:30:00.000Z"
        }
      ]

    let aircrafts = [
        {
            "aircraftType": "Boeing 737",
            "aircraftCapacity": 150,
            "available" : true
        },
        {
            "aircraftType": "Airbus A380",
            "aircraftCapacity": 300,
            "available" : true
        },
        {
            "aircraftType": "Boeing 777",
            "aircraftCapacity": 250,
            "available" : true
        }
    ]

    let crews = [
        {   
            'crewId': 1,
            'available': true,
            'flightNumber': 'AB123',
            'crew' :
            [
                {
                    "name": "John Smith",
                    "role": "Pilot"
                },
                {
                    "name": "Jane Doe",
                    "role": "Flight Attendant"
                }
            ]
        },
        {
            'crewId': 2,
            'available': true,
            'flightNumber': 'CD456',
            'crew' :
            [
                {
                    "name": "Emily Kim",
                    "role": "Pilot"
                },
                {
                    "name": "David Lee",
                    "role": "Flight Attendant"
                }
            ]
        },
        {
            'crewId': 3,
            'available': false,
            'flightNumber': 'EF789',
            'crew' :
            [
                {
                    "name": "Sophie Miller",
                    "role": "Pilot"
                },
                {
                    "name": "Oliver Turner",
                    "role": "Flight Attendant"
                }
            ]
        }
    ]

    let users = [
        {
            'name': 'John Smith',
            'email': 'example@gmail.com',
            'password': 'password'
        },
        {
            'name': 'Jane Doe',
            'email': 'example@gmail.com',
            'password': 'password'
        }
    ]
      

    const [showSearch, setShowSearch] = useState(false);
    const [dispFlights, setdispFlights] = useState(false);
    const [dispAircrafts, setdispAircrafts] = useState(false);
    const [dispCrews, setdispCrews] = useState(false);
    const [dispUsers, setdispUsers] = useState(false);

    const handleViewFlights = () => {
        if (dispFlights) {
            setdispFlights(!dispFlights);
        }
        setShowSearch(!showSearch);
    }

    const handleDispFlights = () => {
        setdispFlights(!dispFlights);
    }

    const handleSerachFlights = (searchParams) => {
        console.log(searchParams);
        handleDispFlights();
    }

    const handleDispAircraft = () => {
        setdispAircrafts(!dispAircrafts);
    }

    const handleDispCrews = () => {
        setdispCrews(!dispCrews);
    }

    const handleDispUsers = () => {
        setdispUsers(!dispUsers);
    }

    return (
        <div>
            <h1>Logged in as Admin</h1>
            <button onClick={handleViewFlights}>{showSearch ? 'Hide Search' : 'View Flights'}</button>
            {showSearch && <SearchFlights onSearch={handleSerachFlights} />}
            {dispFlights && <FlightDisplay data={flights} />}
            <button onClick={handleDispAircraft}>{dispAircrafts ? 'Hide Aircrafts' : 'View Aircrafts'}</button>
            {dispAircrafts && <AircraftInfoDisplay aircraftInfo={aircrafts} />}
            <button onClick={handleDispCrews}>{dispCrews ? 'Hide Crews' : 'View Crews'}</button>
            {dispCrews && <CrewInfoDisplay crewInfo={crews} />}
            <button onClick={handleDispUsers}>{dispUsers ? 'Hide Users' : 'View Users'}</button>
            <div style={{ maxHeight: '300px', overflowY: 'auto' }}>
                {dispUsers && users.map((user, index) => (
                    <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
                        <h3>User Information</h3>
                        <div>
                            <strong>Name:</strong> {user.name}
                        </div>
                        <div>
                            <strong>Email:</strong> {user.email}
                        </div>
                        <div>
                            <strong>Password:</strong> {user.password}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default AdminLanding