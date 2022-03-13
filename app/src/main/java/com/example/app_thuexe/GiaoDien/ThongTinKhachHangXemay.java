package com.example.app_thuexe.GiaoDien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_thuexe.DuLieu.KhachHangXemay;
import com.example.app_thuexe.R;
import com.example.app_thuexe.XuLy.KhachHangXemayAdapter;

import java.util.List;

public class ThongTinKhachHangXemay extends AppCompatActivity {

    KhachHangXemayAdapter khXemayAdapter;
    KhachHangXemay khXemay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang_xemay);
        khXemayAdapter=new KhachHangXemayAdapter(this);
      HienThiKhachHangXemay();
    }

    private void HienThiKhachHangXemay() {
        List<KhachHangXemay> dsKhachHangXemay = khXemayAdapter.ListAllKhachHangXemay();
        TextView txtThongtin =  findViewById((R.id.txt_thongtinXM));
        String strThongtin= " Thông tin khách hàng ";
        int n=dsKhachHangXemay.size();
        if (n>0){
            for (int i=0;i<n;i++){
                khXemay=dsKhachHangXemay.get(i);

                strThongtin += "\n\n Họ tên: " + khXemay.getHoten2();
                strThongtin += "\n Ngày sinh: " + khXemay.getNgaysinh2();
                strThongtin += "\n CMND: " + khXemay.getCmnd2();
                strThongtin += "\n Địa chỉ: " + khXemay.getDiachi2();
                strThongtin += "\n Ghi chú: " + khXemay.getGhichu2();
                strThongtin += "\n Số chổ: " + khXemay.getDungtich2();
                strThongtin += "\n Ngày nhận: " + khXemay.getNgaynhan2();
                strThongtin += "\n Ngày trả: " + khXemay.getNgaytra2();



            }
            txtThongtin.setText(strThongtin);
        }
        else txtThongtin.setText("Chưa có thông tin trong CSDL");
    }
    public void ThemKhachHangXemay(View view){
        khXemay= new KhachHangXemay("nguyentrung","11/11/2000",1111,"ca mau","Admin đã thêm","1000cc","11/11/2020","15/11/2020");
        if(khXemayAdapter.KiemTraKHXemay(khXemay.getCmnd2()))
            Toast.makeText(this,"Khach hang da ton tai", Toast.LENGTH_SHORT).show();
        else {
            khXemayAdapter.insertKhachhangXemay(khXemay);
            Toast.makeText(this, "Thong tin da duoc luu lai", Toast.LENGTH_SHORT).show();
        }
        HienThiKhachHangXemay();
    }
    public void chinhsuaKhachHangXemay(View view){
        khXemayAdapter.upDateKhachHangXemay("nguyentrung","11/11/2000",1111,"ca mau","Admin đã chỉnh sửa","1000cc","11/11/2020","15/11/2020");
        HienThiKhachHangXemay();
    }
    public void xoaKhachHangXemay(View view){
        EditText edt_CMND;
        int str_cmnd;
        edt_CMND = findViewById(R.id.edt_SoCMNDXM);
        str_cmnd= Integer.parseInt(edt_CMND.getText().toString());

        if(khXemayAdapter.KiemTraKHXemay(khXemay.getCmnd2()))
        {
            khXemayAdapter.deleteKhachHangXemay(str_cmnd);
            Toast.makeText(this,"Xóa khách hàng thành công", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(this, "Khách hàng không tồn tại", Toast.LENGTH_SHORT).show();
        }

        HienThiKhachHangXemay();
    }

}