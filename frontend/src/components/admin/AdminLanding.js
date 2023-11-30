import React, { useState, useEffect } from "react";
import SearchFlights from "../flights/SearchFlightsParameters.js";
import FlightDisplay from "../flights/FlightDisplay.js";
import CrewInfoDisplay from "../employee/CrewInfoDisplay.js";
import AircraftInfoDisplay from "../flights/AircraftInfoDisplay.js";
import './AdminLanding.css';

function AdminLanding() {

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
    const [dispTest, setdispTest] = useState(false);

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

    const handleTest = () => {
        console.log('test');
        setdispTest(!dispTest);
    }

    // api calls
    const [flights, setFlights] = useState([]);
    const [aircrafts, setAircrafts] = useState([]);

    const fetchFlights = async ()=> {
      await fetch("http://localhost:8080/api/v1/flight", {
    
      })
      .then((response ) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => console.log(error))
    };
    
    useEffect(()=> {
      fetchFlights();
    }, []);

    const fetchAircrafts = async ()=> {
      await fetch("http://localhost:8080/api/v1/aircraft", {
    
      })
      .then((response ) => response.json())
      .then((data) => setAircrafts(data))
      .catch((error) => console.log(error))
    };
    
    useEffect(()=> {
      fetchAircrafts();
    }, []);

    return (
        <div className="admin-container">
            <h1>Logged in as Admin</h1>
            <button className="button" onClick={handleViewFlights}>{showSearch ? 'Hide Search' : 'View Flights'}</button>
            {showSearch && <SearchFlights onSearch={handleSerachFlights} />}
            {dispFlights && <FlightDisplay data={flights} />}
            <button className="button" onClick={handleDispAircraft}>{dispAircrafts ? 'Hide Aircrafts' : 'View Aircrafts'}</button>
            {dispAircrafts && <AircraftInfoDisplay aircraftInfo={aircrafts} />}
            <button className="button" onClick={handleDispCrews}>{dispCrews ? 'Hide Crews' : 'View Crews'}</button>
            {dispCrews && <CrewInfoDisplay crewInfo={crews} />}
            <button className="button" onClick={handleDispUsers}>{dispUsers ? 'Hide Users' : 'View Users'}</button>
            <div className="scrollable">
                {dispUsers && users.map((user, index) => (
                    <div key={index} className="user-info">
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
            <button className="button" onClick={handleTest}>test</button>
            {dispTest && <div>test</div>}
        </div>
    )
}

export default AdminLanding