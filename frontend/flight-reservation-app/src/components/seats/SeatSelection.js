// SeatSelection.js
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import SeatMap from './SeatMap';
import { Link } from 'react-router-dom';

const SeatSelection = () => {
  const { flightId } = useParams();
  const [seats, setSeats] = useState([]);
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatSelected = (seat) => {
    setSelectedSeat(seat);
  };

  // Assuming you have a route to the insurance page
  const insuranceRoute = `/select-insurance/${flightId}`;


  useEffect(() => {
    const fetchFlightDetails = async () => {
      try {
        const response = await fetch(`http://localhost:8080/api/v1/flight`);
        const data = await response.json();

        // Find the flight with the correct ID
        const selectedFlight = data.find((flight) => flight.id === parseInt(flightId));

        if (selectedFlight) {
          setSeats(selectedFlight);
        } else {
          console.log(`Flight with ID ${flightId} not found`);
        }
      } catch (error) {
        console.error('Error fetching flight details:', error);
      }
    };
    

    fetchFlightDetails();
  }, [flightId]);



  return (
    <div>
      <h2>Select Seats</h2>
      <SeatMap seats={seats} onSeatSelected={handleSeatSelected} />

      {selectedSeat && (
        <div>
          <p>Selected Seat: {selectedSeat.seatNumber}</p>
          <Link to={insuranceRoute}>
            <button>Proceed to Insurance</button>
          </Link>
        </div>
      )}
    </div>
  );
};

export default SeatSelection;