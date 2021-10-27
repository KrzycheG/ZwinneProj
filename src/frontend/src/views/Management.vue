<template>
  <PostProduct></PostProduct>
  <DeleteProduct/>
</template>

<script>
import DeleteProduct from '@/components/DeleteProduct.vue'
import PostProduct from '@/components/PostProduct.vue'
export default {
  components: { PostProduct, DeleteProduct }
}
</script>
