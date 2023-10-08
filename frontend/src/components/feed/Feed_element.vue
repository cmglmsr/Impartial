<template>
  <div>
    <CCard style="width: 40rem" class="text-center">
      <img
        src="../../images/new.jpg"
        style="border-radius: 8px; height: 20rem"
      />
      <CCardTitle style="padding: 20px; font-size: 1.5rem">{{
        header
      }}</CCardTitle>
      <CCardSubtitle
        class="mb-2 text-muted"
        style="width: 40rem; font-size: 1.2rem"
        >Date: {{ date }}</CCardSubtitle
      >
      <CCardSubtitle
        class="mb-2 text-muted"
        style="width: 40rem; font-size: 1.2rem"
        >Source: {{ source }}</CCardSubtitle
      >
      <CCardBody style="align-self: center">
        <CCardText
          style="width: 30rem; padding: 20px; height: 10rem; text-align: center"
          >{{ content }}</CCardText
        >
        <i
          v-bind:class="{ heart_not_clicked: !heart_clicked, heart_clicked: heart_clicked }"
          v-on:click="heart_clicked = !heart_clicked"
          class="pi pi-heart"
          style="font-size: 1.5rem; padding-left: 30px; padding-right: 20px"
        ></i>
        <i
          v-bind:class="{ bookmark_not_clicked: !bookmark_clicked, bookmark_clicked: bookmark_clicked }"
          v-on:click="bookmark_clicked = !bookmark_clicked"
          class="pi pi-bookmark"
          style="font-size: 1.5rem; padding-left: 20px; padding-right: 20px"
        ></i>
        <i
          v-bind:class="{ feedback_not_clicked: !feedback_clicked, feedback_clicked: feedback_clicked }"
          v-on:click="feedback_clicked = !feedback_clicked"
          class="pi pi-pencil"
          style="font-size: 1.5rem; padding-left: 20px; padding-right: 10px"
        ></i>
      </CCardBody>
    </CCard>
  </div>
</template>

<script>
import { CCard } from "@coreui/vue";
import { CCardBody } from "@coreui/vue";
import { CCardTitle } from "@coreui/vue";
import { CCardText } from "@coreui/vue";
import "@coreui/coreui/dist/css/coreui.min.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "primeicons/primeicons.css";
import "./feed.css";

export default {
  name: "Feed_element",
  props: ["header", "content", "date", "source", "image"],
  components: {
    CCard,
    CCardBody,
    CCardTitle,
    CCardText,
  },
  data() {
    return {
      heart_clicked: false,
      bookmark_clicked: false,
      feedback_clicked: false
    };
  },
};
</script>
