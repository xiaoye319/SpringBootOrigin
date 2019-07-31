(function(para) {
  var p = para.sdk_url, n = para.name, w = window, d = document, s = 'script',x = null,y = null;
  w['sensorsDataAnalytic201505'] = n;
  w[n] = w[n] || function(a) {return function() {(w[n]._q = w[n]._q || []).push([a, arguments]);}};
  var ifs = ['track','quick','register','registerPage','registerOnce','trackSignup', 'trackAbtest', 'setProfile','setOnceProfile','appendProfile', 'incrementProfile', 'deleteProfile', 'unsetProfile', 'identify','login','logout','trackLink','clearAllRegister','getAppStatus'];
  for (var i = 0; i < ifs.length; i++) {
    w[n][ifs[i]] = w[n].call(null, ifs[i]);
  }
  if (!w[n]._t) {
    x = d.createElement(s), y = d.getElementsByTagName(s)[0];
    x.async = 1;
    x.src = p;
    x.setAttribute('charset','UTF-8');
    y.parentNode.insertBefore(x, y);
    w[n].para = para;
  }
})({
  sdk_url: 'https://static.sensorsdata.cn/sdk/1.11.2/sensorsdata.min.js',
  heatmap_url: 'https://static.sensorsdata.cn/sdk/1.11.2/heatmap.min.js',
  name: 'sa',
  web_url: 'https://uba.idengyun.cn/',
  server_url: 'https://dcs.idengyun.cn:8106/sa',
  /*线上生产*/
  //web_url: 'https://uba.idengyun.cn/?project=fzx',
  //server_url: 'https://dcs.idengyun.cn:8106/sa?project=fzx',
  heatmap:{}
});
var sto_userId = localStorage.getItem('sto_pc_userId');
var isLogin = false;
if(sto_userId != "" && sto_userId != null && sto_userId.length > 0){
  sa.login(sto_userId);  //神策标识真实用户 distinct_id
  isLogin = true;
}
sa.quick('autoTrack');
