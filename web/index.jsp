<%-- 
    Document   : index
    Created on : 28 sept. 2012, 14:21:10
    Author     : mael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/global.css">
        <title>Our Web Application</title>
    </head>
    <body>
        <div id="top_banner"></div>
        <div id="banner">
            <h1>Our Web Application</h1>
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
            </div>
            
            <div id="right_col">
                <!-- The filter menu -->
                <div id="top_box"></div>
                <div id="filter">
                    <h2>Filtres</h2>
                    <form action="" method="POST">
                        <input type="checkbox" name="PMV" value="PMV"/> PMV <br/>
                        <input type="checkbox" name="Parking" value="Parking"/> Parking
                    </form>
                </div>
                <div id="bottom_box"></div>

                <!-- The information div (where we will display pmv content) -->
                <div id="top_box"></div>
                <div id="info">
                    <h2>Informations</h2>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Aliquam scelerisque, metus at pretium iaculis, odio odio 
                        cursus diam, id mollis ligula mi et elit. Vivamus iaculis 
                        molestie turpis sed scelerisque. Donec ligula lectus, luctus
                        et laoreet nec, vestibulum ac enim. Maecenas luctus faucibus
                        ipsum, ac fermentum augue bibendum sed. In iaculis, nulla et
                        luctus iaculis, felis mi convallis erat, sit. 
                    </p>
                </div>
                <div id="bottom_box"></div>
            </div>
            
        </div>
    </body>
</html>
