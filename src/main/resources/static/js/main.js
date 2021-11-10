const apiURL = "http://localhost:8080";

var app = new Vue({
  el: '#app',
  data() {
    return {
        news: []
    }
  },
  created() {
        fetch(apiURL)
            .then(response => {
                return response.json();
            })
            .then(news => {
                this.news = news;
            })
  }
});