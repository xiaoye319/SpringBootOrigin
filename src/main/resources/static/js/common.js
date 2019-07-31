$(function(){
  var browser={versions:function(){var a=navigator.userAgent;return{trident:-1<a.indexOf("Trident"),presto:-1<a.indexOf("Presto"),webKit:-1<a.indexOf("AppleWebKit"),gecko:-1<a.indexOf("Gecko")&&-1==a.indexOf("KHTML"),mobile:!!a.match(/AppleWebKit.*Mobile.*/),ios:!!a.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),android:-1<a.indexOf("Android")||-1<a.indexOf("Adr"),iPhone:-1<a.indexOf("iPhone"),iPad:-1<a.indexOf("iPad"),webApp:-1==a.indexOf("Safari"),weixin:-1<a.indexOf("MicroMessenger"),qq:" qq"==a.match(/\sQQ/i)}}(),
  language:(navigator.browserLanguage||navigator.language).toLowerCase()};(browser.versions.mobile||browser.versions.android||browser.versions.ios)&&$("html,body").addClass("mobile-style");
})
