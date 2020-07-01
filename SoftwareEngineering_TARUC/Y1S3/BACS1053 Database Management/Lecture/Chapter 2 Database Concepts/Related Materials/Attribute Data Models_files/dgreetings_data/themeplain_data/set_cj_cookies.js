// $(document).ready(function() {
//   // Commission Junction: save 'aid' and 'pid' params as cookies if param 'cj=true'.
//   var params = $.deparam.querystring();
//   if ('true' == params['cj']) {
//     $.cookie('aid', params['aid'], { path: '/' });
//     $.cookie('pid', params['pid'], { path: '/' });
//     $.cookie('cj', params['cj'], { path: '/' });
//   }else if ('false' == params['cj']) {
//     $.cookie('aid', null, { path: '/' });
//     $.cookie('pid', null, { path: '/' });
//     $.cookie('cj', null, { path: '/' });
//   }
// });
function set_cj_cookie()
{
  // Commission Junction: save 'aid' and 'pid' params as cookies if param 'cj=true'.
  var params = $.deparam.querystring();
  if ('true' == params['cj']) {
    $.cookie('aid', params['aid'], { path: '/' });
    $.cookie('pid', params['pid'], { path: '/' });
    $.cookie('cj', params['cj'], { path: '/' });
  }else if ('false' == params['cj']) {
    $.cookie('aid', null, { path: '/' });
    $.cookie('pid', null, { path: '/' });
    $.cookie('cj', null, { path: '/' });
  }
}