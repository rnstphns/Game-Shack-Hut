import { Button } from "@mui/material";
import React from "react";
import "./index.css";

const EventItem = ({ event }) => {
  return (
    <div className="event">
      <div className="date">
        <div className="day">
          <span>4</span>
        </div>
        <div className="month">
          <span>July</span>
        </div>
      </div>
      <div className="event-info">
        <div className="title">Event Title</div>
        <div>Event Description</div>
        <div className="action">
          <Button>Register</Button>
        </div>
        <div className="divider">
          <hr />
        </div>
      </div>
    </div>
  );
};
export default EventItem;
