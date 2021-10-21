<template>
  <header>
    NAZWA SKLEPU KATEGORIE KOSZYK
  </header>
  <div class="productList">
    <product-card v-for="product of products" :key="product.id" :product="product"/>
  </div>

  <PostProduct></PostProduct>
  <DeleteProduct/>
</template>
<script>

import ProductCard from '@/components/ProductCard'
import {
  useProduct
} from '@/composables/useProduct'
import PostProduct from '@/components/PostProduct'
import DeleteProduct from '@/components/DeleteProduct'

export default {
  components: { ProductCard, PostProduct, DeleteProduct },
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
