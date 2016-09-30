var client = require('cheerio-httpcli');

var baseUrl = 'http://find-travel.jp/ranking/yesterday'

client.fetch(baseUrl, {  }, function (err, $, res) {

  var articleList = new Array();

  $(".article").each(function (idx) {

    var linkPath = $(this).find('a').attr('href');

    var id = linkPath.slice(linkPath.lastIndexOf('/') + 1);
    var image = $(this).find('.article-image-sq').attr('src');
    var link = baseUrl + linkPath;
    var title = $(this).find('.article-title').text().trim();
    var views = $(this).find('.view-count').text();

    var article = {};
    article.id = id;
    article.image = image;
    article.link = link;
    article.title = title;
    article.views = views;

    articleList.push(article);
  });

  var jsonObject = {};
  jsonObject.data = articleList;
  jsonObject.total_count = articleList.length;

  console.log(JSON.stringify(jsonObject));
});
