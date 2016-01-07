$(function() {

	var path = lastSegment(window.location.href);

	// set menu expansion on site load (= remember last selection)
	$("#sidebarMenu a[href='" + path + "']").each(function() {
		$(this).addClass('active-item');
		$(this).parents().each(function() {
			if ($(this).is('#sidebarMenu'))
				return;

			if ($(this).is('li'))
				$(this).addClass('active');

			if ($(this).attr("aria-expanded"))
				$(this).attr("aria-expanded", "true")

			$(this).children().each(function() {
				if ($(this).attr("aria-expanded"))
					$(this).attr("aria-expanded", "true")
			});
		});

	});

	// activate menu script (github.com/onokumus/metisMenu)
	$('#sidebarMenu').metisMenu({ doubleTapToGo: true });

	// set menu expansion on anchor navigation
	$(window).on('hashchange', function() {
		var path = lastSegment(window.location.href);
		$('#sidebarMenu a').removeClass('active-item');
		$("#sidebarMenu a[href='" + path + "']").addClass('active-item');

	});

});



function lastSegment(str) {
	var base = new String(str).substring(str.lastIndexOf('/') + 1);
	// if(base.lastIndexOf(".") != -1)
	// base = base.substring(0, base.lastIndexOf("."));
	return base;
}

$('table').addClass('table').addClass('table-condensed');

/*
 * window.onscroll = function() {myFunction()};
 *
 * function myFunction() { var x = $('#sidebarMenu').height(); var y =
 * screen.height; if($('#sidebarMenu').height() < screen.height){
 * $('#sidebar').addClass('affix'); //$('#sidebar').affix({ // offset: { // top:
 * $('.navbar navbar-default').height() // } //}); } else {
 * $('#sidebar').removeClass('affix'); } }
 */

// syntax coloring
$('pre > code')
		.filter(
				function() {
					return !($(this).attr('class') === undefined)
							&& !(($(this).attr('class')
									.contains('customHighlighted')));
				}).each(function() {
			$(this).addClass('prettyprint')
		})
prettyPrint();