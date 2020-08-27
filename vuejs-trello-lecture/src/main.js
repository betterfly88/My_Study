import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'

// Vue.config.productionTip = false
axios.defaults.headers.common['AJAX'] = 'true';

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})