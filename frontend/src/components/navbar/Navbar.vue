<template>
<CNavbar color-scheme="light" class="Navbar">
  <CContainer fluid>
    <CNavbarBrand class="Navbar-text">
       Impartial
    </CNavbarBrand>
  </CContainer>
</CNavbar>
</template>

<script>
import "@coreui/coreui/dist/css/coreui.min.css";
import { CNavbar } from "@coreui/vue";
import { CContainer } from "@coreui/vue";
import { CNavbarBrand } from "@coreui/vue";
import "./navbar.css"
export default {
    components:{
        CNavbar,
        CContainer,
        CNavbarBrand
    }
}
</script>

<style>

</style>