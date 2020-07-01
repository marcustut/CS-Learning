//datepicker presets
var today = new Date();
var outboundDaysOffset = 21; // flights offsets
var inboundDaysOffset = 25;
var checkInDaysOffset = 7;   // hotels offsets
var checkOutDaysOffset = 9;

// sync two calendar dates
// -------------------------------------------------------------------------
function synchDates(dateBefore, dateAfter) {

	$(dateAfter).click(function(){
		$(dateAfter).datepicker('setDate',new Date($(dateBefore).datepicker('getDate')));
	});
	
}

// add date offsets
// -------------------------------------------------------------------------
function formatDatepicker(element_id, givenFormat, dateOffset) {
	
	var defaultDate = new Date();
	defaultDate.setDate(today.getDate()+dateOffset);
	$(element_id).val($.datepicker.formatDate(givenFormat,defaultDate));
}