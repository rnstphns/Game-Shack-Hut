import { Button } from "@mui/material";
import React from "react";
import Header from "../components/Header";
import ProductItem from "../components/ProductItem";

const Home = () => {
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
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
        </div>
        <div className="home action">
          <Button variant="contained">View All</Button>
        </div>
      </div>
    </>
  );
};

export default Home;
