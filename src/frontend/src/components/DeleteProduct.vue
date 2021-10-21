<template>
<form @submit.prevent="Delete">
  <div>
    <label for="bookId"> ID ksiazki </label>
    <input type="text" id="bookId" required v-model = "formData.bookId">
    <button>usun</button>
  </div>
</form>
</template>

<script>
import axios from 'axios'
export default {
  name: 'DeleteProduct',
  data () {
    return {
      formData: {
        bookId: ''
      }
    }
  },
  methods: {
    Delete () {
      axios.delete('http://localhost:8080/api/v1/book/' + this.formData.bookId)
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
