import React from "react";
import { useParams } from "react-router-dom";
import { useAxios } from "../api/useAxios";
import Header from "../components/Header";

const ProductDetail = () => {
  const { id } = useParams();
  const { data, error, loading } = useAxios("get", "/product/" + id);

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
      <div
        className="container-wrapper"
        style={{ display: "flex", flexDirection: "row" }}
      >
        <div style={{ width: "50%" }}>
          <img
            src="https://images.unsplash.com/photo-1585504198199-20277593b94f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1917&q=80"
            alt="game"
            style={{ width: "100%", height: "auto" }}
          />
        </div>
        <div style={{ margin: "20px", fontSize: "20px" }}>
          <div
            style={{
              fontSize: "22px",
              fontWeight: "bold",
              marginBottom: "20px",
            }}
          >
            {data.productName}
          </div>
          <div style={{ marginBottom: "10px" }}>Price: ${data.price}</div>
          <div style={{ marginBottom: "10px" }}>
            Quantity: {data.quantityInStock}
          </div>
          <div style={{ marginBottom: "10px" }}>Type: {data.type}</div>
        </div>
      </div>
    </div>
  );
};
export default ProductDetail;
