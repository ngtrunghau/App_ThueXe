package com.example.app_thuexe.GiaoDien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_thuexe.DuLieu.KhachHangOto;
import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.KhachHangOtoAdapter;

import java.util.List;

public class ThongTinKhachHangOto extends AppCompatActivity {
    KhachHangOtoAdapter khOtoAdapter;
    KhachHangOto khOto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang_oto);
        khOtoAdapter=new KhachHangOtoAdapter(this);
        HienThiKhachHangOto();
    }

    private void HienThiKhachHangOto() {
        List<KhachHangOto> dsKhachHangOto = khOtoAdapter.ListAllKhachHangOto();
        TextView txtThongtin =  findViewById((R.id.txt_thongtin));
        String strThongtin= " Thông tin khách hàng ";
        int n=dsKhachHangOto.size();
        if (n>0){
            for (int i=0;i<n;i++){
                khOto=dsKhachHangOto.get(i);

                strThongtin += "\n\n Họ tên: " + khOto.getHoten();
                strThongtin += "\n Ngày sinh: " + khOto.getNgaysinh();
                strThongtin += "\n CMND: " + khOto.getCmnd();
                strThongtin += "\n Địa chỉ: " + khOto.getDiachi();
                strThongtin += "\n Ghi chú: " + khOto.getGhichu();
                strThongtin += "\n Số chổ: " + khOto.getSocho();
                strThongtin += "\n Ngày nhận: " + khOto.getNgaynhan();
                strThongtin += "\n Ngày trả: " + khOto.getNgaytra();
                strThongtin += "\n Tài xế: " + khOto.getTaixe();


            }
            txtThongtin.setText(strThongtin);
        }
        else txtThongtin.setText("Chưa có thông tin trong CSDL");
    }
    public void ThemKhachHangOto(View view){
        khOto= new KhachHangOto("Nguyen Trung Hau","11/11/2000",1234,"ca mau","Đây là thông tin Admin thêm"," xe 4 chổ","11/11/2020","15/11/2020","có tài xế");
        if(khOtoAdapter.KiemTraKHOto(khOto.getCmnd()))
            Toast.makeText(this,"Khách hàng đã tồn tại", Toast.LENGTH_SHORT).show();
        else {
            khOtoAdapter.insertKhachHangOto(khOto);
            Toast.makeText(this, "Thông tin đã được lưu lại", Toast.LENGTH_SHORT).show();
        }
            HienThiKhachHangOto();
    }
    public void chinhsuaKhachHangOto(View view){
        khOtoAdapter.updateKhachHangOto("Nguyen Trung Hau","11/11/2000",1234,"ca mau","Đây là thông tin Admin chỉnh sửa","xe 4 cho","11/11/2020","15/11/2020","không tài xế");
        HienThiKhachHangOto();
    }
    public void xoaKhachHangOto(View view){
        EditText edt_CMND;
        int str_cmnd;
        edt_CMND = findViewById(R.id.edt_SoCMND);
        str_cmnd= Integer.parseInt(edt_CMND.getText().toString());

        if(khOtoAdapter.KiemTraKHOto(str_cmnd))
        {
            khOtoAdapter.deleteKhachHangOto(str_cmnd);
            Toast.makeText(this,"Xóa khách hàng thành công", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(this, "Khách hàng không tồn tại", Toast.LENGTH_SHORT).show();
        }

        HienThiKhachHangOto();
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        khOtoAdapter.close();
    }
}