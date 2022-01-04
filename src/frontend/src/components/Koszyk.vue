<template>
      <tr>
        <td>
          <div class="cart-info">
            <img alt="okładka" :src="product.cover">
            <div>
              <p>Autor: {{product.author}}</p>
              <p>Tytuł: {{product.title}}</p>
              <p>Gatunek: {{product.categoryName}}</p>
              <small>Cena: {{product.price}} zł </small>
              <p></p>
              <small>Dostępna ilość: {{product.unitsInStock}}</small>
            </div>
          </div>
        </td>
        <td><input class="input-box" @change="handleChange" type="number" :value="product.quantity"><button class="btn btn-primary" @click="deleteClick"> Usuń</button></td>
        <td>{{Math.round(product.price*product.quantity*100)/100}} zł</td>
      </tr>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Koszyk',
  props: ['product'],
  setup (props, { emit }) {
    const deleteClick = async () => {
      await axios.delete('http://localhost:8080/api/v1/cart/books/carts/' + props.product.id)
      emit('product-delete', props.product.id)
    }
    const handleChange = async event => {
      if (event.target.value === '0') {
        return deleteClick()
      }
      if (event.target.value > props.product.unitsInStock) {
        alert('Dostępna ilość produktów w magazynie: ' + props.product.unitsInStock)
        event.target.value = props.product.unitsInStock
      }
      await axios.get('http://localhost:8080/api/v1/cart/quantityAdd/' + props.product.id + '/' + event.target.value)
      emit('update-quantity', props.product.id, event.target.value)
    }
    return {
      deleteClick, handleChange
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
.input-box{
  width: 60px ;
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
td:last-child{
  text-align: right;
}
th:last-child{
  text-align: right;
}
</style>
