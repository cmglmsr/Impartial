<template>
  <div id="container">
    <body>
      <div class="card">
        <img src="../../images/news.jpg" alt="Breaking news" />
        <div class="card-details">
          <span class="tag">Date: {{ date }}</span>
          <span class="tag">Source: {{ source }}</span>
          <div class="name">{{ header }}</div>
          <p>
            {{ content }}
          </p>
          <router-link class="icon-buttons" :to="{ name: 'news-detail-page', params: { id: news_id } }">Read More</router-link
          ><button v-on:click="bookmark()" class="icon-buttons" >
            <i class="fa-regular fa-bookmark fa-xl" :class="{clicked2: bookmark_clicked}" ></i></button
          ><button v-on:click="show()" class="icon-buttons">
            <i class="fa-regular fa-comment fa-xl"></i></button
          ><button v-on:click="show2()" class="icon-buttons">
            GenAI Option
          </button>
            <div class="stars">
              <i class="fa-solid fa-star" :class="{star1_clicked: star1_clicked_var}" v-on:click="star1()"></i>
              <i class="fa-solid fa-star" :class="{star2_clicked: star2_clicked_var}" v-on:click="star2()"></i>
              <i class="fa-solid fa-star" :class="{star3_clicked: star3_clicked_var}" v-on:click="star3()"></i>
              <i class="fa-solid fa-star" :class="{star4_clicked: star4_clicked_var}" v-on:click="star4()"></i>
              <i class="fa-solid fa-star" :class="{star5_clicked: star5_clicked_var}" v-on:click="star5()"></i>
            </div>
          <div class="add-comment-popup" v-if="show_popup">
            <div class="add-comment-overlay">
              <div class="add-comment-popup-content">
                <h2>Add your comment to: {{ header }} as {{ username }}</h2>
                <div class="input-field">
                <input
                  type="text"
                  class="login-input"
                  id="email"
                  required
                  autocomplete="off"
                />
                <label for="email" class="login-label"
                  >Enter your comment...</label
                >
              </div>
                  <div class="add-comment-controls-versions">
                    <button class="add-comment-submit-btn" v-on:click="submit()">Submit</button>
                    <button class="add-comment-close-btn"  v-on:click="show()">Close</button>
                  </div>
              </div>
            </div>
          </div>
          <div class="generate-ai-popup" v-if="show_popup2">
            <div class="generate-ai-overlay">
              <div class="generate-ai-popup-content">
                <h2>Generate other versions of the article</h2>
                  <div class="generate-ai-controls-versions">
                    <button class="generate-ai-submit-btn" v-on:click="generate_left_version()">Left</button>
                    <button class="generate-ai-submit-btn" v-on:click="generate_center_version()">Center</button>
                    <button class="generate-ai-submit-btn" v-on:click="generate_right_version()()">Right</button>
                  </div>
                  <div class="generate-ai-controls-close">
                    <button class="generate-ai-close-btn"  v-on:click="show2()">Close</button>
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </body>
  </div>
</template>

