import React, { useState, useEffect, useContext, createContext } from "react";

const AuthContext = createContext({
  isAuthenticated: false,
  login: () => {},
  register: () => {},
  logout: () => {},
});

export const useAuth = () => {
  return useContext(AuthContext);
};

function AuthProvider({ children }) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const uid = localStorage.getItem("uid");
    const jwt = localStorage.getItem("jwt");
    if (uid && jwt) {
      setIsAuthenticated(true);
    } else {
      setIsAuthenticated(false);
    }
  }, []);

  const register = (email, jwt) => {
    localStorage.setItem("uid", email);
    localStorage.setItem("jwt", jwt);
    setIsAuthenticated(true);
  };

  const login = (email, jwt) => {
    console.log("context");
    localStorage.setItem("uid", email);
    localStorage.setItem("jwt", jwt);
    setIsAuthenticated(true);
  };

  const logout = () => {
    localStorage.removeItem("uid");
    localStorage.removeItem("jwt");
    setIsAuthenticated(false);
  };
  return (
    <AuthContext.Provider
      value={{
        isAuthenticated,
        login,
        register,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export default AuthProvider;
