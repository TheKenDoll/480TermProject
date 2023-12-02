import React, { useState } from "react";
import "./Login.css";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const parseJwt = (token) => {
    if (!token) {
      return;
    }
    const base64Url = token.split(".")[1];
    const base64 = base64Url.replace("-", "+").replace("_", "/");
    return JSON.parse(window.atob(base64));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await fetch(
        `${process.env.REACT_APP_URL}/api/v1/auth/authenticate`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ email, password }),
        }
      );
      const data = await res.json();
      const user = parseJwt(data.token);
      const { sub } = user;
      localStorage.setItem("token", data.token);
      localStorage.setItem("user", JSON.stringify(sub));
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <div className="main-container">
        <div className="left-container">
          <div className="title-container">
            <h2 className="title">The best airline in the world.</h2>
          </div>
          <img src="./plane.avif" alt="login" className="image" />
        </div>
        <div className="login-container">
          <form onSubmit={handleSubmit} className="login-form">
            <label>Email</label>
            <input
              className="input-field"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <label>Password</label>
            <input
              className="input-field"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <div className="btn-container">
              <button class="button-64" role="button" type="submit">
                <span class="text">Login</span>
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
