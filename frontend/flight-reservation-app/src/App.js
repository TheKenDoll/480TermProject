import './App.css';
import Layout from './Layout.js';
import Login from './components/login/Login.js';
import Landing from './components/login/Landing.js';
import Account from './components/login/Account.js';
import Book from './components/bookings/Book.js';
import AdminLanding from './components/admin/AdminLanding.js';
import AdminEdit from './components/flights/EditFlight.js';
import CrewEdit from './components/employee/EditCrew.js';
import AircraftEdit from './components/flights/EditAircraft.js';
import AgentLanding from './components/agent/AgentLanding.js';
import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

const App = () => {
  const [isLoggedIn, setLoggedIn] = useState(false);

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
          <Route path="/book" element={<Book />} />
          <Route path="/" element={<Layout />}>
            <Route index element={<Landing />} />
            <Route path="/login" element={<Login />} />
            <Route path="/account" element={<Account />} />
            <Route path="/book" element={<Book />} />
            <Route path="/admin" element={<AdminLanding />} />
            <Route path="/edit" element={<AdminEdit />} />
            <Route path="/crewedit" element={<CrewEdit />} />
            <Route path="/aircraftedit" element={<AircraftEdit />} />
            <Route path="/agent" element={<AgentLanding />} />
          </Route>
        </Routes>
      </Router>
    </div>
  );
};

export default App;
