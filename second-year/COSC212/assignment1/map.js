let Map = (function () {
    let pub = {};

    /*gives an alert saying where on the map you clicked*/
    function onMapClick(e) {
        alert('You clicked the map at ' + e.latlng);
    }

    /*displays map and adds POI.geoJSON features to the map, also adds office, parks and tracks markers*/
    pub.setup = function () {
        map = L.map('map').setView([-45.8743, 170.5035], 15);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
            {
                maxZoom: 18,
                attribution: 'Map data &copy; ' +
                    '<a href="http://www.openstreetmap.org/copyright">' +
                    'OpenStreetMap contributors</a> CC-BY-SA'
            }).addTo(map);

        $.getJSON("json/POI.geojson", function (data) {
            for (let i = 0; i < data.features.length; i++) {
                let marker = L.geoJSON(data.features[i]).addTo(map).bindPopup(data.features[i].properties.name);
            }
        });

        office = L.marker([-45.8743, 170.5035]).addTo(map);
        office.bindPopup("<p>Company Office</p>");
        walk1 = L.marker([-45.859854, 170.53306]).addTo(map);
        walk1.bindPopup("<p>Walking Track</p>");
        walk2 = L.marker([-45.885662, 170.491745]).addTo(map);
        walk2.bindPopup("<p>Walking Track</p>");
        walk3 = L.marker([-45.871032, 170.52966]).addTo(map);
        walk3.bindPopup("<p>Walking Track</p>");
        park1 = L.marker([-45.865274, 170.522024]).addTo(map);
        park1.bindPopup("<p>Park</p>");
        park2 = L.marker([-45.862255, 170.512826]).addTo(map);
        park2.bindPopup("<p>Park</p>");
        park3 = L.marker([-45.878121, 170.4903]).addTo(map);
        park3.bindPopup("<p>Park</p>");

        map.on('click', onMapClick);
    };

    return pub;
}());

$(document).ready(Map.setup);