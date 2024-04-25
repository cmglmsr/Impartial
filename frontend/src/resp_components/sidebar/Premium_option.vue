<template>
  
    <CCard style="width: 100%; height: 20%; margin-left: 0.5vw; margin-top: 1vw; padding-left: -75px; border: 0.5vw;">
      <CCardBody style="width: 110%; height: 50%">
        <CCardTitle
          style="width: auto; height: auto; font-size: 0.9vw; margin-left: -0.5vw;"
          >Premium Account</CCardTitle
        >
        <CCardText style="font-size: 0.6vw; margin-left: -1vw;"
          >Gain access to left, center, and right versions of the news with the
          innovative genAI feature of our application. Apply for
          premium now!</CCardText
        >
        <router-link
        class="apply-icon-buttons"
        :to="{ name: 'reg-page'}"
        >Apply</router-link
      >
      </CCardBody>
    </CCard>

    

</template>

<script setup>
import { CCard, CCardBody, CCardTitle, CCardText, CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
</script>

<style scoped>
.apply-icon-buttons {
  text-decoration: none;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.7vw;
  color: #11101d;
  text-align: center;
}
</style>
