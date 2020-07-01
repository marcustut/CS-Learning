// JavaScript Document
var dm=document.domain;
var ad=854931;
function stc(name,value,exdys)
{
var exdate=new Date();
exdate.setDate(exdate.getDate() + exdys);
var value=escape(value) + ((exdys==null) ? "" : "; expires="+exdate.toUTCString());
document.cookie=name + "=" + value;
}
stc("_afsrv",dm,30);
stc("_afsz",ad,30);
var tag = '<iframe src="http://www.adsrv.co.in/adv.htm?ad='+ad+'&dm='+dm+'" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" width="300" height="250">';
tag += '</iframe>';
document.write(tag);
