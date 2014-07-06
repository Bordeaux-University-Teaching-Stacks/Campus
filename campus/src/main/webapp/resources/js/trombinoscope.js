/**
 * Trombinoscope.js | This JS page goes with the JSP Trombinoscope.jsp
 * 
 * 	Author	|		Date	|	Version	|	Description	
 * 	MAIR	|	06/07/2014	|	1.0.0	|	Creation du fichier de gestion des évènements de la JSP Trombinoscope.jsp
 * 
 */

/**
 * Chargement de la page User.jsp
 */
$(function(){
   
    $(".findSomeone").keyup(function () {
	    var filter = $(this).val(), count = 0;
	    $("#Grid li").each(function () {
	    	var name = $(this).data("name");
	        if (name.search(new RegExp(filter, "i")) < 0) {
        		$(this).hide(300);
	        } else {
	        	$(this).show(300);
	            count++;
	        }
	    });
	});

});