var hasInterstitial = true;

$().ready(function(){
			
	$('body').addClass(search_forms[0]);
	$('#wg_wrap').addClass('size_300x250');

	$('input[name="wg_trip_type"]').click(function(){
    if($('input[name="wg_trip_type"]:checked').val() == 'false'){
      $('#wg_inbound_date').attr('disabled','disabled');
      $('.wg_inbound_container').css('visibility','hidden');
		}else{
      $('#wg_inbound_date').removeAttr('disabled');
      $('.wg_inbound_container').css('visibility','visible');
		}
	});

	// Navigation, add class to body on click
		
	$('.wg_navigation li a').click(function(){
		$('body').removeClass().addClass($(this).attr('id').split('_')[0]);
		return false;
	});

	$('.wg_destinations a').each(function(){
		var url = $(this).attr('href')+'&aff_aid='+$.trim(affiliateA)+'&aff_bid='+$.trim(affiliateB)+'&ts_code='+$.trim(tsCode);
		$(this).attr('href', url);
	});

	// Remove filters
	
	$('#research_search .remove_filters').click(function(){
		$('.wg_filters').find('input[type=radio]:checked').attr('checked', '');		
	});

	/* Autosuggest Feature
	 * ----------------------------------------------------------------------------------------------------
	 */

	if(typeof autocompleteInit == 'function')
	{
		// Clear location fields on change if there is no country code inside () ~ ninja
		
		$('#wg_origin').change(function(){
			if( ! match_location_code($('#wg_origin').val(), $('#wg_origin_code').attr('value')))
				$('#wg_origin_code').attr('value', '');
		});
		
		$('#wg_destination').change(function(){
			if( ! match_location_code($('#wg_destination').val(), $('#wg_destination_code').attr('value')))
				$('#wg_destination_code').attr('value', '');
		});		
		
		// $('#wg_origin_hotels').change(function(){
		// 	if( ! match_location_code($('#wg_origin_hotels').val(), $('#wg_location_code_hotels').attr('value')))
		// 		$('#wg_location_code_hotels').attr('value', '');
		// });		
		
		$('#wg_origin_activities').change(function(){
			if( ! match_location_code($('#wg_origin_activities').val(), $('#wg_location_code_activities').attr('value')))
				$('#wg_location_code_activities').attr('value', '');
		});		
		
		// Bind autocomplete feature to location fields

		var defaultFlightsAjaxUrl = 'http://www.wego.com/p/flights/locations/search';			
		var defaultHotelsAjaxUrl = 'http://www.wego.com/hotels/locations/search';			
		
		if($.browser.msie) add_indexOf_to_IE();		
		
		if (search_forms.indexOf('flights') >= 0)
		{
			if(typeof fcities != 'object') fcities = new Object;				  	
			autocompleteInit('#wg_origin', fcities, defaultFlightsAjaxUrl, '#wg_origin_code', 'flights', '', '130', 105, {max: 4});
			autocompleteInit('#wg_destination', fcities, defaultFlightsAjaxUrl,	'#wg_destination_code', 'flights', '', '130', 105, {max: 4});
		}

		if (search_forms.indexOf('hotels') >= 0)
		{
			if(typeof hcities != 'object') hcities = new Object;		
			autocompleteInit('#wg_origin_hotels', hcities, defaultHotelsAjaxUrl, '#wg_location_id_hotels', 'hotels', '#wg_location_code_hotels', '200', 146, {max: 8});
		}

		if (search_forms.indexOf('activities') >= 0)
		{
			if(typeof fcities != 'object') hcities = new Object;		
			autocompleteInit('#wg_origin_activities', fcities, defaultFlightsAjaxUrl, '#wg_location_code_activities', 'flights', '', '200', 146, {max: 7});
		}		
	}
	
	/* Datepicker Feature
	 * ----------------------------------------------------------------------------------------------------
	 */	
	
	if(typeof adjustDatepicker == 'function')
	{	
		// assign optional as default value
		
		// $('#wg_checkIn_date').val('optional').addClass('optional');
		// $('#wg_checkOut_date').val('optional').addClass('optional');

		// initialize datepicker on click
    if($('#flightsDomainPresent').val())
    {
      var givenFormat = 'dd/mm/yy';
    } else {
    //   $('#wg_outbound_date').val('optional').addClass('optional');
  		// $('#wg_inbound_date').val('optional').addClass('optional');
      var givenFormat = 'dd/mm/yy';
    }

		$('#wg_outbound_date').click(function(){
			
			if ( ! $(this).hasClass('hasDatepicker'))
			{
				$(this).datepicker({ numberOfMonths: 2, dateFormat: givenFormat, minDate: '0d', maxDate: '1y' });
				formatDatepicker('#wg_outbound_date', givenFormat, outboundDaysOffset);
				$(this).datepicker('show').removeClass('optional');
			}

			adjustDatepicker();	
		});	
		
		$('#wg_inbound_date').click(function(){

			if ( ! $(this).hasClass('hasDatepicker'))
			{
				$(this).datepicker({ numberOfMonths: 2, dateFormat: givenFormat, minDate: '0d', maxDate: '1y' });
				formatDatepicker('#wg_inbound_date', givenFormat, inboundDaysOffset);
				$(this).datepicker('show').removeClass('optional');
			}
			
			adjustDatepicker();
		});

		$('#wg_checkIn_date').click(function(){

			if ( ! $(this).hasClass('hasDatepicker'))
			{
				$(this).datepicker({ numberOfMonths: 2, dateFormat: 'dd/mm/yy', minDate: '0d', maxDate: '1y' });
				formatDatepicker('#wg_checkIn_date', givenFormat, checkInDaysOffset);
				$(this).datepicker('show').removeClass('optional');
			}
			
			adjustDatepicker();
		});
			
		$('#wg_checkOut_date').click(function(){
			
			if ( ! $(this).hasClass('hasDatepicker'))			
			{
				$(this).datepicker({ numberOfMonths: 2, dateFormat: 'dd/mm/yy', minDate: '0d', maxDate: '1y' });
				formatDatepicker('#wg_checkOut_date', givenFormat, checkOutDaysOffset);
				$(this).datepicker( 'show' ).removeClass('optional');
			}
			
			adjustDatepicker();
		});		
	}	

	/* Deals Ticker Feature
	 * ----------------------------------------------------------------------------------------------------
	 */

	if(typeof dealstickerInit == 'function')
	{	
		dealstickerInit();
		var deals_per_page = 6;	

		// Stop deals rotation on hover		
	  $("#wg_deals_list").hover(function(){ rotateDeals(false); }, function(){ rotateDeals(true); });	
	
		$('#wg_navigation li a').click(function()
		{
			if ($(this).parent().parent().parent().hasClass('wg_deals_nav')) rotateDeals(true);
			else rotateDeals(false);
			return false;
		});
	}
	
	/* Initialize Form Validation
	 * ----------------------------------------------------------------------------------------------------
	 */
	
	initialize_validation();
		
});

