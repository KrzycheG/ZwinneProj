<template>
  <span>work in progress</span>
  <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#checkout">Uzupełnij dane do wysyłki</button>
  <checkout></checkout>
</template>

<script>
import Checkout from '@/components/Checkout'
export default {
  components: { Checkout }
}

</script>
