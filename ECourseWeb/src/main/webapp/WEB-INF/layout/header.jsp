<%-- 
    Document   : header
    Created on : Aug 7, 2024, 3:25:12 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-sm" 
     style="background: radial-gradient(circle, #F7DBF0, #DFF4F3)">
    <div class="container-fluid">

        <div class="card" style="width:20px">
            <img style="width: 20px;" src="${pageContext.request.contextPath}/resources/images/A.jpg">
        </div>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">E-Course</a>
                </li>
                <s:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                    </li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/" />">Welcome <s:authentication property="principal.username"/>!</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout" />">Đăng xuất</a>
                    </li>
                </s:authorize>
            </ul>
        </div>
    </div>

</nav>