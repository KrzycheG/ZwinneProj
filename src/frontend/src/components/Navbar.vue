<template>
  <header>
    <input type ="checkbox" name ="" id ="chk1">
    <div class="logo"><h1><router-link to="/">Twoja książka</router-link></h1></div>
    <div class="search-box">
      <form>
        <input type ="text" @input="handleChange" v-model="search" placeholder="Znajdź swoją ulubioną książkę">
        <button type ="submit"><i class="fa fa-search"></i></button>
      </form>
    </div>
    <ul>
      <li><router-link to="/" @click="selectCategory(''), setSearch('')">Strona główna</router-link></li>
      <CategoryDropdown></CategoryDropdown>
      <li><router-link to="/cart">Koszyk</router-link><span class="translate-middle badge rounded-pill bg-danger">{{totalItems}}</span></li>
      <li>
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </li>
    </ul>
    <div class="menu">
      <label for="chk1">
        <i class="fa fa-bars"></i>
      </label>
    </div>
  </header>
</template>

<script>
import CategoryDropdown from '@/components/CategoryDropdown'
import { useProduct } from '@/composables/useProduct'
import { useCartProduct } from '@/composables/useCartProduct'
export default {
  name: 'Navbar',
  components: { CategoryDropdown },
  data () {
    return {
      search: ''
    }
  },
  setup () {
    const {
      setSelectedCategory, setSearch
    } = useProduct()
    const selectCategory = (category) => {
      setSelectedCategory(category)
    }
    const handleChange = async event => {
      setSearch(event.target.value)
    }
    const {
      totalItems
    } = useCartProduct()
    return {
      selectCategory, totalItems, handleChange, setSearch
    }
  }
}
</script>

<style>
header{
  width:100%;
  height: 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: sticky;
  top: 0;
  z-index: 99;
  box-shadow: 0 0 10px #000;
  background: #101010;
}
#chk1{
  display: none;
}
i{
  color: #fff;
  cursor: pointer;
}
header .logo{
  flex: 1;
  color:#fff;
  margin-left: 50px;
  text-transform: uppercase;
  font-size: 15px;
}
.logo a{
  text-decoration: none;
  color: inherit;
}
header .search-box{
  flex: 1;
  position: relative;
}
.search-box input{
  width:100%;
  height: 40px;
  border: none;
  outline: none;
  background:#f2f2f2;
  border-radius: 30px;
  color:gray;
  font-size: 16px;
  padding-left: 5px;
  padding-right: 40px;
  text-align: center;
}
.search-box button{
  cursor: pointer;
  width:40px;
  height: 40px;
  border-radius: 30px;
  border:none;
  position: absolute;
  top:0;
  right: -60px;
  transform: scale(0.9);
  background: green;
  color: white;
}
header ul {
  align-items: center;
  flex:2;
  display: flex;
  justify-content: space-evenly;
}
header ul li{
  list-style: none;
}
header ul li a{
  text-decoration: none;
  color:#fff;
  font-weight: 600;
  text-transform: uppercase;
  padding: 10px 15px;
}
header ul li a:hover{
  border-bottom: 2px solid cadetblue;
}
header .menu{
  font-size: 2.5em;
  display: none;
}
@media(max-width:1000px){
  .search-box button{
    position: absolute;
  }
  header ul{
    position: fixed;
    top:100px;
    right: -100%;
    background: rgba(0,0,0,0.5);
    height: calc(100vh - 100px);
    width:50%;
    flex-direction: column;
    align-items: center;
    transition: right 0.5s linear;
  }
  header .menu{
    display: block;
    width:100px;
    text-align: center;
  }
  #chk1:checked ~ ul{
    right: 0;
  }
}
@media(max-width:600px){
  header .logo{
    font-size:10px;
    margin-left:8px;
  }
  header ul{
    width:100%;
  }
}
</style>
