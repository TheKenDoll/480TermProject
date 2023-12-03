// SeatSelection.js
import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';

const SeatSelection = () => {
  const [seats, setSeats] = useState([]);
  const [selectedSeat, setSelectedSeat] = useState(null);
  const { flightId } = useParams(); // Extract flightId from the URL
  const navigate = useNavigate();

  useEffect(() => {
    const fetchFlightDetails = async () => {
      try {
        // Check if flightId is defined before making the API call
        if (!flightId) {
          return;
        }

        const response = await fetch(`http://localhost:8080/api/v1/flight`, {

        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${localStorage.getItem("token")}`,
        },

        });
        const data = await response.json();

        // Find the flight with the correct ID
        const selectedFlight = data.find((flight) => flight.id === parseInt(flightId, 10));

        if (selectedFlight) {
          setSeats(selectedFlight.aircraft.seats || []);
        } else {
          console.log(`Flight with ID ${flightId} not found`);
        }
      } catch (error) {
        console.error('Error fetching flight details:', error);
      }
    };

    fetchFlightDetails();
  }, [flightId]);

  // Function to handle seat selection
  const handleSeatSelection = (seat) => {
    if (!seat.available) {
      setSelectedSeat(seat);
    } else {
      alert('Seat unavailable');
    }
  };

  // Function to handle seat confirmation
  const handleSeatConfirmation = async () => {
    if (selectedSeat) {
      try {
        const response = await fetch(`http://localhost:8080/api/v1/seat/${selectedSeat.id}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
            Authorization: `Bearer ${localStorage.getItem("token")}`,

          },
          body: JSON.stringify({
            available: true,
          }),
        });

        if (response.ok) {
          // Successfully updated seat availability
          console.log(`Seat ${selectedSeat.seatNumber} marked as unavailable.`);
          // Navigate to the next page ("/select-insurance" or any other destination)
          navigate('/select-insurance');
        } else {
          console.error('Failed to update seat availability:', response.status, response.statusText);
          // Handle the error as needed
        }
      } catch (error) {
        console.error('Error updating seat availability:', error);
        // Handle the error as needed
      }
    }
  };

  // Function to create a grid layout for seats
  const renderSeatGrid = () => {
    const rows = {};
    seats.forEach((seat) => {
      const [row, col] = seat.seatNumber.match(/\d+|[A-Z]+/g);
      if (!rows[row]) {
        rows[row] = [];
      }
      rows[row].push(seat);
    });

    return Object.keys(rows).map((row) => (
      <div key={row} style={{ display: 'flex', marginBottom: '10px' }}>
        {rows[row].map((seat) => (
          <div
            key={seat.id}
            style={{
              width: '50px',
              height: '50px',
              margin: '5px',
              backgroundColor: !seat.available ? 'green' : 'red',
              cursor: !seat.available ? 'pointer' : 'not-allowed',
            }}
            onClick={() => handleSeatSelection(seat)}
          >
            {seat.seatNumber}
          </div>
        ))}
      </div>
    ));
  };

  return (
    <div style={{ marginTop: '100px', padding: '20px' }}>
      <h1>Flight Details</h1>
      {/* Display other flight details as needed */}

      <h2>Select a Seat</h2>
      {renderSeatGrid()}

      {selectedSeat && !selectedSeat.available && (
        <div>
          <h3>Selected Seat: {selectedSeat.seatNumber}</h3>
          <p>Price: ${selectedSeat.price}</p>
          <button onClick={handleSeatConfirmation}>Confirm Seat</button>
        </div>
      )}

      {selectedSeat && selectedSeat.available && (
        <div>
          <h3>Selected Seat: {selectedSeat.seatNumber}</h3>
          <p>Seat unavailable</p>
        </div>
      )}
    </div>
  );
};

export default SeatSelection;
