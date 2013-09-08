<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" ignore="true" />
        </title>
        <link type="text/css" href="${pageContext.request.contextPath}/public/bootstrap/css/bootstrap.css" rel="stylesheet" /> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery.js"></script>
        <link type="text/css" href="${pageContext.request.contextPath}/public/css/style.css"  rel="stylesheet"/>                   
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/validate.js"></script>
        <link rel="stylesheet" href="http://sydneyapps.cloudservices.asia/auscommjobs/public/css/jquery.css" />
        <script src="http://sydneyapps.cloudservices.asia/auscommjobs/public/js/jquery-ui.js"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/hoverMenu.js"></script>
    </head>
    <body>
        <tiles:insertAttribute name="userLogin" />
        <tiles:insertAttribute name="menu" />
        <div class="divminheight">
        <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/public/bootstrap/js/bootstrap.js"></script>
    </body>
</html>