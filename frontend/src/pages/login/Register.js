import React, { useState } from 'react';

function Register() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [address, setAddress] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState("");




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
            const res = await fetch("http://localhost:8080/api/v1/auth/register/", {
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
    }



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
                <label>
                    Address:
                    <input
                        type="text"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                    />
                </label>
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
                        <option value="admin">Admin</option>
                        <option value="user">User</option>
                    </select>
                <button type="submit" /*onClick={handleRegister}*/>
                    Register
                </button>
            </form>
        </div>
    );
}

export default Register;
