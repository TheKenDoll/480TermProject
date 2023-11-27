import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
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

const App = () => {
  return (
    <div className="App">
      <Router>
        <Routes>
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
