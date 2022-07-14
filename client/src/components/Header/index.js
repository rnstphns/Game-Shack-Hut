import React, { useContext } from "react";
import { ReactComponent as Logo } from "../../assets/img/logo.svg";
import "./index.css";
import { Link } from "react-router-dom";
import LogoutIcon from "@mui/icons-material/Logout";
import Button from "@mui/material/Button";
import { AuthContext } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";
import PersonIcon from "@mui/icons-material/Person";
import LoginIcon from "@mui/icons-material/Login";

const Header = ({ type = "default", onFilter = () => {} }) => {
  const { isSignedIn, setSignedIn } = useContext(AuthContext);
  const navigate = useNavigate();
  return (
    <div className="header">
      <Link to="/" style={{ textDecoration: "none" }}>
        <div className="logo">
          <Logo />
          <div className="logo-text">GameShackHut</div>
          <div className="menu-left">
            <Button
              variant="text"
              className="menu-item"
              component={Link}
              to="/product"
            >
              Products
            </Button>
            <Button
              variant="text"
              component={Link}
              to="/event"
              className="menu-item"
            >
              Events
            </Button>
          </div>
        </div>
      </Link>
      <div className="right">
        {/* {type === "filter" && <Filter onFilter={onFilter} />} */}
      </div>
    </div>
  );
};
export default Header;
