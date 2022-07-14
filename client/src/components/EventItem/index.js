import { Button } from "@mui/material";
import React from "react";
import "./index.css";
import moment from "moment";

const EventItem = ({ event }) => {
  return (
    <div className="event">
      <div className="date">
        <div className="day">
          <span>{moment(event.date).format("Do")}</span>
        </div>
        <div className="month">
          <span>{moment(event.date).format("MMMM")}</span>
        </div>
      </div>
      <div className="event-info">
        <div className="title">{event.eventName}</div>
        <div>Capacity {event.capacity}</div>
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
