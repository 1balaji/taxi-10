package com.taxi;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class GPSLocationListener implements LocationListener{
    private final MapView mapView;
    private final MapController mapController;
    
    public GPSLocationListener(MapView mapView) {
        this.mapView = mapView;
        this.mapController = mapView.getController();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            GeoPoint point = new GeoPoint(
                    (int) (location.getLatitude() * 1E6),
                    (int) (location.getLongitude() * 1E6));

            mapController.animateTo(point);
            mapController.setZoom(16);
            mapView.invalidate();
        }
    }

    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onProviderEnabled(String arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onProviderDisabled(String arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
