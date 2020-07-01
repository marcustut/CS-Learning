(function($){
$.fn.pagination=function(_2,_3){
_3=$.extend({items_per_page:10,num_display_entries:10,current_page:0,num_edge_entries:0,link_to:"#",prev_text:"Prev",next_text:"Next",ellipse_text:"...",prev_show_always:true,next_show_always:true,callback:function(){
return false;
}},_3||{});
return this.each(function(){
function numPages(){
return Math.ceil(_2/_3.items_per_page);
}
function getInterval(){
var _4=Math.ceil(_3.num_display_entries/2);
var np=numPages();
var _6=np-_3.num_display_entries;
var _7=_8>_4?Math.max(Math.min(_8-_4,_6),0):0;
var _9=_8>_4?Math.min(_8+_4,np):Math.min(_3.num_display_entries,np);
if(_3.num_display_entries/2!=_4){
return [_7+1,_9];
}else{
return [_7,_9];
}
}
function pageSelected(_a,_b){
_8=_a;
drawLinks();
var _c=_3.callback(_a,_d);
if(!_c){
if(_b.stopPropagation){
_b.stopPropagation();
}else{
_b.cancelBubble=true;
}
}
return _c;
}
function drawLinks(){
_d.empty();
var _e=getInterval();
var np=numPages();
var _10=function(_11){
return function(evt){
return pageSelected(_11,evt);
};
};
var _13=function(_14,_15){
_14=_14<0?0:(_14<np?_14:np-1);
_15=$.extend({text:_14+1,classes:""},_15||{});
if(_14==_8){
var lnk=$("<span class=\"current\">"+(_15.text)+"</span>");
}else{
var lnk=$("<a>"+(_15.text)+"</a>").bind("click",_10(_14));
if((typeof _3.link_to)=="function"){
lnk.attr("href",_3.link_to(_14));
}else{
lnk.attr("href",_3.link_to.replace(/__id__/,_14));
}
}
if(_15.classes){
lnk.addClass(_15.classes);
if(_15.classes=="next"||_15.classes=="prev"){
lnk.removeClass("current");
lnk.addClass("disabled");
}
}
_d.append(lnk);
};
if(_3.prev_text&&(_8>0||_3.prev_show_always)){
_13(_8-1,{text:_3.prev_text,classes:"prev"});
}
if(_e[0]>0&&_3.num_edge_entries>0){
var end=Math.min(_3.num_edge_entries,_e[0]);
for(var i=0;i<end;i++){
_13(i);
}
if(_3.num_edge_entries<_e[0]&&_3.ellipse_text){
$("<span>"+_3.ellipse_text+"</span>").appendTo(_d);
}
}
for(var i=_e[0];i<_e[1];i++){
_13(i);
}
if(_e[1]<np&&_3.num_edge_entries>0){
if(np-_3.num_edge_entries>_e[1]&&_3.ellipse_text){
$("<span>"+_3.ellipse_text+"</span>").appendTo(_d);
}
var _19=Math.max(np-_3.num_edge_entries,_e[1]);
for(var i=_19;i<np;i++){
_13(i);
}
}
if(_3.next_text&&(_8<np-1||_3.next_show_always)){
_13(_8+1,{text:_3.next_text,classes:"next"});
}
}
var _8=_3.current_page;
_2=(!_2||_2<0)?1:_2;
_3.items_per_page=(!_3.items_per_page||_3.items_per_page<0)?1:_3.items_per_page;
var _d=$(this);
this.selectPage=function(_1a){
pageSelected(_1a);
};
this.prevPage=function(){
if(_8>0){
pageSelected(_8-1);
return true;
}else{
return false;
}
};
this.nextPage=function(){
if(_8<numPages()-1){
pageSelected(_8+1);
return true;
}else{
return false;
}
};
drawLinks();
});
};
})(jQuery);
