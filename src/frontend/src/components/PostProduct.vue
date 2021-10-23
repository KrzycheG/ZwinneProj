<template>
    <form @submit.prevent="createPost">
      <div>
      <label for="titleId"> Title </label>
      <input type="text" id="titleId" required v-model = "formData.title">
      </div>
      <div>
        <label for="authorId"> Author </label>
        <input type="text" id="authorId" required v-model = "formData.author">
      </div>
      <div>
        <label for="publisherId"> publisher </label>
        <input type="text" id="publisherId" required v-model = "formData.publisher">
      </div>
      <div>
        <label for="publicationDateId"> publicationDate </label>
        <input type="text" id="publicationDateId" required v-model = "formData.publicationDate">
      </div>
      <div>
        <label for="PriceId"> Price </label>
        <input type="text" id="PriceId" required v-model = "formData.price">
      </div>
      <div>
        <label for="unitsInStockId"> units In Stock </label>
        <input type="text" id="unitsInStockId" required v-model = "formData.unitsInStock">
      </div>
      <div>
        <label for="categoryID"> Category id </label>
        <input type="text" id="categoryID" required v-model = "formData.categoryID">
      </div>
       <div>
              <label for="coverId"> Cover url </label>
              <input type="text" id="coverId" required v-model = "formData.cover">
            </div>
      <button>Add book</button>
    </form>
</template>

<script>
import axios from 'axios'
export default {
  name: 'PostProduct',
  data () {
    return {
      formData: {
        title: '',
        author: '',
        publisher: '',
        publicationDate: '',
        categoryID: '',
        price: '',
        unitsInStock: '',
        cover: ''

      }
    }
  },
  methods: {
    createPost () {
      axios.post('http://localhost:8080/api/v1/book/add', this.formData)
    }
  }
}
</script>

<style scoped>
  form{
    max-width: 420px;
    margin: 30px auto;
    background: white;
    text-align: left;
    padding: 40px;
    border-radius: 10px;
  }
  label{
    color:#aaa;
    display: inline-block;
    margin: 25px 0 15px;
    font-size: 0.6em;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: bold;
  }
  input{
    display:block;
    padding: 10px 6px;
    width:100%;
    box-sizing: border-box;
    border: none;
    border-bottom: 1px solid #ddd;
    color: #555;

  }
</style>
