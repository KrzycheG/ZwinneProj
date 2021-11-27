<template>
  <article class="Product_Card" id="app">
    <img class="product_image" :src=product.cover>
    <div class="title">
      <span><strong>Tytuł:</strong></span>
      <p class="Product_name">{{ product.title }}</p>
    </div>
    <div class="authors">
      <span><strong>Autor:</strong></span>
      <p class="Product_author">{{product.author}}</p>
    </div>
    <div class="footer-card">
      <span class="Product_price">{{ product.price }}zł</span>
      <button class="Add_to_cart" @click="handleClick"><img class="CartIMG" src="../assets/cart.png"></button>
    </div>
  </article>
</template>

<script>
import axios from 'axios'

export default {
  name: 'ProductCard',
  props: ['product'],
  setup (props) {
    const handleClick = async () => {
      await axios.post('http://localhost:8080/api/v1/cart/books/' + props.product.id + '/carts', { cartID: Math.randomInt, quantity: 1 })
      alert('Dodano do koszyka!')
    }
    return {
      handleClick
    }
  }
}

</script>

<style lang="css" scoped>
.product_image {
  width: 150px;
  height: 200px;
  margin: 3px auto;
  display: list-item;
  box-shadow: 0 2px 3px 3px rgba(0,0,0,0.1);
}

.Product_Card {
  box-shadow: 0 2px 3px 3px rgba(0,0,0,0.1);
  width: 300px;
  height: 430px;
  display: flex;
  flex-direction: column;
  padding: 3px;
}

.Product_name {
  margin-left: 10px;
}

.Product_price {
  margin-left: 10px;
}
.Product_author {
  margin-left: 10px;
}
.Add_to_cart {
  width: 35px;
  height: 35px;
  margin: 0;
  padding: 0;
  border: 0;
  border-radius: 50%;
  overflow: hidden;
  background-color: limegreen;
}
.CartIMG{
  object-fit: cover;
  width: 100%;
}
.footer-card{
  display: flex;
  justify-content: flex-end;
  margin-top: auto;
  align-items: center;
  padding: 3px;
}
.authors, .title{
  flex:1;
}
</style>
