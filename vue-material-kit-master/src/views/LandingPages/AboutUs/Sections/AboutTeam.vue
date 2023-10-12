<script setup>
// example component
import HorizontalTeamCard from "@/examples/cards/teamCards/HorizontalTeamCard.vue";

// images
import emma from "@/assets/img/team-5.jpg";
import william from "@/assets/img/bruce-mars.jpg";
import ivana from "@/assets/img/ivana-squares.jpg";
import marquez from "@/assets/img/ivana-square.jpg";
import asli from "@/assets/img/asli.jpeg";
import nisa from "@/assets/img/nisa.jpeg";
import eren from "@/assets/img/eren.jpeg";
import cem from "@/assets/img/cem.jpeg";
</script>

<template>
  <section class="pb-5 position-relative bg-gradient-dark mx-n3">
    <div class="container">
      <div class="row">
        <div class="col-md-8 text-start mb-5 mt-5">
          <h3 class="text-white z-index-1 position-relative">
            The Project Team
          </h3>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-4"
            :image="asli"
            :profile="{ name: 'Aslı Karaman', link: 'javascript:;' }"
            :position="{ label: 'Frontend Developer', color: 'success' }"
          />
        </div>
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5"
            :image="cem"
            :profile="{ name: 'Mustafa Cem Gülümser', link: 'javascript:;' }"
            :position="{ label: 'Frontend Developer', color: 'success' }"

          />
        </div>
      </div>
      <div class="row mt-4">
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-4 z-index-2"
            :image="nisa"
            :profile="{ name: 'Nisa Yılmaz', link: 'javascript:;' }"
            :position="{ label: 'Backend Developer', color: 'success' }"
          />
        </div>
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5 z-index-2"
            :image="eren"
            :profile="{ name: 'Eren Duran', link: 'javascript:;' }"
            :position="{ label: 'Backend Developer', color: 'success' }"
          />
          
        </div>
      </div>

        <div class="row mt-4">
        <div class="col-lg-6 col-30">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5 z-index-2"
            :image="marquez"
            :profile="{ name: 'Murat Güney Kemal', link: 'javascript:;' }"
            :position="{ label: 'AI/ML Engineer', color: 'success' }"
          />
          
        </div>
      </div>
      
    </div>
  </section>
</template>
