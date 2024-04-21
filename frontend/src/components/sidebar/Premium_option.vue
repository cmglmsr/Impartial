<template>
  <div
    class="row"
    style="
      width: fit-content;
      height: fit-content;
      margin-top: 10%;
      background-color: #11101d;
    "
  >
    <CCard style="width: fit-content; height: fit-content">
      <CCardBody style="width: 100%; height: 100%">
        <CCardTitle
          style="width: auto; height: auto; font-size: 0.9vw; margin-left: 8%"
          >Premium Account</CCardTitle
        >
        <CCardText style="font-size: 0.6vw"
          >"Gain access to left, center, and right versions of the news with the
          innovative genAI feature of our application. Apply for
          premium now!"</CCardText
        >
        <router-link
        class="icon-buttons"
        :to="{ name: 'reg-page'}"
        >Apply</router-link
      >
      </CCardBody>
    </CCard>
  </div>
</template>

<script setup>
import { CCard, CCardBody, CCardTitle, CCardText, CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
</script>

<style scoped>
.icon-buttons {
  text-decoration: none;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.7vw;
  background-color: #e0efff;
  margin-left: 2vw;
  margin-bottom: -3vw;
  color: #11101d;
}
</style>
