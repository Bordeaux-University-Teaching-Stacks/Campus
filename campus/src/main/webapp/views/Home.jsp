<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Campus | Par des étudiants, pour des étudiants</title>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.fancybox.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.dateinput.css" />">
    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.fancybox.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.dateinput.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.scrollit.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/index.js" />"></script>
</head>
<body>
<div id="page-wrapper">
    <div id="head-wrapper" data-scroll-index="0">
        <div id="head-login-wrapper">
            <div id="head-login-main-wrapper">
                <div id="head_prom">
                    <img src="<c:url value="/resources/img/prom_rentree.png"/>">
                </div>
                <div id="head_logo">
                    <img src="<c:url value="/resources/img/logo_beta.png"/>">
                </div>
                <div id="head_login">
                    <form:form action="/user/login" method="post">
                        <div id="head_login_account">
                            <input type="text" name="email" id="email"
                                   class="connexion_input" value="Email"/>
                        </div>
                        <div id="head_login_password">
                            <input type="password" name="password" id="password"
                                   class="connexion_input" value="Mot de passe"/>
                        </div>
                        <div id="head_login_button">
                            <input type="submit" name="login" id="login" value="Connexion"
                                   class="button"/>
                        </div>
                        <div id="head_info">
                            <!-- <input type="checkbox" id="remember_me" name="remember_me" value="rememberme" /> 
                            <label for="remember_me">Se souvenir de moi</label> | <a href="#"> J'ai oublié mon mot de passe</a><br/>-->
                            <br/>${error}
                        </div>
                    </form:form>
                </div>
                <div id="head_speech">
                    <h2 class="shadow-text">Bienvenue sur Campus</h2>

                    <p class="shadow-text">Ne perdez pas un instant et venez
                        découvrir l'outil indispensable de votre rentrée. Communiquer,
                        partager, s'amuser, sortir... Campus vous offre une opportunité
                        unique d'interagir avec les étudiants de votre ville.</p>
                </div>
                <div id="head_subscribe">
                    <a href="#fancy_subscribe" class="button_big fancybox">Créer
                        mon compte maintenant</a>
                </div>
            </div>
        </div>
    </div>
    <div id="navbar" class="invisible">
    	<div id="menu">
    		<a data-scroll-nav="0"><span id="menu_0" class="menu_home"><img src="<c:url value="/resources/img/logo_beta_hat.png"/>" width="50" height="30" title="Haut de la page"></span></a>
    		<a data-scroll-nav="1"><span id="menu_1" class="menu">Diffuser</span></a>
    		<div id="prom_separator_1" class="prom_separator"></div>
    		<a data-scroll-nav="2"><span id="menu_2" class="menu">Etudier</span></a>
    		<div id="prom_separator_2" class="prom_separator"></div>
    		<a data-scroll-nav="3"><span id="menu_3" class="menu">S'amuser</span></a>
    		<div id="prom_separator_3" class="prom_separator"></div>
    		<a data-scroll-nav="4"><span id="menu_4" class="menu">Echanger</span></a>
    	</div>
    </div>
    <div id="main-wrapper">
        <div id="main-title">
            <h3>Utiliser Campus, c'est facile !</h3>
            <hr/>
        </div>
        <div id="main-proms">
            <a data-scroll-nav="1"><span id="main-prom1" class="prom">Diffuser</span></a>   
            <a data-scroll-nav="2"><span id="main-prom2" class="prom">Etudier</span></a>
            <a data-scroll-nav="3"><span id="main-prom3" class="prom">S'amuser</span></a>
            <a data-scroll-nav="4"><span id="main-prom4" class="prom">Echanger</span></a>
        </div>
    </div>
    <div id="main-proms-content_1" data-scroll-index="1" class="main-proms-content main-prom-page-white">
    	<div id="prom_1" class="prom_wrapper">
	    	<h1>Publiez vos envies</h1>
	    	<h2>Campus est plus qu'un réseau social pour étudiant. Diffusez votre CV, des vidéos et clichés de vos projets... afin d'inciter ceux qui 
	    	vous entourent à travailler avec vous et qui sait, peut-être décrocher un stage, une alternance ou même un emploi qui vous corresponde.</h2>
    	 </div>
    </div>
    <div id="main-proms-content_2" data-scroll-index="2" class="main-proms-content main-prom-page-grey">
    	<div id="prom_2" class="prom_wrapper_white">
	    	<h1>Quand étudier devient amusant</h1>
	    	<h2>C'est parce que nous avons compris qu'étudier n'est pas tous les jours facile que nous souhaitons vous aider à 
	    	transformer votre routine de travail en un moment agréable. Venez essayer nos outils !</h2>
    	 </div>
    </div>
    <div id="main-proms-content_3" data-scroll-index="3" class="main-proms-content main-prom-page-white">
    	<div id="prom_3" class="prom_wrapper">
	    	<h1>Pensez à décompresser !</h1>
	    	<h2>Certains cursus peuvent imposer une très grande pression quant à la réussite de nos étudiants. Il est donc important qu'ils prennent 
	    	le temps de se divertir. Organisez des soirées, profitez des partenariats que nous avons dans vos régions pour des tarifs plus avantageux !</h2>
    	 </div>
    </div>
    <div id="main-proms-content_4" data-scroll-index="4" class="main-proms-content main-prom-page-grey">
    	<div id="prom_4" class="prom_wrapper_white">
	    	<h1>Partez à la rencontre de votre réussite</h1>
	    	<h2>Campus met à votre disposition des outils permettant d'adapter votre communication à votre interlocuteur. Echanger avec vos camarades, 
	    	obtenir des informations sur les entreprises de votre secteur ou encore travailler à plusieurs en ligne devient un jeu d'enfant.</h2>
    	 </div>
    </div>
    <!-- <div id="footer-wrapper">
        <div id="footer-content">
            <hr/>
            <p>
                © Campus 2013 - Tous droits réservés - <a
                    href="mailto:hotline@thecampus.fr?subject=[Campus\Support] Saisissez le sujet de votre demande de support ici">
                Support
            </a> |
                <a href="mailto:hotline@thecampus.fr?subject=[Campus\Contact] Saisissez le sujet de votre demande de contact ici">
                    Contact
                </a>
            </p>
        </div>
    </div>-->
