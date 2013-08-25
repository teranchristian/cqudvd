<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" ignore="true" />
        </title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
        <link type="text/css" href="${pageContext.request.contextPath}/public/bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/public/css/style.css"  rel="stylesheet"/>    
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/validate.js"></script>
        <link href="${pageContext.request.contextPath}/css/style_inner.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <tiles:insertAttribute name="userLogin" />
        <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/bootstrap/js/bootstrap.js"></script>
    </body>
</html>