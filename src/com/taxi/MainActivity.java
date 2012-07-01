package com.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.taxi.apiclient.Client;

public class MainActivity extends Activity
{
    private Button loginButton;
    private EditText usernameText;
    private EditText passwordText;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findAllViewsById();
        
        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Client apiClient = new Client();
                if (apiClient.login(usernameText.getText().toString(), passwordText.getText().toString())) {
                    Intent intent = new Intent(view.getContext(), MapActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
    
    public void findAllViewsById()
    {
        loginButton = (Button) findViewById(R.id.loginButton);
        usernameText = (EditText) findViewById(R.id.username_input);
        passwordText = (EditText) findViewById(R.id.password_input);
    }
}
