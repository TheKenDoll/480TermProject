// Book.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Book.css';

const Book = ({ setLoggedIn }) => {
  const [origin, setOrigin] = useState('YYC');
  const [destination, setDestination] = useState('');
  const [tripType, setTripType] = useState('round-trip');
  const [departureDate, setDepartureDate] = useState('');
  const [returnDate, setReturnDate] = useState('');
  const [flights, setFlights] = useState([]);
  const navigate = useNavigate();

  const handleOriginChange = (e) => {
    setOrigin(e.target.value);
  };

  const handleDestinationChange = (e) => {
    setDestination(e.target.value);
  };

  const handleTripTypeChange = (e) => {
    setTripType(e.target.value);
    setReturnDate('');
  };

  const handleDepartureDateChange = (e) => {
    setDepartureDate(e.target.value);
  };

  const handleReturnDateChange = (e) => {
    setReturnDate(e.target.value);
  };

  const handleBookFlight = () => {
    // Simulate fetching flight data based on user input
    const fakeFlightData = [
      { id: 1, origin, destination, departureDate, returnDate: tripType === 'round-trip' ? returnDate : null },
      // Add more fake flight data as needed
    ];

    // Update the flights state with the fetched data
    setFlights(fakeFlightData);

    // Update the login status
    setLoggedIn(true);

    // Navigate to the /flights route
    navigate('/flights');
  };

  return (
    <div className="book-container">
      <h2>Book a Flight</h2>
      <div>
        <label htmlFor="origin">Origin:</label>
        <input
          type="text"
          id="origin"
          value={origin}
          onChange={handleOriginChange}
          readOnly
        />
      </div>
      <div>
        <label htmlFor="destination">Destination:</label>
        <input
          type="text"
          id="destination"
          value={destination}
          onChange={handleDestinationChange}
        />
      </div>
      <div>
        <label htmlFor="tripType">Trip Type:</label>
        <select id="tripType" value={tripType} onChange={handleTripTypeChange}>
          <option value="round-trip">Round Trip</option>
          <option value="one-way">One Way</option>
        </select>
      </div>
      <div>
        <label htmlFor="departureDate">Departure Date:</label>
        <input
          type="date"
          id="departureDate"
          value={departureDate}
          onChange={handleDepartureDateChange}
        />
      </div>
      {tripType === 'round-trip' && (
        <div>
          <label htmlFor="returnDate">Return Date:</label>
          <input
            type="date"
            id="returnDate"
            value={returnDate}
            onChange={handleReturnDateChange}
          />
        </div>
      )}
      <button onClick={handleBookFlight}>Book Flight</button>
    </div>
  );
};

export default Book;
