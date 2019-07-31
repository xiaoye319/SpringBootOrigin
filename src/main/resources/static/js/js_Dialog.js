(function () {
  $.JsDialog = {
    Alert: function (title, msg) {
      GenerateHtml("alert", title, msg);
      btnOk(); //alert只是弹出消息，因此没必要用到回调函数callback
      btnNo();
    },
    Confirm: function (title, msg, callback) {
      GenerateHtml("confirm", title, msg);
      btnOk(callback);
      btnNo();
    },
    Toast: function(type, msg) {
      // types; success error info
      GenerateToast(type, msg);
    },
    openView: function(url,title) {
      // 弹出iframe
      GenerateView(url,title)
      closeView();
      submitView(url)
    }
  }
 
  //生成Html
  function GenerateHtml(type, title, msg) {
 
    var _html = "";
    _html += '<div id="JsDialog" class="hide"><div id="JsDialogCentered"><div id="JsDialogContent"><span id="JsDialogClose"></span>';
    _html += '<div id="JsDialogTitle">'+ title +'</div>'
    _html += '<div id="JsDialogText">' + msg + '</div>'
    _html += '<div id="JsDialogButtons">'
    if (type == "alert") {
      _html += '<div id="JsDialogButtonOK" class="JsDialogButton">确定</div>'
    }
    if (type == "confirm") {
      _html += '<div id="JsDialogButtonOK" class="JsDialogButton">确定</div>'
      _html += '<div id="JsDialogButtonCancle" class="JsDialogButton">取消</div>'
    }
    _html += '</div></div></div></div>';
    
    //必须先将_html添加到body，再设置Css样式
    $("body").append(_html);
    $('#JsDialog').attr('class','show')
  }
  //生成Toast
  function GenerateToast(type, msg) {
    if ($('#JsToast').length > 0) return
    var _html = "";
    _html += '<div id="JsToast" class="hide '+type+'"><div class="JsToastText">'+msg+'</div></div>';
    $("body").append(_html);
    setTimeout(function(){
      $('#JsToast').addClass('show')
    },500)
    hideToast()
  }
  // 生成iframe
  function GenerateView(url,title) {
     var _html = "";
     var dw = $(document).width()*0.7,
         dh = $(document).height()*0.6;

    _html += '<div id="JsIframe" class="hide"><div id="JsIframeCentered"><div id="JsFormContent" style="width:'+dw+'px;"><span id="JsViewClose"></span>';
    _html += '<div id="JsDialogTitle">'+ title +'</div>'
    _html += '<div id="JsFormMain" style="height:'+dh+'px;"><iframe id="viewForm" src="' + url + '"></iframe></div>'
    _html += '<div id="JsDialogButtons">'
    _html += '<div id="JsViewButtonOK" class="JsDialogButton">提交</div>'
    _html += '<div id="JsViewButtonCencle" class="JsDialogButton">关闭</div>'
    _html += '</div></div></div></div>';
    $("body").append(_html);
    $('#JsIframe').attr('class','show')
  }
  //确定按钮事件
  function btnOk(callback) {
    $("#JsDialogButtonOK").click(function () {
      $('#JsDialog').attr('class','hide')
      setTimeout(function(){
        $('#JsDialog').remove()
      },500)
      if (typeof (callback) == 'function') {
        callback();
      }
    });
  }
 
  //取消按钮事件
  function btnNo() {
    $("#JsDialogButtonCancle,#JsDialogClose").click(function () {
      $('#JsDialog').attr('class','hide')
      setTimeout(function(){
        $('#JsDialog').remove()
      },500)
    });
  }

  // Toast自动消失
  function hideToast() {
    setTimeout(function(){
      $('#JsToast').remove()
    },3500)
  }

  function closeView() {
    $("#JsViewButtonCencle,#JsViewClose").click(function () {
      $('#JsIframe').attr('class','hide')
      setTimeout(function(){
        $('#JsIframe').remove()
      },500)
    });
  }


})();
