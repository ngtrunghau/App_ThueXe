package com.example.app_thuexe.GiaoDien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app_thuexe.R;

import java.util.ArrayList;
import java.util.List;

public class ListView_TuyChon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__tuy_chon);
        List<String> listThucDon;
        ListView listviewThucDon;
        ArrayAdapter<String> adapter;
        listviewThucDon = findViewById(R.id.listview_thucdon);
        listThucDon = new ArrayList<String>();
        listThucDon.add("Tôi muốn thuê xe");
        listThucDon.add("Người quản lý");
        listThucDon.add("Giới thiệu");
        listThucDon.add("Thoát ứng dụng");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listThucDon);
        listviewThucDon.setAdapter(adapter);
        listviewThucDon.setOnItemClickListener(new ChonActivity());
    }
    private class ChonActivity implements
            AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> adp,
                                View v, int pos, long id) {
            if(pos == 3)
                finish();
            else {
                Intent intent = null;
                switch (pos) {
                    case 0:
                        intent = new Intent(ListView_TuyChon.this,MainActivity_GridView.class);
                        break;
                    case 1:
                        intent = new Intent(ListView_TuyChon.this, DangNhap_Admin.class);
                        break;
                    case 2:
                        intent = new Intent(ListView_TuyChon.this, GioiTheu.class);
                        break;

                }
                startActivity(intent);
            }
        }
    }
}
