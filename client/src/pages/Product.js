import React from "react";
import Header from "../components/Header";
import ProductItem from "../components/ProductItem";
import TextField from "@mui/material/TextField";
import InputAdornment from "@mui/material/InputAdornment";
import SearchIcon from "@mui/icons-material/Search";

const Product = () => {
  return (
    <>
      <Header />
      <div className="container-wrapper">
        <div className="product search">
          <TextField
            placeholder="Search"
            id="standard-start-adornment"
            sx={{ m: 1, width: "25ch" }}
            InputProps={{
              startAdornment: <SearchIcon />,
            }}
            variant="standard"
          />
        </div>
        <div className="product card-list">
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
export default Product;
