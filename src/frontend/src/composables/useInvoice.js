import axios from 'axios'
import { computed, ref } from 'vue'

const state = ref({
  invoice: { }
})
export const useInvoice = () => {
  const getInvoice = async () => {
    const response = await axios.get('http://localhost:8080/api/v1/book/invoice')
    state.value.invoice = response.data[response.data.length - 1]
    return response
  }
  return {
    getInvoice,
    invoice: computed(() => state.value.invoice)
  }
}
