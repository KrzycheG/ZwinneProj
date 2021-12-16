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
    const products = await axios.get('http://localhost:8080//api/v1/cart/cartBookList').then(response => response.data)
    console.log(products)
    const quantities = await Promise.all(products.map(product => axios.get('http://localhost:8080/api/v1/cart/quantity/' + product.id).then(response => response.data[0])))
    console.log(quantities)
    state.value.products = products.map((product, index) => ({ ...product, quantity: quantities[index] }))
  }
  const getsum = async () => {
    const response = await axios.get('http://localhost:8080//api/v1/cart/suma')
    state.value.sum = response.data[0]
    return response
  }
  const total = computed(() => state.value.products.reduce((sum, product) => sum + product.quantity, 0))
  return {
    getProducts,
    products: computed(() => state.value.products),
    getsum,
    sum: computed(() => state.value.sum),
    totalItems: total
  }
}
