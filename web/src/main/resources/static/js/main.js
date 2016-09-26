$(function() {
	var state = true;
	$(".animated-color").hover(function() {
    	if(state) {
    		$(this).animate({
    			color: "#408fec"
    		}, 1000);
    	} else {
    		$(this).animate({
    			color: "white"
    		}, 1000);
    	}
    	state = !state;
    });
} );