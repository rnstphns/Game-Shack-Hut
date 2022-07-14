import React from "react";
import Layout from "../Layout";
import { Grid, Typography, TextField, Box, Paper, Button } from "@mui/material";

const NewProduct = () => {
  return (
    <Layout title="Dashboard">
      <Grid container spacing={1}>
        <Paper>
          <Box component="form" onSubmit={() => {}} p={3}>
            <Typography variant="h6" gutterBottom>
              New Product
            </Typography>
            <Grid container spacing={3}>
              <Grid item xs={12} sm={12}>
                <TextField
                  required
                  id="propertyName"
                  name="propertyName"
                  label="Name"
                  fullWidth
                  autoComplete="property-name"
                  variant="standard"
                />
              </Grid>

              <Grid item xs={5} sm={2}>
                <TextField
                  required
                  id="numberOfBedrooms"
                  name="numberOfBedrooms"
                  label="Price"
                  fullWidth
                  variant="standard"
                />
              </Grid>
              <Grid item xs={5} sm={2}>
                <TextField
                  required
                  id="propertyName"
                  name="propertyName"
                  label="Type"
                  fullWidth
                  autoComplete="property-name"
                  variant="standard"
                />
              </Grid>

              <Grid item xs={8} sm={5}>
                <TextField
                  required
                  id="securityDepositAmount"
                  name="securityDepositAmount"
                  label="Quantity"
                  fullWidth
                  variant="standard"
                />
              </Grid>

              <Grid item xs={12}>
                <Box sx={{ display: "flex", flexDirection: "row-reverse" }}>
                  <Button variant="contained" type="submit">
                    <Typography ml={2}>Save</Typography>
                  </Button>
                </Box>
              </Grid>
            </Grid>
          </Box>
        </Paper>
      </Grid>
    </Layout>
  );
};
export default NewProduct;
