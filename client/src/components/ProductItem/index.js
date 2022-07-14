import React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import { useNavigate } from "react-router-dom";
import DefaultImage from "../../assets/img/default-house.jpeg";
import "./index.css";

const ProductItem = ({ product }) => {
  const navigate = useNavigate();
  let photos = [];

  return (
    <Card
      sx={{ maxWidth: 300, minWidth: 300 }}
      className="product-item"
      onClick={() => navigate("/product/" + product.productId)}
    >
      <CardMedia
        component="img"
        height="140"
        image={
          photos.length > 0
            ? photos[0].imageUrl
            : "https://images.unsplash.com/photo-1629760946220-5693ee4c46ac?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80"
        }
        alt={photos.length > 0 ? photos[0].imageUrl : "green guava"}
      />
      <CardContent>
        <div className="product-item__info__name">{product.productName}</div>
        <div className="product-item__info__price">{product.price}</div>
      </CardContent>
    </Card>
  );
};

export default ProductItem;
