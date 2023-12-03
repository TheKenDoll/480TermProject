import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

//import Register from "./Register";

import Loader from "../../components/loader/Loader";
import "./Login.css";
import { CustomAlert } from "../../utils/Alert";
import { useAuth } from "../../context/AuthContext";

const Login = () => {
  const [loading, setLoading] = useState(false);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const { login } = useAuth();

  const navigate = useNavigate();

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

      const email_1 = localStorage.getItem("uid")

      if (email_1 && email_1.endsWith('admin.com')) {
        navigate("/admin")
      } else if (email_1 && email_1.endsWith("agent.com")) {
          navigate("/agent")
      } else {
        navigate("/landing")
      }
    } catch (error) {
      CustomAlert.showError("Bad credentials");
      setLoading(false);
      console.log(error);
    }


    const token = localStorage.getItem('token'); // Or sessionStorage, or cookies


    // if (token) {
    //     const base64Url = token.split('.')[1]; // Get the payload part
    //     const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/'); // Convert Base64-url to Base64
    //     const jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => {
    //         return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    //     }).join(''));

    //     const details = JSON.parse(jsonPayload);
    //     //console.log(details); // Log to check the structure

    //     // Assuming the email is stored under the key 'email'
    //     const email = details.sub;
    //     sessionStorage.setItem("userEmail", email)
    //     //console.log(email)


    //     const userEmail = sessionStorage.getItem('userEmail');
    //     //console.log(userEmail)


    //     if (userEmail && userEmail.endsWith('admin.com')) {
    //         navigate("/admin")
    //     } else if (userEmail && userEmail.endsWith("agent.com")) {
    //         navigate("/agent")
    //     } else {
    //       navigate("/landing")
    //     }



    // }







    setEmail("")
    setPassword("")
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
                <>
                    <p>Don't have an account yet? <Link to="/register">Register</Link></p>
                    <button class="button-64" type="submit">
                            <span class="text">Login</span>
                    </button>

                </>

              )}
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
