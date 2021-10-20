import axios from 'axios'
import { computed, ref } from 'vue'

const products = ref([])
export const useProduct = () => {
  const getProducts = async () => {
    const response = await axios.get('http://localhost:8080/api/v1/book')
    products.value = response.data
    return response
  }
  return {
    getProducts,
    products: computed(() => products.value)
  }
}
