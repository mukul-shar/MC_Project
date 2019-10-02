package com.example.apointment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ApointmentBooking extends AppCompatActivity {

    private TextView date, from_time, to_time;
    private EditText appointment_comment;
    private Button appointment_submit;
    private Spinner faculty_id_spinner;

    final Calendar c = Calendar.getInstance();
    private int mYear, mMonth, mDay, mFromHour, mFromMinute, mToHour, mToMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointment_booking);
        //initializing layout widgets
        initializer();
        addFacultyIdOnSpinner();
        addListenerOnButton();
    }

    //initialize widgets
    private void initializer() {
        faculty_id_spinner = findViewById(R.id.faculty_id);
        date = findViewById(R.id.appointment_date_picker);
        from_time = findViewById(R.id.appointment_from_time);
        to_time = findViewById(R.id.appointment_to_time);
        appointment_comment = findViewById(R.id.appointment_comments);
        appointment_submit = findViewById(R.id.appointment_submit);
    }

    //generate date and time pickers
    public void pickersOnClick(View v) {
        if(v == date) {

            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            mYear = year;
                            mMonth = monthOfYear;
                            mDay = dayOfMonth;
                            date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        else if(v == from_time) {
            mFromHour= c.get(Calendar.HOUR_OF_DAY);
            mFromHour= c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            mFromHour = hourOfDay;
                            mFromMinute = minute;
                            from_time.setText(hourOfDay + ":" + minute);
                        }
                    }, mFromHour, mFromMinute, false);
            timePickerDialog.show();
        }
        else if(v == to_time) {
            mToHour= c.get(Calendar.HOUR_OF_DAY);
            mToMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            mToHour = hourOfDay;
                            mToMinute = minute;
                            to_time.setText(hourOfDay + ":" + minute);
                        }
                    }, mToHour, mToMinute, false);
            timePickerDialog.show();
        }
    }

    // add items into spinner dynamically
    public void addFacultyIdOnSpinner() {

        List<String> list = new ArrayList<>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        faculty_id_spinner.setAdapter(dataAdapter);
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        appointment_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String toast_string = "Room Id:" + faculty_id_spinner.getSelectedItem() +
                        "Date:" + date.getText() + "From Time:" + from_time.getText() +
                        "To Time:" + to_time.getText() + "Comments:" + appointment_comment.getText();
                Toast.makeText(ApointmentBooking.this, toast_string, Toast.LENGTH_LONG).show();
            }

        });
    }

}
