<template>
  <CCard style="width: 15rem; height: 13rem;">
    <CCardBody>
      <CCardTitle>Premium Account</CCardTitle>
      <CCardText class="sidebar-premium-division"
        >Premium's advantages summary and its additional features</CCardText
      >
      <div class="sidebar-premium-button">
        <CButton color="secondary" shape="rounded-pill">Apply for Premium</CButton>
      </div>
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
