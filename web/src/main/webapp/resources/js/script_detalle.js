console.log("hola")

function testMap(lugar) {

    mapboxgl.accessToken = 'pk.eyJ1IjoiZGFuaXRoZWNyZWF0b3IiLCJhIjoiY2tyMnZkbzd4MXJ1cDJ1bzdlNHpmdnNxYyJ9.789aY-Czm5oJfDpOtj-8eA';
    let map = new mapboxgl.Map({
        container: "mapDetalleLugar",
        style: 'mapbox://styles/mapbox/streets-v11'
    });

}