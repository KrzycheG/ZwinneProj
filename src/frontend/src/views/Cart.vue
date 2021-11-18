<template>
  <koszyk></koszyk>
  <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#checkout">Uzupełnij dane do wysyłki</button>
  <checkout></checkout>
</template>

<script>
import Checkout from '@/components/Checkout'
import Koszyk from '@/components/Koszyk'
export default {
  components: { Checkout, Koszyk }
}

</script>
<style>
button{
 float: right;
  margin-right: 60px;
}
</style>
