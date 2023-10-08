<template>
  <CCard style="width: 100%; height: auto; height: 100%;">
    <CCardBody style="width: 100%; height: 100%; padding: 10%;">
      <CCardTitle style="width: auto; height: auto;">Premium Account</CCardTitle>
      <CCardText class="sidebar-premium-division"
        >Premium's advantages summary and its additional features</CCardText
      >
        <CButton color="secondary" shape="rounded-pill" class="sidebar-premium-button" >Apply for Premium</CButton>

    </CCardBody>
  </CCard>
</template>

<script setup>
import { CCard } from "@coreui/vue";
import { CCardBody } from "@coreui/vue";
import { CCardTitle } from "@coreui/vue";
import { CCardText } from "@coreui/vue";
import { CButton } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
import "./sidebar.css"
</script>

<style></style>
