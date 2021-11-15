<template>
  <div class="modal fade" id="checkout" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Dane adresowe</h5>
        </div>
        <div class="modal-body">
          <CheckoutForm></CheckoutForm>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CheckoutForm from '@/components/CheckoutForm.vue'
export default {
  components: { CheckoutForm }
}
</script>