<script>
import "./feed.css";
import "primeicons/primeicons.css";
import {axiosInstance, noAuthAxiosInstance} from "@/utils";
export default {
  name: "Feed_element",
  props: ["id", "header", "content", "date", "source", "image"],
  data() {
    return {
      news_id: 0,
      heart_clicked: false,
      bookmark_clicked: false,
      star1_clicked_var: false,
      star2_clicked_var: false,
      star3_clicked_var: false,
      star4_clicked_var: false,
      star5_clicked_var: false,
      show_popup: false,
      show_popup2: false,
      comments: ["comment1", "comment2"]
    };
  },
  methods: {
    generate_left_version: function(){
      this.$router.push({ path: 'generated-article-page/0' })
    },
    generate_center_version: function(){
      this.$router.push({ path: 'generated-article-page/0' })
    },
    generate_right_version: function(){
      this.$router.push({ path: 'generated-article-page/0' })
    },
    submit: function(){
      //TODO: post the comment
      this.show_popup = !this.show_popup;
    },
    heart: function () {
      this.heart_clicked = !this.heart_clicked;
    },
    bookmark: async function () {
        try {

            if(!this.bookmark_clicked){
                const resp = await axiosInstance.post(`news/bookmark/${this.id}`)
                console.log(resp)

            }
            else {
                const resp = await axiosInstance.delete(`news/bookmark/${this.id}`)
                console.log(resp)

            }
            this.bookmark_clicked = !this.bookmark_clicked;

        }catch (err) {
            console.log(err)
            //Todo
        }

    },
    show: function () {
      this.show_popup = !this.show_popup;
    },
    show2: function () {
      this.show_popup2 = !this.show_popup2;
    },
    star1: function () {
      this.star1_clicked_var = !this.star1_clicked_var;
    },
    star2: function () {
      this.star2_clicked_var = !this.star2_clicked_var;
      if(!this.star1_clicked_var){
        this.star1_clicked_var = !this.star1_clicked_var;
      }
    },
    star3: function () {
      this.star3_clicked_var = !this.star3_clicked_var;
      if(!this.star1_clicked_var){
        this.star1_clicked_var = !this.star1_clicked_var;
      }
      if(!this.star2_clicked_var){
        this.star2_clicked_var = !this.star2_clicked_var;
      }
    },
    star4: function () {
      this.star4_clicked_var = !this.star4_clicked_var;
      if(!this.star1_clicked_var){
        this.star1_clicked_var = !this.star1_clicked_var;
      }
      if(!this.star2_clicked_var){
        this.star2_clicked_var = !this.star2_clicked_var;
      }
      if(!this.star3_clicked_var){
        this.star3_clicked_var = !this.star3_clicked_var;
      }
    },
    star5: function () {
      this.star5_clicked_var = !this.star5_clicked_var;
      if(!this.star1_clicked_var){
        this.star1_clicked_var = !this.star1_clicked_var;
      }
      if(!this.star2_clicked_var){
        this.star2_clicked_var = !this.star2_clicked_var;
      }
      if(!this.star3_clicked_var){
        this.star3_clicked_var = !this.star3_clicked_var;
      }
      if(!this.star4_clicked_var){
        this.star4_clicked_var = !this.star4_clicked_var;
      }
    },
  },
};
</script>

<style scoped>

.clicked1{
  color: #a42323;
}

.clicked2{
  color: #4477cf;
}

.star1_clicked{
    color: #11101d;
    font-size: 30px;
    cursor: pointer;
}

.star2_clicked{
    color: #11101d;
    font-size: 30px;
    cursor: pointer;
}

.star3_clicked{
    color: #11101d;
    font-size: 30px;
    cursor: pointer;
}

.star4_clicked{
    color: #11101d;
    font-size: 30px;
    cursor: pointer;
}

.star5_clicked{
    color: #11101d;
    font-size: 30px;
    cursor: pointer;
}


.generate-ai-popup{
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.add-comment-popup{
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
  position: fixed;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
}

.generate-ai-popup .generate-ai-overlay{
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

.add-comment-popup .add-comment-overlay{
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

.generate-ai-popup .generate-ai-popup-content{
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

.add-comment-popup .add-comment-popup-content{
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

.generate-ai-popup .generate-ai-popup-content h2{
  margin: 10px 0px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.add-comment-popup .add-comment-popup-content h2{
  margin-top: 15px;
  margin-bottom: 60px;
  font-size: 25px;
  color: #11101d;
  text-align: center;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions{
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px ;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions{
  display: flex;
  justify-content: space-between;
  margin: 20px 0px 0px ;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close{
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-close{
  display: flex;
  margin-left: 38%;
  margin-top: 20px;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions button{
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close button{
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions button{
  padding: 10px 20px;
  border: none;
  outline: none;
  font-size: 15px;
  border-radius: 20px;
  cursor: pointer;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-close .generate-ai-close-btn{
  background: transparent;
  color: #11101d;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-close .add-comment-close-btn{
  background: transparent;
  color: #11101d;
}

.add-comment-popup .add-comment-popup-content .add-comment-controls-versions .add-comment-submit-btn{
  background:#11101d;
  color: #fff;
}

.generate-ai-popup .generate-ai-popup-content .generate-ai-controls-versions .generate-ai-submit-btn{
  background:#11101d;
  color: #fff;
}

.popup.active{
   top: 0px;
   transition: top 0ms ease-in-out 0ms;
}

.popup.active .overlay{
  opacity: 1;
  transition: all 300ms ease-in-out;
}

.pop.active .popup-content{
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
</style>
