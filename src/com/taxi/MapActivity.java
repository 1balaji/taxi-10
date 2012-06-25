/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxi;

import android.app.Activity;
import android.os.Bundle;


/**
 *
 * @author Dan
 */
public class MapActivity extends com.google.android.maps.MapActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.map);      
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}
