package be.kuleuven.sd;

import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//import static io.restassured.RestAssured.*;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
//String countryName = get("http://ws.geonames.org/findNearbyPlaceName?lat={lat}&lng={long}",latlng.latitude , latlng.longitude).
//                      xmlPath().getString("geonames.geoname.countryName");
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
        @Override
        public void onMapClick(LatLng latlng){
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latlng);
            markerOptions.title(latlng.latitude+" : " +latlng.longitude);
            mMap.clear();
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,7));
            mMap.addMarker(markerOptions);
            //String countryName = get("http://ws.geonames.org/findNearbyPlaceName?lat={lat}&lng={long}",latlng.latitude , latlng.longitude).xmlPath().getString("geonames.geoname.countryName");
            mMap.addMarker(new MarkerOptions().position(latlng).title(
                    "wa is dees")).showInfoWindow();
        }
        }
        );
    }
}