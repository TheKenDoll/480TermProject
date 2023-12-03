import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import './EditFlight.css';

const EditFlight = () => {
  //const flightNumberParam = match.params.flightNumber;

    const location = useLocation();
    const navigate = useNavigate();

    const recievedData = location.state?.someData || "No data";

    const dataForm =
      {
        "number": recievedData.number,
        "destination": recievedData.destination,
        "origin": recievedData.origin,
        "departureTime": recievedData.departureTime,
        "arrivalTime": recievedData.arrivalTime
      }

  // Find the flight in your data based on the flightNumberParam
  // For simplicity, assuming you have a flightsData array in the same file
  //const flightToEdit = recievedData.find((flight) => flight.flightNumber === flightNumberParam);

  // State to manage form inputs
  const [editedFlight, setEditedFlight] = useState({ ...dataForm });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedFlight((prevFlight) => ({
      ...prevFlight,
      [name]: value,
    }));
  };

  const handleSave = () => {
    // Implement logic to save the edited flight data
    fetch(`http://localhost:8080/api/v1/flight/${recievedData.id}`,
    {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        Authorization:`Bearer ${localStorage.getItem("jwt")}`
      },
      body: JSON.stringify(editedFlight),
    })

    console.log('Flight saved:', editedFlight);
    navigate('/admin');
  };

  return (
    <div className='edit-flight-form'>
      <h2>Edit Flight ID: {editedFlight.id}</h2>
      <form>
        <label>
          Flight Number:
          <input type="text" name="flightNumber" value={editedFlight.number} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Destination:
          <input type="text" name="destination" value={editedFlight.destination} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Origin:
          <input type="text" name="origin" value={editedFlight.origin} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Departure Time:
          <input type="text" name="departureTime" value={editedFlight.departureTime} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Arrival Time:
          <input type="text" name="arrivalTime" value={editedFlight.arrivalTime} onChange={handleInputChange} />
        </label>
        <br />
        <button type="button" onClick={handleSave}>
          Save
        </button>
      </form>
    </div>
  );
};

export default EditFlight;
