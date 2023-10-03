<template>
<div style="padding: 5px;">
  <CCard style="width: 18rem">
  <img src="../../images/new.jpg" style="border-radius: 8px;">
  <CCardTitle>Heading of the new</CCardTitle>
  <CCardBody>
    <CCardText>Summary of the new</CCardText>
    <CButton href="#">Like</CButton>
    <CButton href="#">Save</CButton>
    <CButton href="#">Feedback</CButton>
  </CCardBody>
</CCard>
</div>

</template>

<script setup>
import { CCard } from "@coreui/vue";
import { CCardImage } from "@coreui/vue";
import { CCardBody } from "@coreui/vue";
import { CCardTitle } from "@coreui/vue";
import { CCardText } from "@coreui/vue";
import { CButton } from "@coreui/vue";
import '@coreui/coreui/dist/css/coreui.min.css'
import 'bootstrap/dist/css/bootstrap.min.css'


</script>

<style></style>
