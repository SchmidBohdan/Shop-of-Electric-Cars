$(document).ready(function() {
     $("#carousel1").CloudCarousel(		
		{			
			xPos: 425,
			yPos: 120,
			buttonRight: $("#buttonLeft"),
			buttonLeft: $("#buttonRight"),
			autoRotate: 'right',
            autoRotateDelay: 3000,
            speed: 0.1,
            reflHeight: 60,
            reflOpacity: 0.5,
            yRadius: 100,
            mouseWheel: true
		}
	);



});


     