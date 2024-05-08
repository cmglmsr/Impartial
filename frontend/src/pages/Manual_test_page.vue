<template>
  <div>
    <Navbar></Navbar>
    <div class="container-fluid">
      <div class="row no-shadow" style="width: 110%; height: 100%">
        <div class="col-2" style="display: inline">
          <Res_sidebar></Res_sidebar>
        </div>
        <div class="col-10 profile-page-card" style="height: 100%">
          <Tab_nav
            style="margin-left: 5vw"
            :tabs="['Manual Classifier', 'Manual Article Generation']"
            :selected="selected"
            @selected="setSelected"
          ></Tab_nav>
          <div v-if="selected === 'Manual Classifier'">
            <div class="row no-shadow adjustment">
              <div class="card" style="display: inline; height: fit-content">
                <div class="card-details">
                  <div class="header-main-page" style="margin-left: 15vw">
                    Paste the article you want to classify
                  </div>
                  <div>
                    <textarea
                      v-model="text"
                      class="comment-input"
                      placeholder="Enter your article"
                      style="margin-left: 7vw; font-size: 0.7vw"
                    ></textarea>
                  </div>
                  <div v-if="respReturned && !loading" style="text-align: center; font-size: 0.8vw;">This article is {{bias}} biased</div>
                  <div v-if="loading" class="spinner-border" role="status">
                      <span class="sr-only">Loading...</span>
                  </div>
                  <button
                    class="icon-buttons-main-page-not-auth"
                    v-on:click="classify"
                  >
                    Classify
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div v-if="selected === 'Manual Article Generation'">
            <div class="row no-shadow adjustment2">
              <div
                class="card"
                style="display: inline; height: fit-content; width: fit-content;"
              >
                <div class="card-details">
                  <div
                    style="
                      display: inline-block;
                      margin-right: 5vw;
                      align-items: center;
                      align-content: center;
                      align-self: center;
                    "
                  >
                    <div class="header-main-page" style="margin-left: 2vw">
                      Paste the article you want to generate its other side
                    </div>
                    <div>
                      <textarea
                        v-model="text"
                        class="comment-input"
                        placeholder="Enter your article"
                        style="width: 100%; margin-left: 1vw; font-size: 0.7vw"
                      ></textarea>
                    </div>
                    <div class="button-container">
                      <div class="text">Article Alignment:</div>
                      <button
                        class="alignment-btn"
                        v-for="(button, index) in buttons"
                        :key="index"
                        @click="setActive(index, button)"
                        :class="{ active: activeButton === index }"
                      >
                        {{ button }}
                      </button>
                    </div>
                    <div class="button-container">
                      <div class="text">Target Alignment:</div>
                      <button
                        class="alignment-btn"
                        v-for="(button, index1) in buttons"
                        :key="index1"
                        @click="setActive1(index1, button)"
                        :class="{ active: activeButton1 === index1 }"
                      >
                        {{ button }}
                      </button>
                    </div>
                    <div v-if="!loading" class="generate-button-container">
                      <button @click="generate" class="alignment-btn">Generate</button>
                    </div>
                    <div v-if="loading" class="spinner-border" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                  </div>
                  <div
                    style="
                      display: inline-block;
                      margin-right: 5vw;
                      align-items: center;
                      align-content: center;
                      align-self: center;
                    "
                  >
                    <div class="header-main-page" style="margin-left: 6vw; margin-bottom: -3vw">
                      Generated version
                    </div>
                    <div>
                      <textarea
                        v-model="generatedArticle"
                        class="comment-input"
                        style="
                          width: 120%;
                          height: 30vw;
                          margin-left: 1vw;
                          margin-right: 1vw;
                          font-size: 0.7vw;
                          margin-top: 5vw
                        "
                        readonly
                      ></textarea>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import Tab_nav from "../resp_components/tabs/Tab_nav_profile.vue";
import Navbar from "../components/navbar/Navbar.vue";
import Res_sidebar from "../resp_components/sidebar/Res_sidebar.vue";
</script>

<script>
import "./feed.css";
import "primeicons/primeicons.css";
import {axiosInstance, noAuthAxiosInstance} from "@/utils";
export default {
  name: "manual-test-page",
  data() {
    return {
      selected: "Manual Classifier",
      loading: false,
      respReturned: false,
      news_id: 0,
      text: "",
      bias: "",
      buttons: ["Left", "Center", "Right"],
      activeButton: null,
      activeButton1: null,
      target: "",
      current: "",
      generatedArticle: ""
    };
  },
  computed: {
    columnClass() {
      return this.isWide ? "col-10" : "col-7";
    },
  },
  methods: {
      setSelected(tab) {
      this.selected = tab;
      this.text = ""
      this.loading = false
    },
    async classify() {
        this.loading = true
        const resp = await noAuthAxiosInstance.post("/news/classify", {"text": this.text})
        this.loading = false
        this.bias = resp.data
        this.respReturned = true
    },
    chooseSide(targetAlignment, articleId, generatedText) {
      this.generatedArticles.push({
        id: articleId,
        content: generatedText,
        newAlignment: targetAlignment,
      });
    },
    async generate() {
      try {
        if (!this.loading) {
            this.loading = true
            const response = await axiosInstance.post(`/news/generate`, {
                "articleBody": this.text.replace(/[^\w\s.,!?]|[\r\n]/g, "").replace(/\n/g, " "),
                "currentAlignment":this.current,
                "targetAlignment": this.target
            });
            this.loading = false
            this.current = ""
            this.target = ""
            this.generatedArticle = response.data
        }
      } catch (e) {
          this.loading = false
          this.current = ""
          this.target = ""
          this.text = ""
      }
    },
    setActive(index, button) {
      this.activeButton = index;
      this.current = button
    },
    setActive1(index1, button) {
      this.activeButton1 = index1;
      this.target = button
    },
  },
};
</script>

