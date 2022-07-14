import React, { useState, useEffect } from "react";
import "./assets/css/app/index.css";
import { Routes, Route, useNavigate } from "react-router-dom";
import { AuthContext } from "./context/AuthContext";
import AuthWrapper from "./auth/AuthWrapper";
import ROLE from "./auth/Role";
import Dashboard from "./pages/Dashboard";
import { ThemeProvider } from "@mui/material/styles";
import Login from "./pages/Login";
import NotFound from "./pages/404";
import axios from "axios";
import Product from "./pages/product/Product";
import NewProduct from "./pages/product/NewProduct";
import Event from "./pages/event/Event";
import NewEvent from "./pages/event/NewEvent";

function App() {
  const [isSignedIn, setSignedIn] = useState(
    localStorage.getItem("token") ? true : false
  );

  const [user, setUser] = useState(null);
  const [role, setRole] = useState(
    localStorage.getItem("user")
      ? JSON.parse(localStorage.getItem("user")).role
      : ""
  );

  const fetchData = async () => {
    const data = await localStorage.getItem("user");
    const json = JSON.parse(data);
    if (json) {
      setUser(json);
      setRole(json.role);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const authContext = { isSignedIn, setSignedIn, user, setUser, role, setRole };

  axios.interceptors.response.use(
    (response) => {
      return response;
    },
    (error) => {
      if (error.response.status === 401) {
        setSignedIn(false);
        setRole(null);
        setUser(null);
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        // navigate to login
        setTimeout(() => {
          window.location = "/login";
        }, 1500);
      }
      return error;
    }
  );

  return (
    <AuthContext.Provider value={authContext}>
      <Routes>
        <Route path="*" element={<NotFound />} />

        <Route path="/login" element={<Login />} />
        <Route
          path="/"
          element={
            <AuthWrapper role={[ROLE.Admin, ROLE.Staff]}>
              <Dashboard role={role} />
            </AuthWrapper>
          }
        />
        <Route
          path="/product"
          element={
            <AuthWrapper role={[ROLE.Admin, ROLE.Staff]}>
              <Product role={role} />
            </AuthWrapper>
          }
        />
        <Route
          path="/new-product"
          element={
            <AuthWrapper role={[ROLE.Admin, ROLE.Staff]}>
              <NewProduct role={role} />
            </AuthWrapper>
          }
        />
        <Route
          path="/event"
          element={
            <AuthWrapper role={[ROLE.Admin, ROLE.Staff]}>
              <Event role={role} />
            </AuthWrapper>
          }
        />
        <Route
          path="/new-event"
          element={
            <AuthWrapper role={[ROLE.Admin, ROLE.Staff]}>
              <NewEvent role={role} />
            </AuthWrapper>
          }
        />
      </Routes>
    </AuthContext.Provider>
  );
}

export default App;
