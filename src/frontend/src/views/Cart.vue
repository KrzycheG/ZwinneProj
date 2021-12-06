<template>
  <div class="koszyk">
    <table>
      <tr>
        <th>Produkty</th>
        <th>Ilosć</th>
        <th>Wartość</th>
      </tr>
      <koszyk @product-delete="handleDelete" v-for="product of products" :key="product.id" :product="product"/>
    </table>
  </div>
  <div class="total-price">
    <table>
      <tr>
        <td>Suma</td>
        <td>{{sum}} zł</td>
      </tr>
    </table>
  </div>
  <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#checkout">Uzupełnij dane do wysyłki</button>
  <checkout></checkout>
</template>
<script>
import Checkout from '@/components/Checkout'
import Koszyk from '@/components/Koszyk'
import {
  useCartProduct
} from '@/composables/useCartProduct'
export default {
  components: { Checkout, Koszyk },
  setup () {
    const {
      getProducts, products, getsum, sum
    } = useCartProduct()
    getProducts()
    getsum()
    const handleDelete = () => {
      getProducts()
      getsum()
    }
    return {
      products, sum, handleDelete
    }
  }
}

</script>
<style>
button{
 float: right;
  margin-right: 60px;
}
</style>
