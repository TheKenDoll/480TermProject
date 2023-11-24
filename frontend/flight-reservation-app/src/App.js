import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './Layout.js';
import Login from './components/login/Login.js';
import Landing from './components/login/Landing.js';
import Account from './components/login/Account.js';
import Book from './components/bookings/Book.js';

const App = () => {
  return (
    <div className="App">
      <Router>
        <Routes>
            <Route path="/" element={<Layout />}>
              <Route index element={<Landing />} />
            </Route>
          <Route path="/login" element={<Login />} />
          <Route path="/account" element={<Account />} />
          <Route path="/book" element={<Book />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;
