import axios from 'axios'
import { computed, ref } from 'vue'

const state = ref({
  products: [],
  categories: [],
  selectedCategory: '',
  selectedSearch: ''
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
  const isInCategory = product => state.value.selectedCategory ? product.categoryName === state.value.selectedCategory : state.value.products
  const hasSearchInTitle = product => state.value.selectedSearch ? product.title.toLowerCase().includes(state.value.selectedSearch.toLowerCase()) : state.value.products
  const filteredItems = computed(() => (state.value.products.filter(product => isInCategory(product) && hasSearchInTitle(product))))
  // const filteredProducts = computed(() => state.value.selectedCategory ? (state.value.products.filter((product) => product.categoryName === state.value.selectedCategory)).filter((product) => product.title.toLowerCase().includes(state.value.selectedSearch.toLowerCase())) : state.value.products)
  // const searchedProducts = computed(() => state.value.selectedSearch ? state.value.products.filter((product) => product.title.toLowerCase().includes(state.value.selectedSearch.toLowerCase())) : state.value.products)
  const setSelectedCategory = category => {
    state.value.selectedCategory = category
  }
  const setSearch = search => {
    state.value.selectedSearch = search
    console.log(state.value.selectedSearch)
  }
  return {
    getProducts,
    products: filteredItems,
    getCategories,
    categories: computed(() => state.value.categories),
    setSelectedCategory,
    selectedCategory: computed(() => state.value.selectedCategory),
    setSearch,
    selectedSearch: computed(() => state.value.selectedSearch)
  }
}
