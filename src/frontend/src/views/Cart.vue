<template>
  <div class="koszyk">
    <table>
      <tr>
        <th>Produkty</th>
        <th>Ilosć</th>
        <th>Wartość</th>
      </tr>
      <koszyk @product-delete="handleChange" @update-quantity="handleChange" v-for="product of products" :key="product.id" :product="product"/>
      <tr>
        <td></td>
        <td class="total-pricee"></td>
        <td class="total-pricee">Suma: {{Math.round(sum*100)/100}} zł</td>
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
    const handleChange = () => {
      getProducts()
      getsum()
    }
    return {
      products, sum, handleChange
    }
  }
}

</script>
<style>
button{
 float: right;
  margin-right: 60px;
}
.total-pricee{
  border-top: 3px solid #101010;
}
</style>
