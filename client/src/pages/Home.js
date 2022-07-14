import { Button } from "@mui/material";
import React from "react";
import Header from "../components/Header";
import ProductItem from "../components/ProductItem";
import { useAxios } from "../api/useAxios";
import MapsHomeWorkIcon from "@mui/icons-material/MapsHomeWork";
import { Link } from "react-router-dom";

const Home = () => {
  const { data, error, loading, execute, queryParam } = useAxios(
    "get",
    "/product"
  );

  if (loading) {
    return (
      <>
        <Header />
        <h1>Loading...</h1>
      </>
    );
  }
  let list = data.length > 4 ? data.slice(0, 4) : data;
  return (
    <>
      <Header />
      <div className="homepage-banner">
        <img
          src="https://images.unsplash.com/photo-1606733847546-db8546099013?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2772&q=80"
          alt="banner"
        />
      </div>
      <div className="container-wrapper">
        <div className="home title">
          <h3>Available Products</h3>
        </div>
        <div className="card-list">
          {list.length > 0 ? (
            list.map((item, index) => {
              return <ProductItem key={item.id} product={item} />;
            })
          ) : (
            <>
              <div className="empty-list" style={{ minHeight: "500px" }}>
                <MapsHomeWorkIcon
                  style={{ fontSize: "35px", marginBottom: "10px" }}
                />
                <h3> Sorry! We could not find any properties.</h3>
              </div>
            </>
          )}
        </div>
        <div className="home action">
          <Button variant="contained" component={Link} to="/product">
            View All
          </Button>
        </div>
      </div>
    </>
  );
};

export default Home;
