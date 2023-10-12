<script setup>
import { onMounted, onUnmounted } from "vue";

//example components
import NavbarDefault from "../../examples/navbars/NavbarDefault.vue";
import DefaultFooter from "../../examples/footers/FooterDefault.vue";
import Header from "../../examples/Header.vue";
import FilledInfoCard from "../../examples/cards/infoCards/FilledInfoCard.vue";
import AboutTeam from "../LandingPages/AboutUs/Sections/AboutTeam.vue";


// sections
import PresentationCounter from "./Sections/PresentationCounter.vue";
import PresentationPages from "./Sections/PresentationPages.vue";
import PresentationExample from "./Sections/PresentationExample.vue";
import data from "./Sections/Data/designBlocksData";
import BuiltByDevelopers from "./Components/BuiltByDevelopers.vue";
import PresentationTestimonials from "./Sections/PresentationTestimonials.vue";
import PresentationInformation from "./Sections/PresentationInformation.vue";

//images
import github from "@/assets/img/unnamed.png";
import news from "@/assets/img/news.jpg"
import news2 from "@/assets/img/new2.jpg"
import news3 from "@/assets/img/news3.jpg"
import news4 from "@/assets/img/news4.jpg"
import news5 from "@/assets/img/news5.jpg"


//hooks
const body = document.getElementsByTagName("body")[0];
onMounted(() => {
  body.classList.add("presentation-page");
  body.classList.add("bg-gray-200");
});
onUnmounted(() => {
  body.classList.remove("presentation-page");
  body.classList.remove("bg-gray-200");
});
</script>

<template>
  <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
        <NavbarDefault :transparent="true" />
      </div>
    </div>
  </div>
  <Header>
    <div
      class="page-header min-vh-75"
      :style="`background-image: url(${news5})`"
      loading="lazy"
    >
      <div class="container">
        <div class="row">
          <div class="col-lg-7 text-center mx-auto position-relative">
            <h1
              :style="{ display: 'inline-block', color: 'black', fontWeight: 'bold'}"
            >
              Project's Name
            </h1>
            <p :style="{ fontWeight: '1000', color: 'black', fontWeight: 'bold', fontSize: '20px' }">
              CS491 Senior Design Project I / Computer Science / Bilkent University
            </p>
          </div>
        </div>
      </div>
    </div>
  </Header>

  <div
      class="container-fluid mt-sm-5 border-radius-xl"
      :style="{
        background: 'linear-gradient(195deg, rgb(66, 66, 74), rgb(25, 25, 25))'
      }"
    >
      <div
        class="page-header py-6 py-md-5 my-sm-3 mb-3 border-radius-xl"
        :style="{
          backgroundImage: `url(${wavesWhite})`
        }"
        loading="lazy"
      >
        <span class="mask bg-gradient-dark"></span>
        <div class="container" style="width: 100rem; height: 25rem;">
          <div class="row">
            <div class="d-flex justify-content-center p-5">
              <div class="col-lg-8 ms-lg-5 text-center">
                <h3 class="text-white">
                  About the Project
                </h3>
                <p class="text-white text-md">
                  Cause if you do, it can be yours for FREE. Hit the button
                  below to navigate to Creative Tim where you can <br />
                  find the Design System in HTML. Start a new project or give an
                  old Bootstrap project a new look!
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  <div class="card card-body blur shadow-blur mx-3 mx-md-4 mt-n6" style="padding-top: 50px;">
    <div class="container" style="padding-bottom: 50px;">
      <div class="row">
        <div class="col-lg-4" style="">
          <FilledInfoCard style="height: 10rem; border: 4px solid gray"
            class="px-lg-1 mt-lg-0 mt-4 p-4"
            :icon="{ component: 'receipt_long'}"
            title="Project Specification Document"
            :action="{
              route:
                '',
              label: { text: 'Click to download!', color: 'black'}
            }"
          />
        </div>
        <div class="col-lg-4" >
          <FilledInfoCard style="height: 10rem; border: 4px solid gray"
            class="px-lg-1 mt-lg-0 mt-4 p-4"
            :icon="{ component: 'receipt_long'}"
            title="Analysis and Requirement Report"
            :action="{
              route:
                '',
              label: { text: 'Click to download!',  color: 'black'  }
            }"
          />
        </div>
        <div class="col-lg-4">
          <FilledInfoCard style="height: 10rem; border: 4px solid gray; "
            class="px-lg-1 mt-lg-0 mt-4 p-4"
            :icon="{ component: 'receipt_long'}"
            title="Presentation"
            :action="{
              route:
                '',
                label: { text: 'Click to download!', color: 'black'}
            }"
          />
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="d-flex flex-column w-100 text-center p-5 mb-8">
          <h3>Project's GitHub Link</h3>
          <div class="d-flex justify-content-center mt-3 flex-wrap">
      
            <a
              href="https://github.com/cmglmsr/ORTACI-GAZETE"
              class="mx-3"
              data-bs-toggle="tooltip"
              data-bs-placement="bottom"
              title="Vue.js - Is a Progressive JavaScript Framework"
            >
              <img
                :src="github"
                alt="title"
                loading="lazy"
                :style="{ height: '90px' }"
              />
            </a>
          </div>
        </div>
      </div>
    </div>
    <div>
      <AboutTeam></AboutTeam>
    </div>
  </div>
  <DefaultFooter />
</template>
