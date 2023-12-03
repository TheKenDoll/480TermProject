import { Outlet, Link } from "react-router-dom";
import "./Layout.css";

function Layout() {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/login">Login</Link>
          </li>
          <li>
            <Link to="/account">Account</Link>
          </li>
          <li>
            <Link to="/book">Book</Link>
          </li>
          {/* <li>
            <Link to="/admin">AdminLanding</Link>
          </li>
          <li>
            <Link to="/agent">AgentLanding</Link>
          </li> */}
        </ul>
      </nav>

      <Outlet />
    </>
  );
}

export default Layout;
