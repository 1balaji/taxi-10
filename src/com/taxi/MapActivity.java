package com.taxi;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class MapActivity extends com.google.android.maps.MapActivity {

    private MapView mapView;
    private MyLocationOverlay myLocationOverlay;
    private LocationManager locationManager;
    private GPSLocationListener locationListener;
    private MapController mapController;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.map);
        findAllViewsById();

        myLocationOverlay = new MyLocationOverlay(this, mapView);
        mapView.getOverlays().add(myLocationOverlay);
        mapView.postInvalidate();
        
        mapController = mapView.getController();
        mapController.setZoom(16); 

        myLocationOverlay.runOnFirstFix(new Runnable() {

            public void run() {
                mapView.getController().animateTo(myLocationOverlay.getMyLocation());
            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new GPSLocationListener(mapView);

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0,
                0,
                locationListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myLocationOverlay.enableMyLocation();
        myLocationOverlay.enableCompass();
    }

    @Override
    protected void onPause() {
        super.onPause();
        myLocationOverlay.disableMyLocation();
        myLocationOverlay.disableCompass();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.runFinalizersOnExit(true);
        System.exit(RESULT_OK);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void findAllViewsById() {
        mapView = (MapView) findViewById(R.id.mapview);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
