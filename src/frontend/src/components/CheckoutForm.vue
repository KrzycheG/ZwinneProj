<template>
  <form @submit.prevent="handleSubmit">
    <div class="row mb-3">
      <div class="col">
        <input required type="text" class="form-control" v-model="invoice.firstName" placeholder="Imię">
      </div>
      <div class="col">
        <input required type="text" class="form-control" v-model="invoice.lastName" placeholder="Nazwisko">
      </div>
    </div>
    <div class="mb-3">
      <input required type="text" class="form-control" v-model="invoice.country" placeholder="Kraj">
    </div>
    <div class="input-group mb-3">
      <input required type="text" class="form-control" v-model="invoice.city" placeholder="Miasto">
      <input pattern="\d{5}" type="text" class="form-control" v-model="invoice.zipCode" placeholder="Kod pocztowy">
    </div>
    <div class="input-group mb-3">
      <input required type="text" class="form-control" v-model="invoice.street" placeholder="Ulica">
      <input pattern="\d+" type="text" class="form-control" v-model="invoice.houseNumber" placeholder="Numer domu">
      <input pattern="\d+" type="text" class="form-control" v-model="invoice.apartmentNumber" placeholder="Numer mieszkania">
    </div>
    <div>
      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Zamknij</button>
      <button type="submit" class="btn btn-primary">Zamawiam</button>
    </div>
  </form>
</template>
<script>
import { ref } from 'vue'
import axios from 'axios'
export default {
  setup () {
    const invoice = ref({
      lastName: '',
      firstName: '',
      street: '',
      apartmentNumber: '',
      houseNumber: '',
      city: '',
      zipCode: '',
      country: ''
    })
    const handleSubmit = async () => {
      await axios.post('http://localhost:8080/api/v1/book/invoice/add', {
        ...invoice.value,
        apartmentNumber: parseInt(invoice.value.apartmentNumber),
        houseNumber: parseInt(invoice.value.houseNumber),
        zipCode: parseInt(invoice.value.zipCode)
      })
      window.open('http://localhost:8080/pdf/generate', 'blank')
    }
    return { invoice, handleSubmit }
  }
}
</script>
