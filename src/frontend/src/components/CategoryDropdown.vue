<template>
  <li class="nav-item dropdown">
    <a class="dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
      Kategorie
    </a>
    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
      <li v-for="category of categories" class="dropdown-item" :key="category" @click="selectCategory(category)"><router-link class="dropdown-item" to="'/">{{ category }}</router-link></li>
    </ul>
  </li>
</template>

<script>
import { useProduct } from '@/composables/useProduct'

export default {
  name: 'CategoryDropdown',
  setup () {
    const {
      getCategories, categories, setSelectedCategory
    } = useProduct()
    getCategories()
    const selectCategory = (category) => {
      setSelectedCategory(category)
    }
    return {
      categories, selectCategory
    }
  }
}
</script>
