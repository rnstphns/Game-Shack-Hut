import React, { useContext } from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import useAxios from "axios-hooks";
import { AuthContext } from "../../context/AuthContext";
import Loading from "../../components/Loading";
import Layout from "../Layout";
import { Grid, Button } from "@mui/material";
import { Link } from "react-router-dom";

const Product = () => {
  let rows = [];
  const { isSignedIn } = useContext(AuthContext);
  const [{ data, loading, error }, refetch] = useAxios(
    {
      url: "/product",
      method: "get",

      headers: { Authorization: "Bearer " + localStorage.getItem("token") },
    },
    {
      useCache: false,
    }
  );
  if (loading || error) {
    return <Loading />;
  }

  return (
    <Layout title="Dashboard">
      <div style={{ margin: "20px", padding: "20px" }}>
        <Button
          variant="contained"
          color="primary"
          component={Link}
          to="/new-product"
        >
          New Product
        </Button>
      </div>
      <Grid container spacing={1}>
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Name</TableCell>
                <TableCell align="right">Price</TableCell>
                <TableCell align="right">Quantity</TableCell>
                <TableCell align="right">Type</TableCell>
                <TableCell align="right">Action</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data.map((row) => (
                <TableRow
                  key={row.productId}
                  sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                >
                  <TableCell component="th" scope="row">
                    {row.productName}
                  </TableCell>
                  <TableCell align="right">{row.price}</TableCell>
                  <TableCell align="right">{row.quantityInStock}</TableCell>
                  <TableCell align="right">{row.type}</TableCell>
                  <TableCell align="right">
                    <Button
                      variant="contained"
                      color="secondary"
                      component={Link}
                      to="/new-product"
                    >
                      Edit
                    </Button>{" "}
                    <Button
                      variant="contained"
                      color="error"
                      component={Link}
                      to="/new-product"
                    >
                      Delete
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Grid>
    </Layout>
  );
};
export default Product;
