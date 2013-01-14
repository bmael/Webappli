<%-- 
    Document   : stat
    Created on : 17 oct. 2012, 11:10:41
    Author     : mael
--%>

<%@page import="org.jfree.chart.ChartUtilities"%>
<%@page import="utilities.statistics.Stats"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="perso" uri="/WEB-INF/tlds/statisticTags_library" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/global.css">
        <link rel="stylesheet" type="text/css" href="style/stats.css">
        <title>Statistique</title>
    </head>
    <body>
        <div id="body">
            <div id="stat_top">
                               
                <c:if test="${requestScope.date == null}">
                    <c:set var="now" value="<%= new Date()%>"/>                 
                </c:if>
                <c:if test="${requestScope.date != null}">
                    <c:set var="now" value="${requestScope.date}"/>                 
                </c:if>
                         
                <div id="left_arrow">
                    <a href="StatServlet?action=prev&date=<fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' />&itId=${param.itId}" id="leftbutton">
                            <img src="images/stats/leftArrow.png" alt="Previous"/>
                        </a>
                </div>
                <div id="date">
                    <fmt:formatDate type="date" dateStyle="long"  value='${now}' />
                 
                </div>
                <div id="right_arrow">
                    <a href="StatServlet?action=next&date=<fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' />&itId=${param.itId}" id="rightbutton">
                            <img src="images/stats/rightArrow.png" alt="Next"/>
                        </a>
                </div>
            </div>

            <div id="main_container">

                <div id="left_col">
                    
                    <div id="top_stat"></div>
                    <div id="statistique">
                        <c:forTokens items="${param.itId}" delims=";" var="id" >
                            <perso:createItinerary >
                                <jsp:attribute name="idpmv" >${id}<%-- Here use the variable to set the value. --%></jsp:attribute>
                                <jsp:attribute name="d1" ><fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' /></jsp:attribute>
                                <jsp:attribute name="d2" ><fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' /></jsp:attribute>
                                <jsp:attribute name="path" ><%= getServletContext().getRealPath("/") %>images/stats/charts</jsp:attribute>
                            </perso:createItinerary>
                            <img id="chartPNG" src="<%= getServletContext().getContextPath() %>/images/stats/charts/${id}_<fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' />_<fmt:formatDate pattern='yyyy-MM-dd'  value='${now}' />.png" alt="Statistiques"/> 
                        </c:forTokens>
                         
                        

                    </div>
                    <div id="bottom_stat"></div>
                </div>

                <div id="right_col">

                    <div id="top_box">
                        <h2>Filtres</h2>
                    </div>
                    <div id="filter">
                        <form action="" method="POST">
                            <input type="radio" name="Period" value="Jour"/> Jour <br/>
                            <input type="radio" name="Period" value="Semaine"/> Semaine
                        </form>
                    </div>
                    <div id="bottom_box"></div>
                </div>
            </div>
        </div>
        
    </body>
</html>
