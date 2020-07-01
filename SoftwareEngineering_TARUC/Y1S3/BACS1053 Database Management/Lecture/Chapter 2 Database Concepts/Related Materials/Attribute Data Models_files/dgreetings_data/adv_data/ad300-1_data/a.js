 




































































































//----------------------------------------------------------- cki
function get_cookie(Name) {
  var search = Name + "="
  var returnvalue = "";
  if (document.cookie.length > 0) {
    offset = document.cookie.indexOf(search)
    if (offset != -1) { // if cookie exists
      offset += search.length
      // set index of beginning of value
      end = document.cookie.indexOf(";", offset);
      // set index of end of cookie value
      if (end == -1)
         end = document.cookie.length;
      returnvalue=unescape(document.cookie.substring(offset, end))
      }
   }
  return returnvalue;
}

//----------------------------------------------------------- cki


setTimeout("rmv()",8000);
function rmv(){
var div=document.getElementById("div")
div.style.display="none";
div.innerHTML = "";
div.parentNode.removeChild(div);
}
