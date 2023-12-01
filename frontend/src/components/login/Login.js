import React, { useState } from 'react';
import './Login.css'; // Create this file for styling
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const navigate = useNavigate();
  // State to manage form input values
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  // Handle form submission
  const handleLogin = (e) => {
    e.preventDefault();

    // Perform authentication logic here
    console.log('Login clicked. Implement authentication logic.');

    // Clear form fields after submission
    setEmail('');
    setPassword('');
  };

  const handleRegister = () => {
    navigate('/register')
  }

  return (
    <div className="login-container">
      <form onSubmit={handleLogin} className="login-form">
        <h2>Login</h2>
        <label>Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <label>Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Login</button>
      </form>
      <div>
        <button className="button" onClick={handleRegister}>Register</button>
      </div>
    </div>
  );
};

export default Login;
