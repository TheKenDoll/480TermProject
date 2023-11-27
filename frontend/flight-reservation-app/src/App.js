import './App.css';
import Layout from './Layout.js';
import Login from './components/login/Login.js';
import Landing from './components/login/Landing.js';
import Account from './components/login/Account.js';
import Book from './components/bookings/Book.js';
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
        </Routes>
      </Router>
    </div>
  );
};

export default App;
