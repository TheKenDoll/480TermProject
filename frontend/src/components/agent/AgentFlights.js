// FlightList.js
import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import FlightShow from '../flights/FlightShow';

const AgentFlights = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [flights, setFlights] = useState([]);

  const criteria = location.state || {};
  const { origin, destination, date } = criteria;

  const fetchFlights = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/v1/flight/origin/${origin}/destination/${destination}/date/${date}`, {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },
      });
      const data = await response.json();
      setFlights(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchFlights();
  }, [origin, destination, date]);

  const handleFlightSelect = (flight) => {
    navigate(`/flight-details/${flight.id}`);
  };

  return (
    <div>
      <h2>Flight List</h2>

      {flights.length > 0 ? (
        <div>
          {flights.map((flight) => (
            <FlightShow key={flight.id} flight={flight} onSelect={() => handleFlightSelect(flight)} />
          ))}
        </div>
      ) : (
        <p>No flights available</p>
      )}
    </div>
  );
};

export default AgentFlights;
