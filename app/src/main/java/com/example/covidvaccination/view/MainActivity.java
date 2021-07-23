package com.example.covidvaccination.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidvaccination.R;
import com.example.covidvaccination.model.VaccineModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    String baseURL="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin";
    private EditText areaPINcode;
    private Button forwardbtn;
    ProgressBar holdOnProgress;
    private ArrayList<VaccineModel> vaccination_centers;
    private RecyclerView resultRecyclerView;
    String areaPIN,avlDate;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapViews();
        onClickSetup();
    }

    private void onClickSetup() {
        forwardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holdOnProgress.setVisibility(View.VISIBLE);
                DialogFragment dp = new PickDate();
                dp.show(getSupportFragmentManager(),"pick a date");
            }
        });


    }

    private void mapViews() {
        forwardbtn = findViewById(R.id.getResult);
        holdOnProgress = findViewById(R.id.progress_circular);
        areaPINcode = findViewById(R.id.enterPincode);
        resultRecyclerView = findViewById(R.id.recyclerView);
        resultRecyclerView.setHasFixedSize(true);
        vaccination_centers = new ArrayList<VaccineModel>();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar k = Calendar.getInstance();
        k.set(Calendar.YEAR,year);
        k.set(Calendar.MONTH,month);
        k.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        dateFormat.setTimeZone(k.getTimeZone());
        String d = dateFormat.format(k.getTime());
        setup(d);
    }

    private void setup(String d) {
        avlDate = d;
        fetchDataNow();

    }

    private void fetchDataNow() {
        vaccination_centers.clear();;
        areaPIN=areaPINcode.getText().toString();
        String url_api = baseURL + "pincode=" + areaPIN + "&date=" + avlDate;


    }
}