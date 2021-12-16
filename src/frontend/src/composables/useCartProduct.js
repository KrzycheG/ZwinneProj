import axios from 'axios'
import { computed, ref } from 'vue'

const state = ref({
  products: [],
  sum: 0,
  totalItems: 0,
  quantity: 0
})
export const useCartProduct = () => {
  const getProducts = async () => {
    const response = await axios.get('http://localhost:8080//api/v1/cart/cartBookList')
    state.value.products = response.data
    return response
  }
  const getsum = async () => {
    const response = await axios.get('http://localhost:8080//api/v1/cart/suma')
    state.value.sum = response.data[0]
    return response
  }
  const getQuantity = async () => {
    const response = await axios.get('http://localhost:8080//api/v1/cart')
    state.value.quantity = response.data
    return response
  }
  return {
    getProducts,
    products: computed(() => state.value.products),
    getsum,
    sum: computed(() => state.value.sum),
    totalItems: computed(() => state.value.products.length),
    getQuantity,
    quantity: computed(() => state.value.quantity)
  }
}