<style scoped>
.button-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 1vw;
  margin-left: 1vw;
}

.generate-button-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 2vw;
  margin-left: 10vw;
}

.text {
  margin-left: 2vw;
}

.alignment-btn {
  background: #11101d;
  color: #fff;
  border: 2px solid #11101d;
  padding: 4px 12px;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
  border-radius: 15px;
  margin-left: 1vw;
}

.alignment-btn.active {
  background-color: #fff; /* Change this to the desired color */
  color: #11101d; /* Change this to the desired color */
}

.alignment-btn:not(:first-child) {
  margin-left: 1px;
}

.comment-input {
  width: 70%;
  height: 15vw;
  resize: vertical;
  margin-top: 3vw;
}

.profile-page-card {
  display: inline;
  height: 100%;
}
.adjustment {
  width: 145%;
  height: 150%;
  margin-top: 1vw;
  margin-left: 8vw;
}

.adjustment2 {
  width: 200%;
  height: 160%;
  margin-top: 1vw;
}

.h2-title {
  font-size: 15px;
}

.users-comment-to-post {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 600;
  font-size: 18px;
  margin-bottom: 50px;
}

.icon-buttons-comment-a {
  padding: 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 500;
  background-color: #bacdd8;
  font-size: 0.7vw;
}

.add-comment-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  position: fixed;
  z-index: 9999;
}

.add-comment-popup .add-comment-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
  position: fixed;
  z-index: 9999;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 650px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
  position: fixed;
  z-index: 9999;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.name-list-element {
  font-size: 18px;
  font-weight: 800;
  margin-top: 10px;
  color: #11101d;
}

.Navbar-text {
  font-family: "Poppins", sans-serif;
  color: #fff;
  font-size: 1.2vw;
  text-align: center;
  font-weight: 400;
  padding-top: 1vw;
  padding-right: 7vw;
}

.stars {
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
  gap: 1vw;
  margin-top: 10vw;
  padding-right: 40vw;
  padding-left: -40vw;
}

.stars i {
  color: #e6e6e6;
  font-size: 2vw;
  cursor: pointer;
}

.icon-buttons {
  text-decoration: none;
  padding: 0.9vw 1.2vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  margin-left: 3vw;
  margin-bottom: -3vw;
  color: #11101d;
}

.p-content {
  height: auto !important;
  font-size: "3vw";
  color: #11101d;
  line-height: 150%;
}

.name {
  font-size: 24px;
  font-weight: 600;
  margin-top: 16px;
  color: #11101d;
}

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

.tag {
  margin-top: 0.5vw;
  margin-left: 0.5vw;
  padding: 0.5vw 0.5vw;
  border: 0.2vw solid #e5eaed;
  border-radius: 1vw;
  font-size: 1vw;
  font-weight: 600;
  color: #11101d;
  width: auto;
  align-items: center;
}

.clicked1 {
  color: #a42323;
}

.clicked2 {
  color: #4477cf;
}
.star_clicked {
  color: #11101d;
  font-size: 30px;
  cursor: pointer;
}

.generate-ai-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.add-comment-popup {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.generate-ai-popup .generate-ai-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
}

.add-comment-popup .add-comment-overlay {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  opacity: 1;
  transition: opacity 100ms ease-in-out 200ms;
}

.generate-ai-popup .generate-ai-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.add-comment-popup .add-comment-popup-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 95%;
  max-width: 450px;
  background: #fff;
  padding: 25px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 300ms ease-in-out;
}

