<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
	<jsp:include page="Top.jsp"/>
	
	<div id="header-campus-and-name">
				<span>${ userSession.surname } <b>${ userSession.name }</b></span><br />
				Campus de  <a href="<c:url value="campus"/>">${ userSession.campus.name }</a>
			</div>
		</div>
	</div>
	<div id="blackbar-wrapper">
		<div id="blackbar-center">
			<a href="#fancy_uploadPhoto" class="fancybox">
				<span id="blackbar-photo" class="profile-photo">
					<img src="<c:url value="/resources/img/${userSession.photo}" />" width="225" height="315" />
				</span>
			</a>
			<div id="blackbar-profile">
				<div id="blackbar-title">Profil</div>
				<div id="blackbar-name">
					<b>Nom :</b> ${ fn:toUpperCase(userSession.name) }
				</div>
				<div id="blackbar-surname">
					<b>Prénom :</b> ${ userSession.surname }
				</div>
				<div id="blackbar-birth">
					<b>Date de naissance :</b>
					<fmt:formatDate value="${ userSession.birth }"
						pattern="MM/dd/yyyy" />
				</div>
			</div>
		</div>
	</div>
	<div id="pagecontent-wrapper">
		<div id="pagecontent-center">
		</div>
	</div>
		
	<!-- UPLOAD PROFILE PHOTO FANCYBOX -->
	<div class="invisible">
		<div id="fancy_uploadPhoto">
			<form action="" method="POST" enctype="multipart/form-data">
				<input type="file" name="profilePhoto" id="uploadPhoto"/>
				<input type="submit" name="uploadPhoto" id="uploadPhoto"/>
			</form>
		</div>
	</div>
	
	<jsp:include page="Bottom.jsp"/>
	
	<script type="text/javascript" src="<c:url value="/resources/js/user.js" />"></script>