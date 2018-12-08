package com.example.carlosjose95.kfc;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mMap;
    int item;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);

        mapView = findViewById(R.id.map);
        try {
            mapView.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);

        Bundle args = getIntent().getExtras();

        if (args != null) {
            item = args.getInt("numero");
            flag = args.getBoolean("bandera");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        if (flag) {
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

        } else {

            switch (item) {

                case 0:
                    putMap(6.2706642, -75.5774593,
                            "KFC CC Florida",
                            "Tel: 3174373718",
                            "Local 2171, Cl. 71 #65-150, Medellín, Antioquia");

                    break;

                case 1:
                    putMap(6.263937, -75.5948052,
                            "KFC Laureles",
                            "Tel: (4)6053030",
                            "Cl. 39d ##73-86, Medellín, Antioquia");

                    break;

                case 2:
                    putMap(6.2496156, -75.5687831,
                            "KFC Junin",
                            "Tel: 3182704523",
                            "Carrera 49 #50-42, Medellín, Antioquia");

                    break;

                case 3:
                    putMap(6.2292368, -75.57273,
                            "KFC CC Premium Plaza",
                            "Tel: 3126053030",
                            "Cra 43A #30, Medellín, Antioquia");

                    break;

                default:
                    putMap(6.1965731, -75.5755949,
                            "KFC CC Santa Fe",
                            "Tel: (4)6053030",
                            "KFC Santa Fe, 170, Local 4309, Entrada Al Poblado #7 Sur, Medellín, Antioquia");

                    break;
            }

        }

        myLocation();

    }

    private void myLocation() {
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

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sede, 15));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }

    public void SateliteView(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void HibridoView(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
