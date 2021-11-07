import axios from 'axios'
import { computed, ref } from 'vue'

const state = ref({
  products: [],
  categories: [],
  selectedCategory: ''
})
export const useProduct = () => {
  const getProducts = async () => {
    const response = await axios.get('http://localhost:8080/api/v1/book')
    state.value.products = response.data
    return response
  }
  const getCategories = async () => {
    const response = await axios.get('http://localhost:8080/api/v1/book/categories')
    state.value.categories = response.data
    return response
  }
  const filteredProducts = computed(() => state.value.selectedCategory ? state.value.products.filter((product) => product.categoryName === state.value.selectedCategory) : state.value.products)
  const setSelectedCategory = category => {
    state.value.selectedCategory = category
  }
  return {
    getProducts,
    products: filteredProducts,
    getCategories,
    categories: computed(() => state.value.categories),
    setSelectedCategory,
    selectedCategory: computed(() => state.value.selectedCategory)
  }
}
