import React, { useState, useEffect } from "react";
import "./assets/css/app/index.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import { AuthContext } from "./context/AuthContext";
import Footer from "./components/Footer";

function App() {
  const [isSignedIn, setSignedIn] = useState(
    localStorage.getItem("token") ? true : false
  );
  const [user, setUser] = useState(null);

  const authContext = { isSignedIn, setSignedIn, user, setUser };

  return (
    <AuthContext.Provider value={authContext}>
      <Routes>
        {/* <Route path="*" element={<NotFound />} /> */}
        <Route path="/" element={<Home />} />
      </Routes>
      <Footer />
    </AuthContext.Provider>
  );
}

export default App;
