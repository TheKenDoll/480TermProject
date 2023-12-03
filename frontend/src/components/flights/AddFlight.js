import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const AddFlight = () => {
    const navigate = useNavigate();

    let flightTemp ={
        "number": "",
        "destination": "",
        "origin": "",
        "departureTime": "",
        "arrivalTime": "",
        "aircraft": {},
        "crew": {},
        "airlineId": 1
      }

  const [flightNumber, setFlightNumber] = useState("");
  const [destination, setDestination] = useState("");
  const [origin, setOrigin] = useState("");
  const [departureTime, setDepartureTime] = useState("");
  const [arrivalTime, setArrivalTime] = useState("");
  const [aircraft, setAircraft] = useState(flightTemp.aircraft);
  const [crew, setCrew] = useState(flightTemp.crew);
    // Add more state variables for copilot
  // Add more state variables for other fields

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission
    flightTemp.number = flightNumber;
    flightTemp.destination = destination;
    flightTemp.origin = origin;
    flightTemp.departureTime = departureTime;
    flightTemp.arrivalTime = arrivalTime;
    flightTemp.aircraft = aircraft;
    flightTemp.crew = crew;
    
    console.log(flightTemp);
  };

  const [dispAircrafts, setDispAircrafts] = useState(false);
  const [aircrafts, setAircrafts] = useState([]);

  const fetchAircrafts = async ()=> {
    setDispAircrafts(!dispAircrafts);
    await fetch("http://localhost:8080/api/v1/aircraft", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`
      }
    })
    .then((response ) => response.json())
    .then((data) => setAircrafts(data))
    .catch((error) => console.log(error))
  };

  const handleSelectAircraft = (aircraft) => {
    setAircraft(aircraft);
    setDispAircrafts(!dispAircrafts);
  }

  const [dispCrews, setDispCrews] = useState(false);
    const [crews, setCrews] = useState([]);

  const fetchCrews = async ()=> {
    setDispCrews(!dispCrews);
    await fetch("http://localhost:8080/api/v1/crew", {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("jwt")}`
      }
    })
    .then((response ) => response.json())
    .then((data) => setCrews(data))
    .catch((error) => console.log(error))
  };

  const handleSelectCrew = (crew) => {
    setCrew(crew);
    setDispCrews(!dispCrews);
  }

  const handleSave = () => {
    flightTemp.number = flightNumber;
    flightTemp.destination = destination;
    flightTemp.origin = origin;
    flightTemp.departureTime = departureTime;
    flightTemp.arrivalTime = arrivalTime;
    flightTemp.aircraft = aircraft;
    flightTemp.crew = crew;
    // Implement logic to save the edited flight data
    console.log(flightTemp);
    fetch(`http://localhost:8080/api/v1/flight`,
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${localStorage.getItem("jwt")}`
      },
      body: JSON.stringify(flightTemp),
    })

    console.log('Flight saved:', flightTemp);
    navigate('/admin');
  };


  return (
    <div>
      <h1>Add Flight</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Flight Number:
          <input type="text" value={flightNumber} onChange={(e) => setFlightNumber(e.target.value)} />
        </label>
        <label>
          Destination:
          <input type="text" value={destination} onChange={(e) => setDestination(e.target.value)} />
        </label>
        <label>
          Origin:
          <input type="text" value={origin} onChange={(e) => setOrigin(e.target.value)} />
        </label>
        <label>
          Departure Time:
          <input type="date" value={departureTime} onChange={(e) => setDepartureTime(e.target.value)} />
        </label>
        <label>
          Arrival Time:
          <input type="date" value={arrivalTime} onChange={(e) => setArrivalTime(e.target.value)} />
        </label>
        <button onClick={fetchAircrafts}>Get Aircraft</button>
        {dispAircrafts && <>
        <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
        {aircrafts.map((aircraft, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
            <h3>Aircraft Information</h3>
            <div>
                <strong>Aircraft Type:</strong> {aircraft.model}
            </div>
            <div>
                <strong>Aircraft Capacity:</strong> {aircraft.capacity}
            </div>
            <div>
                <strong>Aircraft Manufacture Year:</strong> {aircraft.manufactureYear}
            </div>
            <button onClick={() => handleSelectAircraft(aircraft)}>Select</button>
            </div>
        ))}
        </div>
        </>}

        <button onClick={fetchCrews}>Get Crews</button>
            {dispCrews && <>
            <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
            {crews && crews.map((crew, index) => (
                <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
                <h3>Crew Information</h3>
                <div>
                    <strong>Crew ID:</strong> {crew.id}
                </div>
                <div>
                    <strong>Pilot Name:</strong> {crew.pilot.firstName} {crew.pilot.lastName}
                </div>
                <div>
                    <strong>Copilot Name:</strong> {crew.copilot.firstName} {crew.copilot.lastName}
                </div>

                <button onClick={() => handleSelectCrew(crew)}>Select</button>
                </div>
            ))}
            </div>
        </>}
        <button type="submit" onClick={handleSave}>Add Flight</button>
      </form>
    </div>
  );
};

export default AddFlight;