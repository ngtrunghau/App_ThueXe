package com.example.app_thuexe.GiaoDien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.ImageAdapter;

public class MainActivity_gGridView_Admin extends AppCompatActivity {


    private Integer[] Images = {R.mipmap.xeoto, R.mipmap.xemay,R.mipmap.thoat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_g_grid_view__admin);
        GridView gdvMenu1 = findViewById(R.id.gdv_menu1);
        ImageAdapter adapter = new ImageAdapter(this,Images);
        gdvMenu1.setAdapter(adapter);
        gdvMenu1.setOnItemClickListener(new ChonCongViec());
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
                        intent = new Intent(MainActivity_gGridView_Admin.this,ThongTinKhachHangOto.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity_gGridView_Admin.this,ThongTinKhachHangXemay.class);
                        break;

                }
                startActivity(intent);
            }
        }
    }
}