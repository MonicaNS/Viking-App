package com.example.dvcmap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
     * we just add a marker near DVC, Pleasant Hill.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in DVC and move the camera

        LatLng DVC = new LatLng(37.9688, -122.0710); //Changed the latitude and longitude to CA, DVC (previously
        mMap.addMarker(new MarkerOptions().position(DVC).title("Marker in DVC, Pleasant Hill"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DVC));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17)); //Added this line to focus on DVC map only instead of the world map


        //  mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 500));


        //   public static CameraUpdate newLatLngBounds ( bounds, 500, 500, 2000);

        //  mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, getResources().getDimensionPixelSize(R.dimen.mMap_camera_padding_new_bounds)));

//37.976243, -122.073407
//37.965902, -122.071549

        LatLng NorthEastBound = new LatLng(37.971363, -122.066986);
        LatLng SouthWestBound = new LatLng(37.966364, -122.074532);


        LatLngBounds DVCBounds = new LatLngBounds(  SouthWestBound, NorthEastBound); //Setting up boundaries



         mMap.setLatLngBoundsForCameraTarget(DVCBounds);



        // https://gis.stackexchange.com/questions/49805/can-i-view-a-google-maps-map-by-bounding-latitude-and-longitude-coordinates
//        LatLngBounds DVCBounds = new LatLngBounds( new LatLng(37.965902, 122.071549 ),  new LatLng(37.976243, -122.073407)); //Setting up boundaries


        //    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DVCBounds.getCenter(), 50));
        // and works with this    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(DVCBounds, 50, 50, 2));


        /**
         * https://stackoverflow.com/questions/40866431/how-to-use-latlngbounds?rq=1
         * LatLng pickupLatLng = new LatLng(37.976186,122.072527);
         *         LatLng destinationLatLng = new LatLng(37.965831,122.071647);
         *         LatLngBounds bounds = LatLngBounds.builder().include(pickupLatLng).include(destinationLatLng).build();
         *
         *         mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 500));
         */
    }
  /***
//https://code.tutsplus.com/tutorials/getting-started-with-google-maps-for-android-basics--cms-24635
   abstract class MapFragment extends SupportMapFragment implements GoogleApiClient.ConnectionCallbacks,
            GoogleApiClient.OnConnectionFailedListener,
            GoogleMap.OnInfoWindowClickListener,
            GoogleMap.OnMapLongClickListener,
            GoogleMap.OnMapClickListener,
            GoogleMap.OnMarkerClickListener {
        @Override
        public void onMapClick(LatLng latLng) {

            MarkerOptions options = new MarkerOptions().position(latLng);
            options.title(getAddressFromLatLng(latLng));

            options.icon(BitmapDescriptorFactory.defaultMarker());
            getMap().addMarker(options);

        }
    }
   ***/
}
//may be useful for padding https://en.proft.me/2016/10/6/getting-started-google-maps-android/