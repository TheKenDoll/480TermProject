import { Outlet, Link } from "react-router-dom";
import './Layout.css';

function Layout() {
  return (
    <>
      <nav className="navbar">
        <ul className="nav-list">
          <li className="nav-item">
            <Link to="/">Home</Link>
          </li>
          <li className="nav-item">
            <Link to="/login">Login</Link>
          </li>
          <li className="nav-item">
            <Link to="/account">Account</Link>
          </li>
          <li className="nav-item">
            <Link to="/book">Book</Link>
          </li>
          <li className="nav-item">
            <Link to="/admin">AdminLanding</Link>
          </li>
          <li className="nav-item">
            <Link to="/agent">AgentLanding</Link>
          </li>
          <li className="nav-item">
            <Link to="/register">Register</Link>
          </li>
        </ul>
      </nav>

      <Outlet />
    </>
  );
}

export default Layout;
