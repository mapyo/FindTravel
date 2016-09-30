var client = require('cheerio-httpcli');

var baseUrl = 'http://find-travel.jp/ranking/yesterday'

client.fetch(baseUrl, {  }, function (err, $, res) {
    $(".article").each(function (idx) {
      var image = $(this).find('.article-image-sq').attr('src');
      var link = baseUrl + $(this).find('a').attr('href');
      var title = $(this).find('.article-title').text().trim();
      var views = $(this).find('.view-count').text();

      process.exit();
    });
});
