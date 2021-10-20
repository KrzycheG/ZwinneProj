<template>
  <article class="Product_Card" id="app">
    <!--uniwersalna scieżka do .jpg brak zdjecia, ktore bedzie wyswietlane w przypadku braku .jpg w bazie danego produktu -->
    <img class="product_image" src="../assets/brak_zdjecia.jpg">
    <p class="Product_name">{{ product.title }}</p>
    <div><span class="Product_price">{{ product.price }}zł</span>
      <button><img class="Add_to_cart" src="../assets/cart.png"></button>
    </div>
  </article>
</template>

<script>
export default {
  name: 'ProductCard',
  props: ['product']
}
</script>

<style lang="css" scoped>
.product_image {
  width: 150px;
  height: 200px;
  margin: 3px auto;
  display: list-item;
  border: 3px solid grey;
}

.Product_Card {
  border: solid 5px grey;
  width: 250px;
  height: 350px;
  display: block;
}

.Product_name {
  margin-left: 10px;
}

.Product_price {
  margin-left: 10px;
}

.Add_to_cart {
  width: 40px;
  height: 40px;
  background-color: grey;
  display: block;
  margin: auto;
}
</style>
