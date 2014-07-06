<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="Top.jsp" />

<div id="header-campus-and-name">
	<span>${ userSession.surname } <b>${ userSession.name }</b></span><br /> 
	Campus de <a href="<c:url value="campus"/>">${ userSession.campus.name }</a>
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
				<fmt:formatDate value="${ userSession.birth }" pattern="MM/dd/yyyy" />
			</div>
		</div>
	</div>
</div>
<div id="pagecontent-wrapper">
	<div id="pagecontent-center">

		<div class="search">
			<input type="text" class="findSomeone"
				placeholder="Vous cherchez quelqu'un ?" />
			<p class="numbers"></p>
		</div>

		<div class="spacer" style="height: 50px"></div>

		<ul id="Grid">
			<li class="mix user" data-name="maxime hersand">
				<div class="user-img">
					<img src="<c:url value="/resources/img/default.png" />" />
				</div>
				<div class="name">
					<p>Maxime Hersand</p>
				</div>
				<div class="study">
					<p>
						5<sup>ème</sup> année d'ingénierie informatique
					</p>
				</div>
			</li>
			<li class="mix user" data-name="georgina collier">
				<div class="user-img">
					<img src="<c:url value="/resources/img/default.png" />" />
				</div>
				<div class=" name">
					<p>Georgina Collier</p>
				</div>
				<div class="study">
					<p>DUT Services et Réseaux de Communication</p>
				</div>
			</li>
			<li class="mix user" data-name="meidi airouche">
				<div class="user-img">
					<img src="<c:url value="/resources/img/default.png" />" />
				</div>
				<div class=" name">
					<p>Meidi airouche</p>
				</div>
				<div class="study">
					<p>
						5<sup>éme</sup> année d'ingénierie informatique
					</p>
				</div>
			</li>
			<li class="mix user" data-name="antoine france">
				<div class="user-img">
					<img src="<c:url value="/resources/img/default.png" />" />
				</div>
				<div class=" name">
					<p>Antoine France</p>
				</div>
				<div class="study">
					<p>Licence pro ISTI</p>
				</div>
			</li>
			<li class="mix user" data-name="vivien poirier">
				<div class="user-img">
					<img src="<c:url value="/resources/img/default.png" />" />
				</div>
				<div class="name">
					<p>Vivien Poirier</p>
				</div>
				<div class="study">
					<p>
						5<sup>éme</sup> année d'ingénierie informatique
					</p>
				</div>
			</li>
		</ul>

	</div>
</div>

<jsp:include page="Bottom.jsp" />