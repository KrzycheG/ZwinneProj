<template>
<div class="small-container cart-page">
    <table>
      <tr>
        <td>
          <div class="cart-info">
            <img :src="product.cover">
            <div>
              <p>Autor: {{product.author}}</p>
              <p>Tytuł: {{product.title}}</p>
              <p>Gatunek: {{product.categoryName}}</p>
              <p>id: {{product.id}}</p>
              <small>Cena: {{product.price}} zł </small>
              <br>
              <button class="Delete_from_cart" @click="deleteClick"> Usuń</button>
            </div>
          </div>
        </td>
        <td><input type="number" value="1"></td>
        <td>{{product.price}} zł</td>
      </tr>
    </table>

</div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Koszyk',
  props: ['product'],
  setup (props) {
    const deleteClick = async () => {
      await axios.delete('http://localhost:8080/api/v1/cart/books/carts/' + props.product.id)
      window.location.reload()
    }
    return {
      deleteClick
    }
  }
}
</script>

<style>
.cart-page{
  margin: 60px ;
  max-width: 100%;
  font-size: 20px;

}
table{
  width: 100%;
  border-collapse: collapse;

}
.cart-info{
  display: flex;
  flex-wrap: wrap;
}
th{
  text-align:left;
  padding: 5px;
  color: white;
  background: #101010;
  font-weight: normal;
}
td{
  padding: 10px 5px;
}
td input{
  width: 40px;
  height: 30px;
  padding: 5px;

}
td a{
  color: red;
  font-size: 12px;

}
td img{
  width: 200px;
  height: 200px;
  margin-right: 20px;
  box-shadow: 0 0 10px #000;
}
.total-price{
  display: flex;
  justify-content: flex-end;

}
.total-price table{
  border-top: 3px solid #101010;
  width: 100%;
  max-width: 470px;

}
td:last-child{
  text-align: right;
}
th:last-child{
  text-align: right;
}
</style>
