<template>
  <div class="col-7 body">
    <div class="row" style="background-color: bisque; width: 100%; height: fit-content;">
        <div class="col-12" style="height: fit-content;">
            <Tab_wrapper>
                <Feed_tabs title="Left" @click="set_alignment('left')"><img class="img-fluid logo-padding" src="../../images/logo.png" /></Feed_tabs>
                <Feed_tabs title="Center" @click="set_alignment('center')" ></Feed_tabs>
                <Feed_tabs title="Right" @click="set_alignment('right')" ></Feed_tabs>
            </Tab_wrapper>
        </div>
    </div>
  </div>
</template>

<script>
import "./deneme.css";
import Tab_wrapper from '../feed/Tab_wrapper.vue';
import Feed_tabs from '../feed/Feed_tabs.vue';
import Feed from "../feed/Feed.vue";

export default {
  components: { Tab_wrapper, Feed_tabs, Feed },
}
</script>

<style>

</style>