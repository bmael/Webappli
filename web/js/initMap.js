/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var mapstraction = new mxn.Mapstraction('map','openlayers');

if(navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
        function(position){
            var infopos = "Position déterminée :\n";
            infopos += "Latitude : "+position.coords.latitude +"\n";
            infopos += "Longitude: "+position.coords.longitude+"\n";
            infopos += "Altitude : "+position.coords.altitude +"\n";
            document.getElementById("geolocation").innerHTML = infopos;
            var myPoint = new mxn.LatLonPoint(position.coords.latitude,position.coords.longitude);
            mapstraction.setCenterAndZoom(myPoint, 13);
            my_marker = new mxn.Marker(myPoint);
            //Temporary icon
            my_marker.setIcon('http://harrywood.co.uk/maps/examples/openlayers/img/marker.png');
            mapstraction.addMarker(my_marker);
        })
} else {
    document.getElementById("geolocation").innerHTML = 
        "Géolocalisation non supportée par votre navigateur";
    mapstraction.setCenterAndZoom(new mxn.LatLonPoint(47.2141,-1.5504), 13);

}
