package com.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    private Button loginButton;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findAllViewsById();
        
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MapActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
    
    public void findAllViewsById()
    {
        loginButton = (Button) findViewById(R.id.loginButton);
    }
}
