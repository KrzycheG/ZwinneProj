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
        </div>
      </div>
    </td>
    <td>{{ product.quantity }}</td>
    <td>{{Math.round(product.price*product.quantity*100)/100}} zł</td>
  </tr>
</template>

<script>
export default {
  name: 'SummaryItem',
  props: ['product']
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
td:last-child{
  text-align: right;
}
th:last-child{
  text-align: right;
}
</style>
