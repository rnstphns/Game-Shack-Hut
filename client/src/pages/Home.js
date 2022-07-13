import React from "react";
import Header from "../components/Header";
import ProductItem from "../components/ProductItem";

const Home = () => {
  return (
    <>
      <Header />

      <div className="container-wrapper">
        <div className="title">
          <h3>Available Products</h3>
        </div>
        <div className="card-list">
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
          <ProductItem
            product={{ id: 1, name: "asd", description: "asdf", price: 123 }}
          />
        </div>
      </div>
    </>
  );
};

export default Home;
