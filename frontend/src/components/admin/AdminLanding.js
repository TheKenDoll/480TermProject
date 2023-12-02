import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import SearchFlights from "../flights/SearchFlightsParameters.js";
import FlightDisplay from "../flights/FlightDisplay.js";
import CrewInfoDisplay from "../employee/CrewInfoDisplay.js";
import AircraftInfoDisplay from "../flights/AircraftInfoDisplay.js";
import './AdminLanding.css';

function AdminLanding() {
    const navigate = useNavigate();
      
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
        fetchFlights(searchParams);
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

    // api calls
    const [flights, setFlights] = useState([]);
    const [aircrafts, setAircrafts] = useState([]);
    const [users, setUsers] = useState([]);
    const [crews, setCrews] = useState([]);

    const fetchFlights = async (searchParams)=> {
        console.log(searchParams['origin'], searchParams['destination'], searchParams['date'])
      await fetch(`http://localhost:8080/api/v1/flight/origin/${searchParams['origin']}/destination/${searchParams['destination']}/date/${searchParams['date']}`, {
    
      })
      .then((response ) => response.json())
      .then((data) => setFlights(data))
      .catch((error) => console.log(error))
    };

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

    const fetchUsers = async ()=> {
        await fetch("http://localhost:8080/api/v1/Client", {
      
        })
        .then((response ) => response.json())
        .then((data) => setUsers(data))
        .catch((error) => console.log(error))
      };
      
      useEffect(()=> {
        fetchUsers();
      }, []);

      const fetchCrews = async ()=> {
        await fetch("http://localhost:8080/api/v1/crew", {
      
        })
        .then((response ) => response.json())
        .then((data) => setCrews(data))
        .catch((error) => console.log(error))
      };
      
      useEffect(()=> {
        fetchCrews();
      }, []);

      const handleAddFlight = () => {
        navigate('/add');
      }

    return (
        <div className="admin-container">
            <h1>Logged in as Admin</h1>
            <button className="button" onClick={handleViewFlights}>{showSearch ? 'Hide Search' : 'View Flights'}</button>
            <button className="button" onClick={handleAddFlight} >Add Flight</button>
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
                            <strong>Name:</strong> {user.firstName} {user.lastName}
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