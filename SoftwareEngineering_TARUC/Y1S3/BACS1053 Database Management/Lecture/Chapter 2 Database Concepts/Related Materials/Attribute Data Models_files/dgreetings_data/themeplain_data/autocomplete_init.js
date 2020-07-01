function autocompleteInit(element_id,localData,ajaxUrl,element_code,dataReference, hidden2, elemWidth) {

		$(element_id).autocomplete(localData, {
			url:ajaxUrl,
			minChars: 3,
			max: 10,
			autoFill: false,
			mustMatch: false,
			matchContains: false,
			cacheLength: 100,
			matchSubset: true,
			scroll: false,
			loadingClass:'ac_loading',
			dataType:'jsonp',
			extraParams:{ format: 'jsonp' },
			parse:function(data){
				if(data&&data.r&&data.r.length>0){
					var parsed=[];
					for(var i=0,l=data.r.length;i<l;i++){
						var result=data.r[i];
						parsed[i]={data:result,value:result.id,result:result.fn};
					}
					return parsed;
				}else{
					 // No results - show a message.
					 $(element_id).removeClass('ac_loading');
					 return [{ data: { fn: 'No matching locations', c: '' }, value: '', result: '' }];
				}
			},
			formatItem:function(result){
				var listItem	= (( result.c && result.c.length > 0)? '<em>' + format_result(result.fn) + '</em>' + '<p>' + result.c + '</p>' : '');
				listItem = listItem.length > 0 ? listItem : result.fn;
				return listItem;				
			},
			formatResult: function(data){		
				var inputVal = data.fn.replace(new RegExp(".*<em>([^<]*)</em>.*", "gi"), "$1");
				inputVal = (inputVal.length > 0 ? inputVal : data.fn.replace(new RegExp(".*<p>([^<]*)</p>.*", "gi"), "$1")); 
				return inputVal;
			},
			show: function(){
				var resultsEl = $('.ac_results');
				var resultsWidth = resultsEl.width();
				var w = 0;
				if ($.browser.msie && parseInt($.browser.version, 10) <= 6){
					resultsEl.css({
						'white-space': 'nowrap'
					});
					var widths = [];
					resultsEl.find('li').each(function(i, n){
						widths.push($(n).outerWidth(true));
					});
					w = Math.max.apply(Math, widths);
				} else {
					w = resultsEl.css('width', 'auto').width();
				}
				if (w<resultsWidth){
					resultsEl.css('width', resultsWidth);
				} else if ($.browser.msie && parseInt($.browser.version, 10) <= 7){
					var maxW = resultsWidth*1.5;
					resultsEl.css('width', (w>maxW) ? maxW : w);
				}
			}
		});

		$(element_id).result(function(event, data, formatted)
		{			
			var hidden = $(element_code);
			
			if(dataReference == "flights")
			{
				hidden.val(data.c);
			}
			else if(dataReference == "hotels")
			{
				hidden.val(data.id);
				$(hidden2).val(data.c);				
			}
			
			// code to hide compare flights to zuji
			if (element_id == '#wg_origin')
			{
				$('#wg_flights_search').find('li.wg_extra input#wg_comparezuji').attr('checked', false);
				
				if( ! (data.c == 'SIN' || data.c == 'HKG' || data.cc == 'AU') )
				{
					$('#wg_flights_search').find('li.wg_extra').css('visibility', 'hidden');
				}
				else
				{
					$('#wg_flights_search').find('li.wg_extra').css('visibility', 'visible');					
				}
			}
			
		});

		$(element_id).click(function(event)
		{
			$(element_id).focus();
			$(element_id).select();				
			return false;
		});

}

function format_result(s)
{
	var result = s.split('(');
	var key;
	for(var x=0; x<result.length; x++)
	{ 
		key = result[x].substr(3);
		if(key.substr(0, 1) == ')')
		{
			key = result[x].substr(0,3);
		}
	}
	result = result.join('(');
	return $.trim(result.replace(' ('+key+')', ''));
}

var fcities = [
	{"cc": "ID", "c": "DPS", "fn": "Bali (Denpasar), Indonesia (DPS)", "id": 1828},
	{"c": "BKK", "cc": "TH", "fn": "Bangkok, Thailand (BKK)", "id": 757},
	{"cc": "VN", "c": "SGN", "fn": "Ho Chi Minh City (Saigon), Vietnam (SGN)", "id": 6539},
	{"cc": "HK", "c": "HKG", "fn": "Hong Kong, Hong Kong (HKG)", "id": 2812},
	{"c": "KUL", "cc": "MY", "fn": "Kuala Lumpur, Malaysia (KUL), All Airports", "id": 3829},
	{"cc": "PH", "c": "MNL", "fn": "Manila, Philippines (MNL)", "id": 4674},
	{"cc": "MY", "c": "PEN", "fn": "Penang, Malaysia (PEN)", "id": 5662},
	{"cc": "TH", "c": "HKT", "fn": "Phuket, Thailand (HKT)", "id": 2815},
	{"cc": "TW", "c": "TPE", "fn": "Taipei, Taiwan (TPE), All Airports", "id": 7327}
];
