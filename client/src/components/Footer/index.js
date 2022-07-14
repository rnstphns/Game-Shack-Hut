import React from "react";
import "./index.css";

const Footer = () => {
  return (
    <footer>
      <div className="footer">
        <div className="row">
          <a href="#">
            <i className="fa fa-facebook"></i>
          </a>
          <a href="#">
            <i className="fa fa-instagram"></i>
          </a>
          <a href="#">
            <i className="fa fa-youtube"></i>
          </a>
          <a href="#">
            <i className="fa fa-twitter"></i>
          </a>
        </div>

        <div className="row">
          <ul>
            <li>
              <a href="#">Contact us</a>
            </li>
            <li>
              <a href="#">Our Services</a>
            </li>
            <li>
              <a href="#">Privacy Policy</a>
            </li>
            <li>
              <a href="#">Terms & Conditions</a>
            </li>
            <li>
              <a href="#">Career</a>
            </li>
          </ul>
        </div>

        <div className="row">
          GameShackHut Copyright © 2021 GameShackHut - All rights reserved ||
          Designed and Developed By: GameShackHut Groups
        </div>
      </div>
    </footer>
  );
};
export default Footer;
