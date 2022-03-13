package com.example.app_thuexe.GiaoDien;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app_thuexe.DuLieu.KhachHangXemay;
import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.KhachHangXemayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThueXeMay extends AppCompatActivity {

    private Spinner spnCategory2;
    KhachHangXemayAdapter khXemayAdapter;
    KhachHangXemay khXemay;
    private String DUNGTICH;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thue_xe_may);

        khXemayAdapter=new KhachHangXemayAdapter(this);

        setContentView(R.layout.activity_thue_xe_may);
        spnCategory2 = (Spinner) findViewById(R.id.spnCategory2);

        List<String> list = new ArrayList<>();
        list.add("Dung tích 50cc (200.000đ/ ngày)");
        list.add("Dung tích 110cc (240.000đ/ngày)");
        list.add("Dung tích 150cc (300.000đ/ ngày)");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnCategory2.setAdapter(adapter);
        spnCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(ThueXeMay.this, spnCategory2.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                DUNGTICH= spnCategory2.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void HienThiThongBao(View view) {

        EditText edt_Hoten, edt_SoCMND, edtDiaChi, edtGhiChu, edt_NgaySinh, edt_startday, edt_endday;
        String strHoten, strSoCMND, strDiaChi,strNgaySinh, strGhiChu, strThongBao, strStartday, strEndday;
        edt_Hoten = findViewById(R.id.edt_Hoten2);
        edt_NgaySinh = findViewById(R.id.edt_NgaySinh2);
        edt_SoCMND = findViewById(R.id.edt_SoCMND2);
        edtDiaChi = findViewById(R.id.edt_diachi2);
        edtGhiChu = findViewById(R.id.edt_GhiChu2);
        edt_startday =findViewById(R.id.edt_startday2);
        edt_endday =findViewById(R.id.edt_endday2);


        strHoten = edt_Hoten.getText().toString().trim();
        if (strHoten.length() < 1) {
            edt_Hoten.requestFocus();
            edt_Hoten.selectAll();
            Toast.makeText(this, "Họ và tên không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        strNgaySinh = edt_NgaySinh.getText().toString().trim();
        if (strNgaySinh.length() < 1) {
            edt_NgaySinh.requestFocus();
            edt_NgaySinh.selectAll();
            Toast.makeText(this, "Ngày sinh không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        strStartday = edt_startday.getText().toString().trim();
        if (strStartday.length() < 1) {
            edt_startday.requestFocus();
            edt_startday.selectAll();
            Toast.makeText(this, "Ngày nhận xe không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        strEndday = edt_endday.getText().toString().trim();
        if (strEndday.length() < 1) {
            edt_endday.requestFocus();
            edt_endday.selectAll();
            Toast.makeText(this, "Ngày trả xe không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        strSoCMND =
                edt_SoCMND.getText().toString().trim();
        if (strSoCMND.length() < 1) {
            edt_SoCMND.requestFocus();
            edt_SoCMND.selectAll();
            Toast.makeText(this, "Số CMND/ CCCD không được rỗng", Toast.LENGTH_SHORT).show();
            return;
        }
        strDiaChi = edtDiaChi.getText().toString().trim();
        if (strDiaChi.length() < 1) {
            edtDiaChi.requestFocus();edtDiaChi.selectAll();
            Toast.makeText(this, "Địa chỉ không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }



        strGhiChu = edtGhiChu.getText().toString().trim();
        if (strGhiChu.length() < 1) {
            edtGhiChu.requestFocus();
            edtGhiChu.selectAll();
            Toast.makeText(this, "Ghi chú không được rỗng",
                    Toast.LENGTH_SHORT).show();
            return;
        }


        AlertDialog.Builder bdrThongbao =
                new AlertDialog.Builder(this);
        bdrThongbao.setTitle("Gửi thông báo");
        bdrThongbao.setIcon(R.mipmap.send);
        bdrThongbao.setPositiveButton("Đồng ý",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which){
                        Toast.makeText(ThueXeMay.this, "Đồng ý",
                                Toast.LENGTH_SHORT).show();
                    }
                });


        strThongBao = "Họ và tên: " + strHoten + "\n";
        strThongBao += "Ngày tháng năm sinh: " + strNgaySinh + "\n";
        strThongBao += "Số CMND/ CCCD: " + strSoCMND + "\n";
        strThongBao += "Địa chỉ: " + strDiaChi + "\n";
        strThongBao += "Ghi chú: " + strGhiChu+ "\n";
        strThongBao +="Ngày nhận xe: "+strStartday+"\n";
        strThongBao+="Ngày trả xe: "+strEndday+"\n";

        bdrThongbao.setMessage(strThongBao);
        bdrThongbao.create().show();
    }
    public void DongActivity(View view) {
        finish();
    }


    public void ThemKhachHangXemay(View view){

        EditText edt_Hoten, edt_SoCMND, edtDiaChi, edtGhiChu, edt_NgaySinh, edt_startday, edt_endday;
        String strHoten, strSoCMND, strDiaChi,strNgaySinh, strGhiChu, strThongBao, strStartday, strEndday;
        edt_Hoten = findViewById(R.id.edt_Hoten2);
        edt_NgaySinh = findViewById(R.id.edt_NgaySinh2);
        edt_SoCMND = findViewById(R.id.edt_SoCMND2);
        edtDiaChi = findViewById(R.id.edt_diachi2);
        edtGhiChu = findViewById(R.id.edt_GhiChu2);
        edt_startday =findViewById(R.id.edt_startday2);
        edt_endday =findViewById(R.id.edt_endday2);

        strHoten = edt_Hoten.getText().toString();
        strNgaySinh = edt_NgaySinh.getText().toString();

        int CMND= Integer.parseInt(edt_SoCMND.getText().toString());
        strDiaChi = edtDiaChi.getText().toString();
        strGhiChu = edtGhiChu.getText().toString();
        strStartday = edt_startday.getText().toString();
        strEndday = edt_endday.getText().toString();


        khXemay= new KhachHangXemay(strHoten,strNgaySinh,CMND,strDiaChi,strGhiChu,DUNGTICH,strStartday,strEndday);
        if(khXemayAdapter.KiemTraKHXemay(CMND))
            Toast.makeText(this,"Khach hang da ton tai", Toast.LENGTH_SHORT).show();
        else {
            khXemayAdapter.insertKhachhangXemay(khXemay);
            Toast.makeText(this, "Thong tin da duoc luu lai", Toast.LENGTH_SHORT).show();
        }
        edt_Hoten.getText().clear();
        edt_NgaySinh.getText().clear();
        edt_SoCMND.getText().clear();
        edtDiaChi.getText().clear();
        edtGhiChu.getText().clear();
        edt_startday.getText().clear();
        edt_endday.getText().clear();
       
    }



}