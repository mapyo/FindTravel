var client = require('cheerio-httpcli');

var baseUrl = 'http://find-travel.jp/topic'

function getImageUrl(backgroundImageUrl) {
  return backgroundImageUrl.slice(
    backgroundImageUrl.indexOf("'") + 1,
    backgroundImageUrl.lastIndexOf("'"));
}


client.fetch(baseUrl, {  }, function (err, $, res) {

  var pickupList = new Array();
  var featureList = new Array();

  $(".pickup-topic-list__link").each(function (idx) {
    var linkPath = $(this).attr('href');

    var id = linkPath.slice(linkPath.lastIndexOf('/') + 1);
    var link = baseUrl + linkPath;

    var backgroundImageUrl = $(this).find('div').css('background-image');

    var image = getImageUrl(backgroundImageUrl);

    var pickup = {};
    pickup.id = id;
    pickup.image = image;
    pickup.link = link;

    pickupList.push(pickup);
  });

  $(".topic-grid__item").each(function (idx) {
    var linkPath = $(this).find('a').attr('href');
    var backgroundImageUrl = $(this).find('.topic-grid__item__image').css('background-image');

    var id = linkPath.slice(linkPath.lastIndexOf('/') + 1);
    var link = baseUrl + linkPath;
    var image = getImageUrl(backgroundImageUrl);
    var title = $(this).find('.topic-grid__item__name').find('a').text();

    var feature = {};
    feature.id = id;
    feature.link = link;
    feature.image = image;
    feature.title = title;

    featureList.push(feature);
  });

  var jsonObject = {};
  jsonObject.pickup_features = pickupList;
  jsonObject.features = featureList;

  console.log(JSON.stringify(jsonObject));
});
