import React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import { useNavigate } from "react-router-dom";
import DefaultImage from "../../assets/img/default-house.jpeg";

const ProductItem = ({ product }) => {
  const navigate = useNavigate();
  let photos = [];

  return (
    <Card
      sx={{ maxWidth: 300, minWidth: 300 }}
      className="product-item"
      onClick={() => navigate("/property/" + product.id)}
    >
      <CardMedia
        component="img"
        height="140"
        image={photos.length > 0 ? photos[0].imageUrl : DefaultImage}
        alt={photos.length > 0 ? photos[0].imageUrl : "green guava"}
      />
      <CardContent>
        <div className="product-item__info__name">{product.name}</div>
        <div className="product-item__info__price">{product.price}</div>
      </CardContent>
    </Card>
  );
};

export default ProductItem;
