import React from "react";
import EventItem from "../components/EventItem";
import Header from "../components/Header";
import { useAxios } from "../api/useAxios";

const Event = () => {
  const { data, error, loading, execute, queryParam } = useAxios(
    "get",
    "/event"
  );

  if (loading) {
    return (
      <>
        <Header />
        <h1>Loading...</h1>
      </>
    );
  }

  return (
    <div>
      <Header />
      <div className="container-wrapper">
        {data.length > 0 ? (
          data.map((item, index) => {
            return <EventItem event={item} />;
          })
        ) : (
          <h1>No result found!</h1>
        )}
      </div>
    </div>
  );
};
export default Event;
