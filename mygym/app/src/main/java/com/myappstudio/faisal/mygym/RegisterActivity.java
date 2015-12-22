package com.myappstudio.faisal.mygym;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private String _initialPinEntry;
    private String _confirmPinEntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextView emblem = (TextView) findViewById(R.id.registerEmblem);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Organo.ttf");
        final EditText pinValue = (EditText)findViewById(R.id.editPin);

        emblem.setTypeface(custom_font);
        emblem.setText("Please enter your new 4 digit pin code");

        final Button confirm = (Button) findViewById(R.id.confirmBtn);
        confirm.setText("Enter");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(confirm.getText().toString()){
                    case "Enter":
                        setInitialPinEntry(pinValue.getText().toString());
                        emblem.setText("Please confirm your 4 digit pin code");
                        confirm.setText("Confirm");
                        pinValue.setText("");
                        break;
                    case "Confirm":
                        setConfirmPinEntry(pinValue.getText().toString());
                        if(getInitialPinEntry().equals(getConfirmPinEntry())){
                            Intent i = new Intent(RegisterActivity.this, GymMainMenuActivity.class);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "The pin codes you entered did not match. Please try again", Toast.LENGTH_LONG).show();
                            emblem.setText("Please enter your new 4 digit pin code");
                            confirm.setText("Enter");
                            pinValue.setText("");
                        }
                        break;


                }
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.SplashScreenAccent));
        }
    }

    public String getInitialPinEntry(){
        return this._initialPinEntry;
    }

    public void setInitialPinEntry(String initialPinEntry){
        this._initialPinEntry = initialPinEntry;
    }

    public String getConfirmPinEntry(){
        return this._confirmPinEntry;
    }

    public void setConfirmPinEntry(String confirmPinEntry){
        this._confirmPinEntry = confirmPinEntry;
    }
}
