<template>
  <div class="summaryItem">
    <table>
      <tr>
        <th>Produkty</th>
        <th>Ilosć</th>
        <th>Wartość</th>
      </tr>
      <summary-item v-for="product of products" :key="product.id" :product="product"/>
    </table>
  </div>
  <div class="total-pricee">
    <table>
      <tr>
        <td>Suma: {{sum}}</td>
      </tr>
      <tr>
        <p>{{ invoice.firstName }} {{ invoice.lastName }} </p>
        <p>ul. {{ invoice.street }} {{ invoice.houseNumber }}/{{ invoice.apartmentNumber }}</p>
        <p>{{ invoice.city }} {{ invoice.zipCode }}</p>
        <p>{{ invoice.country }}</p>
      </tr>

    </table>
  </div>
  <a href="/"><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#checkout" @click="Order">Zamawiam</button></a>
  <a href="/cart"><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#checkout">Powrót do koszyka</button></a>
</template>
<script>
import SummaryItem from '@/components/SummaryItem'
import { useCartProduct } from '@/composables/useCartProduct'
import { useInvoice } from '@/composables/useInvoice'
export default {
  components: { SummaryItem },
  setup () {
    const Order = async () => {
      window.open('http://localhost:8080/pdf/generate', 'blank')
    }
    const {
      getInvoice, invoice
    } = useInvoice()
    getInvoice()
    const {
      getProducts, products, getsum, sum
    } = useCartProduct()
    getProducts()
    getsum()

    return {
      products, sum, Order, invoice
    }
  }
}

</script>
<style>
button{
  float: right;
  margin-right: 60px;
}
.invoiceData{
  padding: 20px;
}
.total-pricee{
  border-top: 3px solid #101010;
}
</style>
