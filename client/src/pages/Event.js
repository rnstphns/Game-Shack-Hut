import React from "react";
import EventItem from "../components/EventItem";
import Header from "../components/Header";

const Event = () => {
  return (
    <div>
      <Header />
      <div className="container-wrapper">
        <EventItem />
        <EventItem />
        <EventItem />
      </div>
    </div>
  );
};
export default Event;
