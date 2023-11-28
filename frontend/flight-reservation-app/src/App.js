// App.js
import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Layout from './Layout.js';
import Login from './components/Login/Login.js';
import Landing from './components/Login/Landing.js';
import Account from './components/Login/Account.js';
import Book from './components/bookings/Book.js';
import AdminLanding from './components/admin/AdminLanding.js';
import AdminEdit from './components/flights/EditFlight.js';
import CrewEdit from './components/employee/EditCrew.js';
import AircraftEdit from './components/flights/EditAircraft.js';
import AgentLanding from './components/agent/AgentLanding.js';
import FlightList from './components/flights/FlightList.js';
import FlightDetails from './components/flights/FlightDetails.js';
import SeatSelection from './components/seats/SeatSelection.js';
import SelectInsurance from './components/bookings/SelectInsurance.js';
import PaymentForm from './components/payment/PaymentForm.js';
import Register from './components/Login/Register.js';

const App = () => {
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [flights, setFlights] = useState([]);

  return (
    <div className="App">
      <Router>
        <Layout />

        <Routes>
          <Route path="/" element={<Landing />} />
          <Route
            path="/account"
            element={
              isLoggedIn ? (
                <Account />
              ) : (
                <Navigate to="/login" replace={true} />
              )
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/book" element={<Book setLoggedIn={setLoggedIn} />} />
          <Route path="/flights" element={<FlightList flights={flights} />} />
          <Route path="/flight-details/:flightId" element={<FlightDetails />} />
          <Route path="/select-seats/:flightId" element={<SeatSelection />} />
          <Route path="/select-insurance" element={<SelectInsurance />} />
          <Route path="/payment" element={<PaymentForm />} />
          <Route path="/admin" element={<AdminLanding />} />
          <Route path="/edit" element={<AdminEdit />} />
          <Route path="/crewedit" element={<CrewEdit />} />
          <Route path="/aircraftedit" element={<AircraftEdit />} />
          <Route path="/agent" element={<AgentLanding />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;