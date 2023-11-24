import { Outlet, Link } from "react-router-dom";

function Layout () {
    return (
        <>
            <nav>
                <ul>
                <li>
                    <Link to="/">Home</Link>
                    <Link to="/login">Login</Link>
                </li>
                </ul>
            </nav>

            <Outlet />
        </>
    )
}

export default Layout