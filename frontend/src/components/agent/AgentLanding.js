// Book.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import FlightDisplay from '../agent/DisplayAgentFlights';

const AgentLanding = () => {
  const navigate = useNavigate();
  const [origin, setOrigin] = useState('');
  const [destination, setDestination] = useState('');
  const [date, setDate] = useState('');
  const [dispFlights, setDispFlights] = useState(false);

  const [flights, setFlights] = useState([]);

  const fetchFlights = async (searchParams)=> {
    console.log(searchParams['origin'], searchParams['destination'], searchParams['date'])
    await fetch(`http://localhost:8080/api/v1/flight/origin/${searchParams['origin']}/destination/${searchParams['destination']}/date/${searchParams['date']}`, {

    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${localStorage.getItem("jwt")}`,
    },

    })
    .then((response ) => response.json())
    .then((data) => setFlights(data))
    .catch((error) => console.log(error))
    console.log(flights)
  };

  const handleBookFlight = () => {
    fetchFlights({ origin, destination, date });
    setDispFlights(!dispFlights);
  };

  return (
    <div className="agent-landing-container">
      <h2 className="heading">Book a Flight</h2>
      <form className="flight-form">
        <label className="form-label">
          Origin:
          <input type="text" className="input-field" value={origin} onChange={(e) => setOrigin(e.target.value)} />
        </label>
        <br />

        <label className="form-label">
          Destination:
          <input type="text" className="input-field" value={destination} onChange={(e) => setDestination(e.target.value)} />
        </label>
        <br />

        <label className="form-label">
          Date:
          <input type="date" className="input-field" value={date} onChange={(e) => setDate(e.target.value)} />
        </label>
        <br />

        <button type="button" className="submit-button" onClick={handleBookFlight}>
          Book Flight
        </button>

        {dispFlights && <FlightDisplay data={flights} />}
      </form>
    </div>
  );
};

export default AgentLanding;
