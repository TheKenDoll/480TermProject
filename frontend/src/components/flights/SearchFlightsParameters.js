// FlightSearchForm.js

import React, { useState } from 'react';
import './SearchFlightsParameters.css';

const FlightSearchForm = ({ onSearch }) => {
  const [origin, setOrigin] = useState('Any');
  const [destination, setDestination] = useState('Any');
  const [date, setDate] = useState('Any');

  const handleSearch = () => {
    // Perform the search action with the provided parameters
    onSearch({ origin, destination, date });
  };

  return (
    <div className="flight-search-form">
      <label>
        Origin:
        <input type="text" value={origin} onChange={(e) => setOrigin(e.target.value)} />
      </label>
      <label>
        Destination:
        <input type="text" value={destination} onChange={(e) => setDestination(e.target.value)} />
      </label>
      <label>
        Date:
        <input type="date" value={date} onChange={(e) => setDate(e.target.value)} />
      </label>
      <button onClick={handleSearch}>Search Flights</button>
    </div>
  );
};

export default FlightSearchForm;
