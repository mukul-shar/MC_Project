package com.example.apointment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit( View view) {
        if (view == findViewById(R.id.button2)) {
            Intent intent = new Intent(MainActivity.this, RoomBooking.class);
            startActivity(intent);
        }
        else if (view == findViewById(R.id.button3)) {
            Intent intent = new Intent(MainActivity.this, ApointmentBooking.class);
            startActivity(intent);
        }
    }


}
