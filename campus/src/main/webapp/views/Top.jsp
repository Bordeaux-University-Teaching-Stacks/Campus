<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- CSS -->
	<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.fancybox.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/user.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/trombinoscope.css" />">
	<!-- JS -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.fancybox.js" />"></script>
    
	<title>Campus : par des étudiants, pour des étudiants</title>
</head>
<body>
	<div id="header-wrapper">
		<div id="header-center">
			<div id="header-logo">
				<img src="<c:url value="/resources/img/logo_beta.png" />" />
			</div>
			<div id="header-menu">
				<ul>
					<li><a href="<c:url value="/user/" />" class="shadow-text">Mon Profil</a></li>
					<li><a href="<c:url value="/trombinoscope/" />" class="shadow-text">Trombinoscope</a></li>
					<li><a href="<c:url value="/user/disconnect" />" class="shadow-text">Déconnexion</a></li>
				</ul>
			</div>
			