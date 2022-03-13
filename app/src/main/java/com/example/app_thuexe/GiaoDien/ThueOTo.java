package com.example.app_thuexe.GiaoDien;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app_thuexe.DuLieu.KhachHangOto;
import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.KhachHangOtoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ThueOTo extends AppCompatActivity {
    private Spinner spnCategory;
    KhachHangOtoAdapter khOtoAdapter;
    KhachHangOto khOto;
    private String SOCHO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thue_o_to);

        khOtoAdapter=new KhachHangOtoAdapter(this);


        setContentView(R.layout.activity_thue_o_to);
        spnCategory = (Spinner) findViewById(R.id.spnCategory);

        List<String> list = new ArrayList<>();
        list.add("Xe 4 chỗ (1.000.000đ/ ngày)");
        list.add("Xe 7 chỗ (1.300.000đ/ ngày)");
        list.add("Xe 16 chỗ (1.400.000đ/ ngày)");
        list.add("Xe 32 chỗ (1.700.000đ/ ngày)");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spnCategory.setAdapter(adapter);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(ThueOTo.this, spnCategory.getSelectedItem().toString(), Toast.LENGTH_SHORT);
                    SOCHO= spnCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void HienThiThongBao(View view) {

        EditText edt_Hoten, edt_SoCMND, edtDiaChi, edtGhiChu, edt_NgaySinh, edt_startday, edt_endday;
        String strHoten, strSoCMND, strDiaChi,strNgaySinh, strGhiChu, strThongBao, strStartday, strEndday;

        edt_Hoten = findViewById(R.id.edt_Hoten);
        edt_NgaySinh = findViewById(R.id.edt_NgaySinh);
        edt_SoCMND = findViewById(R.id.edt_SoCMND);
        edtDiaChi = findViewById(R.id.edt_diachi);
        edtGhiChu = findViewById(R.id.edt_GhiChu);
        edt_startday =findViewById(R.id.edt_startday);
        edt_endday =findViewById(R.id.edt_endday);


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
                        Toast.makeText(ThueOTo.this, "Đồng ý",
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
    public void ThemKhachHangOto(View view){

        EditText edt_Hoten, ed_SoCMND, ed_DiaChi, ed_GhiChu,ed_SoCho, ed_NgaySinh, ed_startday, ed_endday;
        String str_Hoten, str_DiaChi,str_NgaySinh, str_GhiChu, str_Startday, str_Endday, str_TX;
        int  str_SoCMND;
        edt_Hoten = findViewById(R.id.edt_Hoten);
        ed_NgaySinh = findViewById(R.id.edt_NgaySinh);
        ed_SoCMND = findViewById(R.id.edt_SoCMND);
        ed_DiaChi = findViewById(R.id.edt_diachi);
        ed_GhiChu = findViewById(R.id.edt_GhiChu);
        ed_startday =findViewById(R.id.edt_startday);
        ed_endday =findViewById(R.id.edt_endday);
        RadioButton ed_coTX = findViewById(R.id.radio_pirates);
        RadioButton ed_KcoTX = findViewById(R.id.radio_ninjas);

        str_Hoten = edt_Hoten.getText().toString();
        str_NgaySinh= ed_NgaySinh.getText().toString();
        str_SoCMND= Integer.parseInt(ed_SoCMND.getText().toString());
        str_DiaChi= ed_DiaChi.getText().toString();
        str_GhiChu= ed_GhiChu.getText().toString();
        str_Startday=ed_startday.getText().toString();
        str_Endday=ed_endday.getText().toString();

        if (ed_coTX.isChecked()) {
            str_TX = "Có thuê tài xế";
        } else {
            str_TX = "Không thuê tài xế";
        }


        khOto= new KhachHangOto(str_Hoten,str_NgaySinh,str_SoCMND,str_DiaChi,str_GhiChu,SOCHO,str_Startday,str_Endday,str_TX);

        if(khOtoAdapter.KiemTraKHOto(str_SoCMND))
            Toast.makeText(this,"Khách hàng đã tồn tại", Toast.LENGTH_SHORT).show();
        else {
            khOtoAdapter.insertKhachHangOto(khOto);
            Toast.makeText(this, "Thông tin đã được lưu lại", Toast.LENGTH_SHORT).show();
        }
        edt_Hoten.getText().clear();
        ed_NgaySinh.getText().clear();
        ed_SoCMND.getText().clear();
        ed_DiaChi.getText().clear();
        ed_GhiChu.getText().clear();
        ed_startday.getText().clear();
        ed_endday.getText().clear();

    }
}