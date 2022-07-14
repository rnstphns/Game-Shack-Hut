import * as React from "react";
import AdminDashboard from "./AdminDashboard";
import StaffDashboard from "./StaffDashboard";
import ROLE from "../auth/Role";

const Dashboard = (props) => {
  return (
    <>{props.role === ROLE.Admin ? <AdminDashboard /> : <StaffDashboard />}</>
  );
};

export default Dashboard;
