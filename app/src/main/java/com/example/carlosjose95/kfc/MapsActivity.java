package com.example.carlosjose95.kfc;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if (status == ConnectionResult.SUCCESS) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        } else {
            Dialog dialog =  GooglePlayServicesUtil.getErrorDialog(status, (Activity) getApplicationContext(), 10);
            dialog.show();

        }
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

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        putMap(6.2706642, -75.5774593,
                "KFC CC Florida",
                "Tel: 3174373718",
                "Local 2171, Cl. 71 #65-150, Medellín, Antioquia");
        putMap(6.263937, -75.5948052,
                "KFC Laureles",
                "Tel: (4)6053030",
                "Cl. 39d ##73-86, Medellín, Antioquia");
        putMap(6.2496156, -75.5687831,
                "KFC Junin",
                "Tel: 3182704523",
                "Carrera 49 #50-42, Medellín, Antioquia");
        putMap(6.2292368, -75.57273,
                "KFC CC Premium Plaza",
                "Tel: 3126053030",
                "Cra 43A #30, Medellín, Antioquia");
        putMap(6.1965731, -75.5755949,
                "KFC CC Santa Fe",
                "Tel: (4)6053030",
                "KFC Santa Fe, 170, Local 4309, Entrada Al Poblado #7 Sur, Medellín, Antioquia");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mMap.setMyLocationEnabled(true);
    }

    private void putMap(double lat, double lng, String title, String phone, String dir) {
        LatLng sede = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions()
                .position(sede)
                .title(title)
                .snippet(phone)
                .snippet(dir)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mapmarker)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sede, 12));
    }
}
