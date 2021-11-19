<template>
  <div class="koszyk">
    <koszyk v-for="product of products" :key="product.id" :product="product"/>
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
      getProducts, products
    } = useCartProduct()
    getProducts()
    return {
      products
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
