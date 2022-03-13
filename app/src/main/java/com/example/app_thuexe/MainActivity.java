package com.example.app_thuexe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.app_thuexe.GiaoDien.DangNhap_Admin;
import com.example.app_thuexe.GiaoDien.ListView_TuyChon;
import com.example.app_thuexe.GiaoDien.ThueOTo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "Vòng đời Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ThucThiActivity(View view){
        Intent intent = new Intent(this, ListView_TuyChon.class);
        startActivity(intent);
    }


}