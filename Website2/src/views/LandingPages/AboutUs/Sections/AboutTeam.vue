<script setup>
// example component
import HorizontalTeamCard from "@/examples/cards/teamCards/HorizontalTeamCard.vue";

// images
import asli from "@/assets/img/asli.jpeg";
import nisa from "@/assets/img/nisa.jpeg";
import eren from "@/assets/img/eren.jpeg";
import cem from "@/assets/img/cem.jpeg";
import murat from "@/assets/img/murat.jpg";
import linkedin from "@/assets/img/linkedin.png";

</script>

<template>
  
  <div style="padding-left: 200px;">
    <section class="pb-5 position-relative bg-gradient-dark mx-n3" style="width: 100rem;">
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
            :profile="{ name: 'Aslı Karaman', link: 'https://www.linkedin.com/in/asl%C4%B1-karaman-2693b622b/'}"
            :position="{ label: 'Frontend Developer'}"
          />
        </div>
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5"
            :image="cem"
            :profile="{ name: 'Mustafa Cem Gülümser', link: 'https://www.linkedin.com/in/cem-g%C3%BCl%C3%BCmser-2b685a213/' }"
            :position="{ label: 'Frontend Developer'}"

          />
        </div>
      </div>
      <div class="row mt-4">
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-4 z-index-2"
            :image="nisa"
            :profile="{ name: 'Nisa Yılmaz', link: 'https://www.linkedin.com/in/nisa-yilmaz/' }"
            :position="{ label: 'Backend Developer'}"
          />
        </div>
        <div class="col-lg-6 col-12">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5 z-index-2"
            :image="eren"
            :profile="{ name: 'Eren Duran', link: 'https://www.linkedin.com/in/eren-duran-12b1b8227/'}"
            :position="{ label: 'AI/ML Engineer - Backend Developer'}"
          />
          
        </div>
      </div>

        <div class="row mt-4">
        <div class="col-lg-6 col-30">
          <HorizontalTeamCard
            class="mt-lg-4 mt-5 z-index-2"
            :image="murat"
            :profile="{ name: 'Murat Güney Kemal', link: 'https://www.linkedin.com/in/murat-kemal-b98b64203/'}"
            :position="{ label: 'AI/ML Engineer - Backend Developer'}"
          >
          </HorizontalTeamCard>
          
        </div>
      </div>
      
    </div>
  </section>
  </div>
 
</template>
