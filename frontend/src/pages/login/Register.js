import React, { useState } from 'react';
import {  useNavigate } from 'react-router-dom';

function Register() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    //const [address, setAddress] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState("");

    const navigate = useNavigate()




    const handleRoleChange = (event) => {
        setRole(event.target.value)

    }

    const parseJwt = (token) => {
        if (!token) {
          return;
        }
        const base64Url = token.split(".")[1];
        const base64 = base64Url.replace("-", "+").replace("_", "/");
        return JSON.parse(window.atob(base64));
      };


    const handleRegister = async (event) => {

        event.preventDefault()

        try {
            const res = await fetch(`${process.env.REACT_APP_URL}/api/v1/auth/register`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                  firstName,
                  lastName,
                  email,
                  password,
                  role

                }),

            });
            const data = await res.json();
            const user = parseJwt(data.token);
            const {sub} = user;
            localStorage.setItem("token", data.token)
            localStorage.setItem("user", JSON.stringify(sub));
        }catch(error){
            console.log(error);
        }

        const token = localStorage.getItem('token'); // Or sessionStorage, or cookies


        if (token) {
            const base64Url = token.split('.')[1]; // Get the payload part
            const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/'); // Convert Base64-url to Base64
            const jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            const details = JSON.parse(jsonPayload);
            //console.log(details); // Log to check the structure

            // Assuming the email is stored under the key 'email'
            const email = details.sub;
            sessionStorage.setItem("userEmail", email)
            //console.log(email)


            const userEmail = sessionStorage.getItem('userEmail');
            //console.log(userEmail)


            if (userEmail && userEmail.endsWith('admin.com')) {
                navigate("/admin")
            } else {
                navigate("/landing")
            }



        }










        setFirstName("")
        setLastName("")
        setEmail("")
        setPassword("")
        setRole("")
    }
    // const token = localStorage.getItem('token'); // Or sessionStorage, or cookies


    // if (token) {
    //     const base64Url = token.split('.')[1]; // Get the payload part
    //     const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/'); // Convert Base64-url to Base64
    //     const jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => {
    //         return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    //     }).join(''));

    //     const details = JSON.parse(jsonPayload);
    //     //console.log(details); // Log to check the structure

    //     // Assuming the email is stored under the key 'email'
    //     const email = details.email;
    //     console.log(email); // This should be your email
    // }




    return (
        <div>
            <h2>Registration</h2>
            <form onSubmit={handleRegister}>

                <br></br>
                <br></br>
                <br></br>
                <label>
                    First Name:
                    <input
                        type="text"
                        value={firstName}
                        onChange={(e) => setFirstName(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Last Name:
                    <input
                        type="text"
                        value={lastName}
                        onChange={(e) => setLastName(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Email:
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </label>
                <br />
                {/* <label>
                    Address:
                    <input
                        type="text"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                    />
                </label> */}
                <br />
                <label>
                    Password:
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </label>
                <br />
                <label htmlFor="role-select">Choose a role:</label>
                    <select id="role-select" value={role} onChange={handleRoleChange}>
                        <option value="">--Please choose an option--</option>
                        <option value="ADMIN">ADMIN</option>
                        <option value="USER">USER</option>
                    </select>
                <button type="submit" /*onClick={handleRegister}*/>
                    Register
                </button>
            </form>
        </div>
    );
}

export default Register;
