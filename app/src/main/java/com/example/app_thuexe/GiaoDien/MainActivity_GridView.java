package com.example.app_thuexe.GiaoDien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.ImageAdapter;

public class MainActivity_GridView extends AppCompatActivity {

    private Integer[] Images = {R.mipmap.xeoto,R.mipmap.xemay,R.mipmap.thoat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__grid_view);
        GridView gdvMenu = findViewById(R.id.gdv_menu);
        ImageAdapter adapter = new ImageAdapter(this,Images);
        gdvMenu.setAdapter(adapter);
        gdvMenu.setOnItemClickListener(new ChonCongViec());
    }
    private class ChonCongViec implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 2)
                finish();
            else{
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity_GridView.this,ThueOTo.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity_GridView.this,ThueXeMay.class);
                        break;

                }
                startActivity(intent);
            }
        }
    }
}