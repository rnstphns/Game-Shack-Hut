import * as React from "react";
import { Box, Grid } from "@mui/material";
import Layout from "./Layout";

function AdminDashboard() {
  return (
    <Layout title="Dashboard">
      <Grid container spacing={1}>
        Welcome to the admin dashboard!
      </Grid>
    </Layout>
  );
}

export default AdminDashboard;
