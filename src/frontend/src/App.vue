<template>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Awesome CSS Responsive Navigation menus  </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <header>
    <input type ="checkbox" name ="" id ="chk1">
    <div class="logo"><h1>Twoja Książka</h1></div>
    <div class="search-box">
      <form>
        <input type ="text" name ="Szukaj" id ="srch" placeholder="Znajdź swoją ulubioną książkę">
        <button type ="submit"><i class="fa fa-search"></i></button>
      </form>
    </div>
    <ul>
      <li><a href="#">Strona Główna</a></li>
      <li><a href="#">Kategorie</a></li>
      <li><a href="#">Koszyk</a></li>
      <li>
        <a href="#"><i class="fa fa-facebook"></i></a>
        <a href="#"><i class="fa fa-twitter"></i></a>
        <a href="#"><i class="fa fa-instagram"></i></a>

      </li>
    </ul>
    <div class="menu">
      <label for="chk1">
        <i class="fa fa-bars"></i>
      </label>
    </div>
  </header>
  </body>
  <div class="productList">
    <product-card v-for="product of products" :key="product.id" :product="product"/>
  </div>
  <PostProduct></PostProduct>
  <DeleteProduct/>
</template>
<script>

import ProductCard from '@/components/ProductCard'
import {
  useProduct
} from '@/composables/useProduct'
import PostProduct from '@/components/PostProduct'
import DeleteProduct from '@/components/DeleteProduct'

export default {
  components: { ProductCard, PostProduct, DeleteProduct },
  setup () {
    const {
      getProducts, products
    } = useProduct()
    getProducts()
    return {
      products
    }
  }

}
</script>

<style>
.productList {
  display: flex;
  padding: 150px;
  justify-content: center;
  flex-wrap: wrap;
  gap: 25px;
}

body{
  background-size: cover;
  height: 100vh;
  background-position: center;
}
header{
  width:100%;
  height: 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  z-index: 99;
  box-shadow: 0 0 10px #000;
  background: #101010;
}
#chk1{
  display: none;
}
i{
  color: #fff;
  cursor: pointer;
}
header .logo{
  flex: 1;
  color:#fff;
  margin-left: 50px;
  text-transform: uppercase;
  font-size: 15px;
}
header .search-box{
  flex: 1;
  position: relative;
}
.search-box input{
  width:100%;
  height: 40px;
  border: none;
  outline: none;
  background:#f2f2f2;
  border-radius: 30px;
  color:gray;
  font-size: 16px;
  padding-left: 5px;
  padding-right: 40px;
  text-align: center;
}
.search-box button{
  cursor: pointer;
  width:40px;
  height: 40px;
  border-radius: 30px;
  border:none;
  position: absolute;
  top:0;
  right: 0;
  transform: scale(0.9);
  background: green;
  color: #fff;
}
header ul {
  flex:2;
  display: flex;
  justify-content: space-evenly;
}
header ul li{
  list-style: none;
}
header ul li a{
  text-decoration: none;
  color:#fff;
  font-weight: 600;
  text-transform: uppercase;
  padding: 10px 15px;
}
header ul li a:hover{
  border-bottom: 2px solid cadetblue;
}
header .menu{
  font-size: 2.5em;
  display: none;
}
@media(max-width:1000px){
  .search-box button{
    position: absolute;
  }
  header ul{
    position: fixed;
    top:100px;
    right: -100%;
    background: rgba(0,0,0,0.5);
    height: calc(100vh - 100px);
    width:50%;
    flex-direction: column;
    align-items: center;
    transition: right 0.5s linear;
  }

  header .menu{
    display: block;
    width:100px;
    text-align: center;
  }
  #chk1:checked ~ ul{
    right: 0;
  }
}
@media(max-width:600px){
  header .logo{
    font-size:10px;
    margin-left:8px;
  }
  header ul{
    width:100%;
  }
}
</style>