.generate-ai-popup .generate-ai-popup-content h2 {
  margin: 10px 0px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content h2 {
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions {
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-close {
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  button {
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-close
  .generate-ai-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-close
  .add-comment-close-btn {
  background: transparent;
  color: #11101d;
}

.add-comment-popup
  .add-comment-popup-content
  .add-comment-controls-versions
  .add-comment-submit-btn {
  background: #11101d;
  color: #fff;
}

.generate-ai-popup
  .generate-ai-popup-content
  .generate-ai-controls-versions
  .generate-ai-submit-btn {
  background: #11101d;
  color: #fff;
}

.popup.active {
  top: 0px;
  transition: top 0ms ease-in-out 0ms;
}

.popup.active .overlay {
  opacity: 1;
  transition: all 300ms ease-in-out;
}

.pop.active .popup-content {
  transform: translate(-50%, -50%) scale(1);
  opacity: 1;
}

.input-field {
  display: flex;
  flex-direction: column;
  position: relative;
}

.login-input {
  height: 45px;
  width: 100%;
  background: transparent;
  border: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  outline: none;
  margin-bottom: 40px;
  color: #40414a;
}

.input-field .login-label {
  position: absolute;
  top: 10px;
  left: 10px;
  pointer-events: none;
  transition: 0.5s;
}

.name-popup {
  font-size: 18px;
  font-weight: 600;
  margin-top: 12px;
  padding-bottom: 19px;
  color: #11101d;
  text-align: center;
}

@media screen and (max-width: 768px) {
  .adjustment {
    width: 135%;
    height: 60%;
    margin-top: 1vw;
    margin-left: 1vw;
  }

  .profile-page-card {
    display: inline;
    height: 100%;
    width: 60%;
  }
}
.icon-buttons-main-page-not-auth {
  text-decoration: none;
  padding: 0.5vw 0.5vw 0.5vw 0.5vw;
  border: none;
  border-radius: 2vw;
  font-weight: 600;
  font-size: 0.9vw;
  background-color: #e0efff;
  color: #11101d;
  margin-top: 3vw;
  margin-left: 22vw;
}

.icon-container {
  text-align: center;
  margin-left: 2.5vw;
}

.bookmark-icon-size {
  font-size: 2.5vw;
}
.username-comments {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 500;
  font-size: 1vw;
}
.img-style {
  height: 20vw;
}
.p-content-news-detail {
  margin-top: 0px;
  height: auto !important;
  font-size: 0.7vw;
  color: #11101d;
}

.comment-list {
  max-height: 15vw;
  overflow-y: auto;
  margin-bottom: 0;
}

.comment-items {
  list-style-type: none;
  padding: 0;
  font-size: 0.7vw;
  font-family: "Poppins", sans-serif;
}

.comment-item {
  border-bottom: 1px solid #11101d;
  padding: 0.3vw;
}

.header-main-page {
  font-size: 1vw;
  font-weight: 500;
  color: #11101d;
  margin-top: 0.4vw;
  margin-bottom: -1vw;
}

.date-source-main-page {
  font-size: 0.8vw;
  color: #09090f;
  font-weight: 500;
  margin-top: -12vw;
}

.name-news-comment {
  text-align: center;
  font-size: 1.5vw;
  font-weight: 600;
  color: #11101d;
  margin-bottom: 0.5vw;
}

/*.username-comments {
  font-family: "Poppins", sans-serif;
  color: #11101d;
  font-weight: 600;
  font-size: 0.9vw;
}

.comments-list-element {
  font-size: 0.8vw;
}

.comments-list {
  margin-bottom: 2vw;
  text-align: left;
  align-items: center;
  list-style: none;
}

#container-news-comment {
  overflow-y: scroll;
  overflow-x: hidden;
  width: 43vw;
  height: 13vw;
}*/

.card-details {
  padding: 1.5vw 1.5vw 2vw;
}

@media screen and (max-width: 768px) {
  .icon-buttons-main-page-not-auth {
    text-decoration: none;
    padding: 1vw 1vw 1vw 1vw;
    border: none;
    border-radius: 2vw;
    font-weight: 600;
    font-size: 2vw;
    background-color: #e0efff;
    color: #11101d;
    margin-top: 3vw;
    margin-left: 25vw;
  }

  .icon-container {
    text-align: center;
    margin-left: 3.5vw;
  }
  .bookmark-icon-size {
    font-size: 5vw;
  }
  .username-comments {
    font-family: "Poppins", sans-serif;
    color: #11101d;
    font-weight: 500;
    font-size: 1.5vw;
  }
  .name-news-comment {
    text-align: center;
    font-size: 2vw;
    font-weight: 600;
    color: #11101d;
    margin-bottom: 0.5vw;
  }
  .img-style {
    height: 25vw;
  }
  .card-details {
    padding: 1vw 1vw 0;
  }

  .header-main-page {
    font-size: 1.5vw;
    font-weight: 500;
    color: #11101d;
    margin-top: 0.4vw;
    margin-bottom: -2vw;
  }

  .date-source-main-page {
    font-size: 1.5vw; /* Adjust font size if necessary */
  }

  .p-content-news-detail {
    height: auto !important;
    font-size: 1.5vw;
    color: #11101d;
  }

  .comment-items {
    list-style-type: none;
    padding: 0;
    font-size: 1.2vw;
    font-family: "Poppins", sans-serif;
  }
}

.comment-list::-webkit-scrollbar {
  width: 8px;
}

.comment-list::-webkit-scrollbar-thumb {
  background-color: #888;
  border-radius: 4px;
}

.comment-list::-webkit-scrollbar-thumb:hover {
  background-color: #11101d;
}
</style>
