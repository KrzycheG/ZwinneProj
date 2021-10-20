<template>
  <header>
    NAZWA SKLEPU KATEGORIE KOSZYK
  </header>
  <div class="productList">
    <product-card v-for="product of products" :key="product.id" :product="product"/>
  </div>
</template>

<script>
import ProductCard from '@/components/ProductCard'
import {
  useProduct
} from '@/composables/useProduct'

export default {
  components: { ProductCard },
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
  justify-content: space-between;
}
</style>
