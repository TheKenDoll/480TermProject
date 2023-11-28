// FlightDetails.js
import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const FlightDetails = () => {
  // Accessing the flight ID from the route parameters
  const { flightId } = useParams();
  const navigate = useNavigate();

  // Fetch flight details based on the flightId (this is a placeholder, replace it with your actual logic)
  const flightDetails = {
    origin: 'City A',
    destination: 'City B',
    departureDateTime: '2023-12-01T08:00:00',
    arrivalDateTime: '2023-12-01T10:00:00',
    aircraftType: 'Boeing 737',
    // add other details...
  };

  const handleSelectSeats = () => {
    // Navigate to the Select Seats page with the flight ID
    navigate(`/select-seats/${flightId}`);
  };

  return (
    <div>
      {/* Display flight details */}
      <h2>Flight Details</h2>
      <p>Origin: {flightDetails.origin}</p>
      <p>Destination: {flightDetails.destination}</p>
      <p>Departure Time: {new Date(flightDetails.departureDateTime).toLocaleString()}</p>
      <p>Arrival Time: {new Date(flightDetails.arrivalDateTime).toLocaleString()}</p>
      <p>Aircraft Type: {flightDetails.aircraftType}</p>

      {/* Button to navigate to the Select Seats page */}
      <button onClick={handleSelectSeats}>Select Seats</button>
    </div>
  );
};

export default FlightDetails;
