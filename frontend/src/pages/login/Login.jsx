import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Loader from "../../components/loader/Loader";
import "./Login.css";
import { CustomAlert } from "../../utils/Alert";
import { useAuth } from "../../context/AuthContext";

const Login = () => {
  const [loading, setLoading] = useState(false);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const { login } = useAuth();

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
      setLoading(true);
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
      login(user.sub, data.token);
      navigate("/book");
    } catch (error) {
      CustomAlert.showError("Bad credentials");
      setLoading(false);
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
          <h2>WELCOME!</h2>
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
              {loading ? (
                <Loader></Loader>
              ) : (
                <button class="button-64" type="submit">
                  <span class="text">Login</span>
                </button>
              )}
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
