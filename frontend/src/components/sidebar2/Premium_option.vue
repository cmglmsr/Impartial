<template>
  <div class="row" style="width: fit-content; height: fit-content; margin-top: 10%; background-color: #11101d; padding-right: 8%;">
    <CCard style="width: 100%; height: 100%;">
    <CCardBody style="width: 100%; height: 100%;">
      <CCardTitle style="width: auto; height: auto; font-size:1vw; margin-left: 8%;">Premium Account</CCardTitle>
      <CCardText style="font-size:0.75vw;"
        >Premium's advantages summary and its additional features</CCardText
      >
        <CButton color="secondary" shape="rounded-pill" style="font-size:0.75vw; margin-left: 10%;">Apply for Premium</CButton>
    </CCardBody>
  </CCard>
  </div>
</template>

<script setup>
import { CCard } from "@coreui/vue";
import { CCardBody } from "@coreui/vue";
import { CCardTitle } from "@coreui/vue";
import { CCardText } from "@coreui/vue";
import { CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
</script>

