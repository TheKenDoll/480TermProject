import { Outlet, Link, useNavigate } from "react-router-dom";
import "./Layout.css";
import { useAuth } from "./context/AuthContext";

function Layout() {
  const navigate = useNavigate();
  const { isAuthenticated, logout } = useAuth();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <>
      {isAuthenticated ? (
        <nav>
          <ul>
            <li>
              <Link to="/book">Book</Link>
            </li>
            <li>
              <Link to="/account">Account</Link>
            </li>
            <li>
              <Link to="/admin">AdminLanding</Link>
            </li>
            <li>
              <Link to="/agent">AgentLanding</Link>
            </li>
            <li className="logout-link">
              <button onClick={() => handleLogout()} className="button-64-nav">
                <span>Logout</span>
              </button>
            </li>
          </ul>
        </nav>
      ) : (
        <nav>
          <ul>
            <li>
              <Link to="/register">Register</Link>
            </li>
            <li>
              <Link to="/login">Login</Link>
            </li>
          </ul>
        </nav>
      )}
      <Outlet />
    </>
  );
}

export default Layout;
