<template>
  <div class="productList">
    <product-card @product-add="handleAdd" v-for="product of products" :key="product.id" :product="product"/>
  </div>
</template>
<script>
import ProductCard from '@/components/ProductCard'
import {
  useProduct
} from '@/composables/useProduct'
import { useCartProduct } from '@/composables/useCartProduct'
export default {
  components: { ProductCard },
  setup () {
    const {
      getProducts, products
    } = useProduct()
    getProducts()
    const {
      getProducts: getCartProducts
    } = useCartProduct()
    const handleAdd = () => {
      getCartProducts()
    }
    return {
      products, handleAdd
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
</style>
