<%-- 
    Document   : index
    Created on : 28 sept. 2012, 14:21:10
    Author     : mael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                
        <title>Stat' My Way</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/global.css">
        
        <!-- Add JQuery -->
        <script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/lib/jquery-1.8.2.min.js"></script>
        
        <!-- Add mousewheel plugin (this is optional) -->
        <script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/lib/jquery.mousewheel-3.0.6.pack.js"></script>

	<!-- Add fancyBox main JS and CSS files -->
	<script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/source/jquery.fancybox.js?v=2.1.2"></script>
	<link rel="stylesheet" type="text/css" href="js/jquery/fancyapps-fancyBox-902ef92/source/jquery.fancybox.css?v=2.1.2" media="screen" />

	<!-- Add Button helper (this is optional) -->
	<link rel="stylesheet" type="text/css" href="js/jquery/fancyapps-fancyBox-902ef92/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
	<script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>

	<!-- Add Thumbnail helper (this is optional) -->
	<link rel="stylesheet" type="text/css" href="js/jquery/fancyapps-fancyBox-902ef92/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />
	<script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

	<!-- Add Media helper (this is optional) -->
	<script type="text/javascript" src="js/jquery/fancyapps-fancyBox-902ef92/source/helpers/jquery.fancybox-media.js?v=1.0.4"></script>
        
        <script type="text/javascript">
                $(document).ready(function() {
			/*
			 *  Simple image gallery. Uses default settings
			 */
			$("#iframe").click(function() {
				$.fancybox.open({
					href : 'stat.jsp?itCpt='+
                                            document.getElementById("itCpt").value+
                                            '&itId='+
                                            document.getElementById("itId").value,
					type : 'iframe',
					padding : 5,
                                        width: 1000
				});
                        });

                });

         </script>

    </head>
    <body>
        <div id="body">
            <div id="top_banner"></div>
            <div id="banner">
                <h1>Stat' My Way</h1>
            </div>
            <div id="bottom_banner"></div>

            <div id="main_container">

                <div id="left_col">
                    <!-- Indications on the geolocation just for debug -->
                    <div id="geolocation"></div>

                    <!-- The map from OpenStreetMap -->
                    <div id="top_map"></div>
                    <div id="map_container">
                        <div id="map"></div>
                    </div>
                    <div id="bottom_map"></div>
                    <script src="http://openlayers.org/api/OpenLayers.js"></script>
                    <script type="text/javascript" charset="utf-8" src="js/mxn-2.0.18/mxn.js?(openlayers)"></script>
                    <script type="text/javascript" src="js/initMap.js"></script>
                    <script type="text/javascript">
                        <%
                        out.println(request.getAttribute("codeJs"));
                        out.println(request.getAttribute("codeJsParking"));
                        %>
                    </script>
                </div>

                <div id="right_col">
                    <!-- The filter menu -->
                    <div id="top_box">
                        <h2>Filtres</h2>
                    </div>
                    <div id="filter">
                        <script type="text/javascript" charset="utf-8" src="js/markersOperations.js"></script>
                        <form action="" method="POST">
                            <input type="checkbox" name="PMV" value="PMV" checked="checked" onClick="checkedBox(this)"/> PMV <br/>
                            <input type="checkbox" name="Parking" value="Parking" checked="checked" onClick="checkedBox(this)"/> Parking
                        </form>
                    </div>
                    <div id="bottom_box"></div>

                    <!-- The information div (where we will display pmv content) -->
                    <div id="top_info_stat_box">
                        <h2>Informations&nbsp;&nbsp;<a id="iframe" rel="nofollow" href="javascript:;">Statistiques</a></h2>

                    </div>
                    <div id="info">
                        <p>
                            Aucun PMV séléctionné 
                        </p>
                    </div>
                    <div id="bottom_box"></div>
                </div>

            </div>
                    <div class="clear"></div>
            <div id="footer">
                Generated by <div id="logo"></div><span class="logofont">Kiss Fairy Corporation</span> 
            </div>
        </div>
    </body>
</html>
