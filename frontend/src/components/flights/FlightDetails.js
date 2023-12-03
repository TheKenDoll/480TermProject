// FlightDetails.js
import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';

const FlightDetails = () => {
  const { flightId } = useParams();
  const [flightDetails, setFlightDetails] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchFlightDetails = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/flight', {
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
        });
        const data = await response.json();

        // Find the flight with the correct ID
        const selectedFlight = data.find((flight) => flight.id === parseInt(flightId));

        if (selectedFlight) {
          setFlightDetails(selectedFlight);
        } else {
          console.log(`Flight with ID ${flightId} not found`);
        }
      } catch (error) {
        console.log(error);
      }
    };

    fetchFlightDetails();
  }, [flightId]);

  if (!flightDetails) {
    return <p>Loading...</p>;
  }

  const handleSelectSeats = () => {
    // Navigate to the Select Seats page with the flight ID
    navigate(`/select-seats/${flightDetails.id}`);
  };

  return (
    <div style={{ marginTop: '100px', padding: '20px' }}>
      {/* Display flight details */}
      <h2>Flight Details</h2>
      <p>Flight ID: {flightDetails.id}</p>
      <p>Flight Number: {flightDetails.number}</p>
      <p>Origin: {flightDetails.origin}</p>
      <p>Destination: {flightDetails.destination}</p>
      <p>Departure Time: {new Date(flightDetails.departureTime).toLocaleString()}</p>
      <p>Arrival Time: {new Date(flightDetails.arrivalTime).toLocaleString()}</p>
      <p>Aircraft Type: {flightDetails.aircraft.model}</p>

      {/* Button to navigate to the Select Seats page */}
      <button onClick={handleSelectSeats}>Select Seats</button>
    </div>
  );
};

export default FlightDetails;