</div>

<!-- FANCYBOXES -->

<!-- SUBSCRIBE FANCYBOX -->
<div class="invisible">
    <div id="fancy_subscribe">
    	<h2 class=""><img src="<c:url value="/resources/img/logo_beta.png"/>" width="200" height="45"></h2>
    	<div id="fancy_subscribe_normal_mode">
    		${ warning }
	        <div id="subscribe">
	            <form:form action="/user/subscribe" commandName="userForm" method="POST">
	                <label for="name">Nom de famille : </label>
	                <form:input path="name"/>
	                <form:errors path="name" cssclass="error"/><br/>
	                
	                <label for="surname">Prénom : </label>
	                <form:input path="surname"/>
	                <form:errors path="surname" cssclass="error"/><br/>

					<label for="birth">Date de naissance : </label>
	                <form:input path="birth" cssclass="date"/>
	                <form:errors path="birth" cssclass="error"/><br/>
	                
	                <label for="sex">Vous êtes : </label>
	                <form:radiobutton path="sex" value="M" checked="checked"/>Un homme
	                <form:radiobutton path="sex" value="F"/>Une femme
	                <form:errors path="sex" cssclass="error"/><br/>
	                
					<label for="email">Email : </label>
	                <form:input path="email"/>
	                <form:errors path="email" cssclass="error"/><br/>
					
					<label for="password">Mot de passe : </label>
	                <form:password path="password"/>
	                <form:errors path="password" cssclass="error"/><br/>

					<label for="campusOptions">Campus : </label>
    				<form:select path="campus.id" id="campusOptions">
    					<c:forEach items="${campus}" var="campus">
	                    	<form:option value="${campus.id}">${campus.name}</form:option>
	                    </c:forEach>
    				</form:select>
    				<form:errors path="campus" cssclass="error"></form:errors><br/>
 
 					<label for="newsletter">Je souhaite recevoir la newsletter </label>
    				<form:checkbox path="newsletter"></form:checkbox>
    				<form:errors path="newsletter" cssclass="error"></form:errors>
    				
    				<label for="legals">J'accepte les <a href="#">conditions générales d'utilisation</a> </label>
    				<form:checkbox path="legals"></form:checkbox>
    				<form:errors path="legals" cssclass="error"></form:errors>

	                <input type="submit" name="subscribe" id="subscribe" value="S'inscrire" class="button"/>
	            </form:form>
	        </div>
        </div>
        <!-- ><div id="fancy_subscribe_socialnetwork">
        	<div id="fb-root"></div>
        	<script type="text/javascript" src="<c:url value="/resources/js/javascript.facebook.login.js" />"></script>
        	<a href="#" onclick="fb_login();"><img src="<c:url value="/resources/img/facebooklogin.png"/>" border="0" alt=""></a><br/>
        </div>-->
    </div>
</div>
</body>
</html>


