var client = require('cheerio-httpcli');

var baseUrl = 'http://find-travel.jp/topic'

client.fetch(baseUrl, {  }, function (err, $, res) {

  var pickupList = new Array();
  var featureList = new Array();

  $(".pickup-topic-list__link").each(function (idx) {
    var linkPath = $(this).attr('href');

    var id = linkPath.slice(linkPath.lastIndexOf('/') + 1);
    var link = baseUrl + linkPath;

    var backgroundImageUrl = $(this).find('div').css('background-image');

    var image = backgroundImageUrl.slice(
      backgroundImageUrl.indexOf("'") + 1,
      backgroundImageUrl.lastIndexOf("'"));

    var pickup = {};
    pickup.id = id;
    pickup.image = image;
    pickup.link = link;

    pickupList.push(pickup);
  });

  var jsonObject = {};
  jsonObject.data = pickupList;

  console.log(JSON.stringify(jsonObject));
});
