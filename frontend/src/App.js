import { useState } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import Layout from "./Layout.js";
import Login from "./pages/login/Login.jsx";
import Landing from "./pages/login/Landing.js";
import Account from "./pages/login/Account.js";
import Book from "./components/bookings/Book.js";
import AdminLanding from "./components/admin/AdminLanding.js";
import AdminEdit from "./components/flights/EditFlight.js";
import CrewEdit from "./components/employee/EditCrew.js";
import AircraftEdit from "./components/flights/EditAircraft.js";
import AgentLanding from "./components/agent/AgentLanding.js";
import FlightList from "./components/flights/FlightList.js";
import FlightDetails from "./components/flights/FlightDetails.js";
import SeatSelection from "./components/seats/SeatSelection.js";
import SelectInsurance from "./components/bookings/SelectInsurance.js";
import Register from "./pages/login/Register.js";
import Stripe from "./pages/stripe/Stripe.jsx";
import ViewPassengers from './components/passengers/ViewPassengers.js';
import AddFlight from './components/flights/AddFlight.js';
import "./index.css";

const App = () => {
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [flights, setFlights] = useState([]);

  return (
    <div className="App">
      <Router>
        <Layout />
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route
            path="/account"
            element={
              isLoggedIn ? <Account /> : <Navigate to="/login" replace={true} />
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/book" element={<Book setLoggedIn={setLoggedIn} />} />
          <Route path="/flights" element={<FlightList flights={flights} />} />
          <Route path="/flight-details/:flightId" element={<FlightDetails />} />
          <Route path="/select-seats/:flightId" element={<SeatSelection />} />
          <Route path="/select-insurance" element={<SelectInsurance />} />
          <Route path="/admin" element={<AdminLanding />} />
          <Route path="/edit" element={<AdminEdit />} />
          <Route path="/crewedit" element={<CrewEdit />} />
          <Route path="/aircraftedit" element={<AircraftEdit />} />
          <Route path="/agent" element={<AgentLanding />} />
          <Route path="/register" element={<Register />} />
          <Route path="/checkout" element={<Stripe />} />
          <Route path="/passengers" element={<ViewPassengers />} />
          <Route path="/add" element={<AddFlight />} />
          <Route path="/payment" element={<Stripe />} />
        </Routes>
      </Router>
    </div>
  );
};

export default App;