// Add indexOf to IE

function add_indexOf_to_IE()
{
	if (!Array.indexOf)
	{
    Array.prototype.indexOf = function(obj)
		{
	    for (var i=0; i<this.length; i++)
			{
      	if (this[i]==obj) return i;
      }
			return -1;
		};
	}	
}

// Form validation

function initialize_validation()
{
	var interstitial = '<div class="powered_by"><span>powered by: </span><a href="#">Wego.com</a></div>';

	/* Flights Validation
	 * ----------------------------------------------------------------------------------------------------
	 */	
	
	var dontSubmit = false;
	$('#flights_search_form').submit(function(){		

		$('.error').removeClass('error');
				
		var err_msg = [];
		
		// Check for empty fields
		
		if ($('#wg_origin').val().length == 0)
		{
//			err_msg.push('* Missing \"from\" field.');
			$('#wg_origin').addClass('error').focus().click();
			dontSubmit = true;
		}
		else if ($('#wg_origin_code').attr('value').length == 0)
		{
//			err_msg.push('* Unknown \"from\" location.');
			$('#wg_origin').addClass('error').focus().trigger(($.browser.opera ? 'keypress' : 'keydown') + '.autocomplete');
			dontSubmit = true;
		}

		if ($('#wg_destination').val().length == 0)
		{
//			err_msg.push('* Missing \"to\" field.');
			$('#wg_destination').addClass('error').focus().click();
			dontSubmit = true;
		}		
		else if ($('#wg_destination_code').attr('value').length == 0)
		{
//			err_msg.push('* Unknown \"to\" location.');
			$('#wg_destination').addClass('error').focus().trigger(($.browser.opera ? 'keypress' : 'keydown') + '.autocomplete');
			dontSubmit = true;
		}
		else if ($('#wg_origin_code').attr('value') == $('#wg_destination_code').attr('value'))
		{
			err_msg.push('* \"From\" and \"to\" locations are the same.');
			$('#wg_destination').addClass('error');			
		}		
		
		// date validation
		if($('#flightsDomainPresent').val())
    {
  		if($('#wg_outbound_date').val().length == 0)
  		{
  		  $('#wg_outbound_date').addClass('error');
  			dontSubmit = true;
  		}

      if($('input[name="wg_trip_type"]:checked').val() == 'true'){
        if ($('#wg_inbound_date').val().length == 0)
    		{
    		  $('#wg_inbound_date').addClass('error');
    			dontSubmit = true;
    		}
  		}
    }	else {
  		// if($('#wg_outbound_date').val() == "optional")
  		// 		$('#wg_outbound_date').val('');
		
  		// if($('#wg_inbound_date').val() == "optional")
  		// 		$('#wg_inbound_date').val('');

    //   var hasTripType = ($('li.triptype').length > 0);
  		// if(hasTripType && ($('li.triptype #wg_oneWay').attr('checked') == true))
  		// {
  		// 	$('#round_trip').val('false');

  		// 	if( ($('#wg_outbound_date').val().length == 0) )
  		// 	{
  		// 		err_msg.push('* Missing \"departure\" date.');
  		// 		$('#wg_inbound_date').addClass('error');
  		// 	}
  		// }
  		// else if(hasTripType && ($('li.triptype #wg_roundTrip').attr('checked') == true))
  		// {
  		// 	if( ($('#wg_outbound_date').val().length == 0) )
  		// 	{
  		// 		err_msg.push('* Missing \"departure\" date.');
  		// 		$('#wg_outbound_date').addClass('error');				
  		// 	}
  		// 	else if( ($('#wg_inbound_date').val().length == 0) )
  		// 	{
  		// 		err_msg.push('* Missing \"return\" date.');
  		// 		$('#wg_inbound_date').addClass('error');				
  		// 	}
  		// }
  		// else
  		// {
  		//   if( ($('#wg_outbound_date').val().length == 0) && ($('#wg_inbound_date').val().length > 0) )
    // 		{
    // 			err_msg.push('* Missing \"departure\" date.');
    // 			$('#wg_outbound_date').addClass('error');
    // 		}

    // 		if( ($('#wg_inbound_date').val().length == 0) && ($('#wg_outbound_date').val().length > 0) )
    // 				$('#round_trip').val('false');
  		// }

  		if($('#wg_outbound_date').val().length == 0)
  		{
  			err_msg.push('* Missing \"departure\" date.');
  			$('#wg_outbound_date').addClass('error');
  		}		

  		if(($('#wg_inbound_date').val().length == 0) && (!$('#wg_inbound_date').attr('disabled'))){ 
  			err_msg.push('* Missing \"return\" date.');
  			$('#wg_inbound_date').addClass('error');
  		}
  		
    }

		if (/travelandleisure/i.test(location.hostname)){
			var $outDate = $('#wg_outbound_date');
			var $inDate = $('#wg_inbound_date');
			var oVal = $outDate.val(), iVal = $inDate.val();
			// console.log(oVal, iVal);
			// console.log(oVal == '' || /optional/i.test(oVal) || iVal == '' || /optional/i.test(iVal));
			if (oVal == '' || /optional/i.test(oVal) || iVal == '' || /optional/i.test(iVal)) dontSubmit = true;
		}

		// end date validation

		// Check for date differences
		
		if ($('#wg_outbound_date').val().length > 0 || $('#wg_inbound_date').val().length > 0)
		{
			var dateRegex = /([0-9]{1,2})([^0-9])([0-9]{1,2})([^0-9])([0-9]{2,4})/;
			var outboundDate = $('#wg_outbound_date').val().replace(dateRegex,"$5$3$1");
			outboundDate = parseInt(outboundDate,10);
			var inboundDate = $('#wg_inbound_date').val().replace(dateRegex,"$5$3$1");
			inboundDate = parseInt(inboundDate,10);		
			
			if (outboundDate > inboundDate) {
				err_msg.push('* Departure must be earlier than arrival.');
				$('#wg_inbound_date').addClass('error');
			}
		}
		
		// Show errors	
		
		if (err_msg.length > 0)
		{
			alert(err_msg.join("\n"));			
			return false;	
		}
		else if (dontSubmit)
		{
			dontSubmit = false; // reset back
			return false;
		}
		else if( ($('#wg_outbound_date').val().length == 0) && ($('#wg_inbound_date').val().length == 0) )
		{
			set_cj_cookie();
			var cabin_data = '';
			
			switch($('#wg_cabin_class').val())
			{
				case 'Business':
				
					cabin_data = '/business-class-airfares.html';
					break;
				
				case 'First':
				
					cabin_data = '/first-class-airfares.html';
					break;
				
				case undefined:
				default:
			}			

			var domainsite = (countrysite($('#countrysite').val())) ? 'http://' + countrysite($('#countrysite').val()) : '';
			var ts_code = ($('#ts_code').val()) ? '#ts_code=' + $('#ts_code').val() : '';
			var airfares_param = domainsite + '/flights/airfares/' +
													 $('#wg_origin_code').attr('value') + '/' +
													 $('#wg_destination_code').attr('value') + cabin_data + ts_code;

			if ($('#wg_siteId').val() === 'journeymart') {
				airfares_param = 'http://flights.journeymart.com' + airfares_param;
			}

			window.open(airfares_param);	
			$('#wg_outbound_date').val('optional').addClass('optional');
			$('#wg_inbound_date').val('optional').addClass('optional');
			return false;			
		}		
		else
		{
			set_cj_cookie();
			$('#flights_search').find('.error').removeClass('error');
			if (hasInterstitial){ $('#flights_search .footer').after(interstitial); }
      // $('#flights_search #wg_adult, #flights_search #wg_children, #flights_search #wg_cabin_class').hide();

			$("div.powered_by").oneTime("5s", function(){
					$(this).remove();
          // $('#flights_search #wg_adult, #flights_search #wg_children, #flights_search #wg_cabin_class').show();
			});
		}
		
	});
	
	/* Hotels Validation
	 * ----------------------------------------------------------------------------------------------------
	 */
	
	$('#hotels_search_form').submit(function(){

		var err_msg = [];

		$('.error').removeClass('error');

		// Check for empty fields
		
		if ($('#wg_origin_hotels').val().length == 0)
		{
			err_msg.push('* Missing \"location\" field.');
			$('#wg_origin_hotels').addClass('error');
		}
		else if ($('#wg_location_id_hotels').attr('value').length == 0)
		{
			err_msg.push('* Unknown location.');
			$('#wg_origin_hotels').addClass('error');			
		}

		// date validation
		
		// if($('#wg_checkIn_date').val() == "optional")
		// 		$('#wg_checkIn_date').val('');
		
		// if($('#wg_checkOut_date').val() == "optional")
		// 		$('#wg_checkOut_date').val('');
		
		if($('#wg_checkIn_date').val().length == 0){
			err_msg.push('* Missing \"check-in\" date.');
			$('#wg_checkIn_date').addClass('error');
		}		
		
		if($('#wg_checkOut_date').val().length == 0){
				err_msg.push('* Missing \"check-out\" date.');
				$('#wg_checkOut_date').addClass('error');
		}		
		
		// Check for date differences				
		if ($('#wg_checkIn_date').val().length > 0 || $('#wg_checkOut_date').val().length > 0)
		{
			var dateRegex = /([0-9]{1,2})([^0-9])([0-9]{1,2})([^0-9])([0-9]{2,4})/;
			var outboundDate = $('#wg_checkIn_date').val().replace(dateRegex,"$5$3$1");
			outboundDate = parseInt(outboundDate,10);
			var inboundDate = $('#wg_checkOut_date').val().replace(dateRegex,"$5$3$1");
			inboundDate = parseInt(inboundDate,10);		
			
			if (outboundDate > inboundDate) {
				err_msg.push('* Check-in must be earlier than check-out.');
				$('#wg_checkOut_date').addClass('error');
			}
		}
		
		// Show errors	
		
		if(err_msg.length > 0)
		{
			alert(err_msg.join("\n"));			
			return false;			
		}
		else
		{
			set_cj_cookie();
			$('#hotels_search').find('.error').removeClass('error');			
			if (hasInterstitial){ $('#hotels_search .footer').after(interstitial); }
			$('#hotels_search #wg_rooms, #hotels_search #wg_guests, #hotels_search #wg_ratings').hide();

			$("div.powered_by").oneTime("5s", function(){
					$(this).remove();
					$('#hotels_search #wg_rooms, #hotels_search #wg_guests, #hotels_search #wg_ratings').show();				
			});
		}
		
	});	

	/* Activities Validation
	 * ----------------------------------------------------------------------------------------------------
	 */
	
	$('#activities_search_form').submit(function(){

		var err_msg = [];

		$('.error').removeClass('error');
		
		// Check for empty fields
		
		if ($('#wg_origin_activities').val().length == 0)
		{
			err_msg.push('* Missing \"location\" field.');
			$('#wg_origin_activities').addClass('error');
		}
		else if ($('#wg_location_code_activities').attr('value').length == 0)
		{
			err_msg.push('* Unknown location.');
			$('#wg_origin_activities').addClass('error');			
		}
						
		// Show errors	
		
		if (err_msg.length > 0)
		{
			alert(err_msg.join("\n"));			
			return false;			
		}
		else
		{
			$('#activities_search').find('.error').removeClass('error');			
			if (hasInterstitial){ $('#activities_search .footer').after(interstitial); }
			$("div.powered_by").oneTime("5s", function(){
					$(this).remove();					
			});
		}
		
	});
	
	/* Research Validation
	 * ----------------------------------------------------------------------------------------------------
	 */
	
	$('#research_search_form').submit(function(){

		var err_msg = [];

		$('.error').removeClass('error');
		
		// Check for empty fields
		
		if ($('#wg_origin_research').val().length == 0)
		{
			err_msg.push('* Missing search key.');
			$('#wg_origin_research').addClass('error');
		}
						
		// Show errors	
		
		if (err_msg.length > 0)
		{
			alert(err_msg.join("\n"));
			return false;			
		}
		else
		{
			$('#research_search').find('.error').removeClass('error');
			if (hasInterstitial){ $('#research_search .footer').after(interstitial); }
			$("div.powered_by").oneTime("5s", function(){
					$(this).remove();
			});
		}
		
	});	

}

// Checks if location field has country code inside () ~ ninja

function match_location_code(country, code)
{
	var items = country.split('(');
	for(var i=0; i<items.length; i++)
	{
		var key = items[i].split(')');		
		if(key[0] == code)
			return true;
	}
	return false;
}

// Datepicker positioning

function adjustDatepicker() 
{
	$('#ui-datepicker-div').css({
		top : '33px',
		left : '4px',			
		'margin-top' : 0,
		'margin-left' : 0
	});	
}