import React from "react";
import Header from "../components/Header";
import ProductItem from "../components/ProductItem";
import TextField from "@mui/material/TextField";
import InputAdornment from "@mui/material/InputAdornment";
import SearchIcon from "@mui/icons-material/Search";
import { useAxios } from "../api/useAxios";
import MapsHomeWorkIcon from "@mui/icons-material/MapsHomeWork";

const Product = () => {
  const { data, error, loading, execute, queryParam } = useAxios(
    "get",
    "/product"
  );
  const [search, setSearch] = React.useState(null);

  if (loading) {
    return (
      <>
        <Header />
        <h1>Loading...</h1>
      </>
    );
  }
  return (
    <>
      <Header />
      <div className="container-wrapper">
        <div className="product search">
          <TextField
            value={search || ""}
            defaultValue={""}
            placeholder="Search"
            id="standard-start-adornment"
            sx={{ m: 1, width: "25ch" }}
            InputProps={{
              startAdornment: <SearchIcon />,
            }}
            variant="standard"
            onChange={(e) => setSearch(e.target.value)}
            onKeyPress={(e) =>
              e.key === "Enter" &&
              execute(queryParam([{ key: "search", value: search }]))
            }
          />
        </div>
        <div className="product card-list">
          {data.length > 0 ? (
            data.map((item, index) => {
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
      </div>
    </>
  );
};
export default Product;
