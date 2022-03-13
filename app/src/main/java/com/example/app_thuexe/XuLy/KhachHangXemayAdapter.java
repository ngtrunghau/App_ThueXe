package com.example.app_thuexe.XuLy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_thuexe.DuLieu.DbHelper;
import com.example.app_thuexe.DuLieu.KhachHangXemay;

import java.util.ArrayList;
import java.util.List;

public class KhachHangXemayAdapter {
    private DbHelper myDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { DbHelper.KHXEMAY_HOTTEN, DbHelper.KHXEMAY_NGAYSINH, DbHelper.KHXEMAY_CMND, DbHelper.KHXEMAY_DIACHI, DbHelper.KHXEMAY_GHICHU, DbHelper.KHXEMAY_DUNGTICH, DbHelper.KHXEMAY_NGAYNHAN, DbHelper.KHXEMAY_NGAYTRA};
    public KhachHangXemayAdapter(Context context){
        myDbHelper= new DbHelper(context);
        db= myDbHelper.getWritableDatabase();
    }

    public long insertKhachhangXemay(KhachHangXemay khachHangXemay){
        db=myDbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(DbHelper.KHXEMAY_HOTTEN, khachHangXemay.getHoten2());
        values.put(DbHelper.KHXEMAY_NGAYSINH, khachHangXemay.getNgaysinh2());
        values.put(DbHelper.KHXEMAY_CMND, khachHangXemay.getCmnd2());
        values.put(DbHelper.KHXEMAY_DIACHI, khachHangXemay.getDiachi2());
        values.put(DbHelper.KHXEMAY_GHICHU, khachHangXemay.getGhichu2());
        values.put(DbHelper.KHXEMAY_DUNGTICH, khachHangXemay.getDungtich2());
        values.put(DbHelper.KHXEMAY_NGAYNHAN, khachHangXemay.getNgaynhan2());
        values.put(DbHelper.KHXEMAY_NGAYTRA, khachHangXemay.getNgaytra2());
            return db.insert(DbHelper.TABLE_KHACHHANGXEMAY,null,values);
    }

    public int upDateKhachHangXemay( String hoten2, String ngaysinh2, int cmnd2, String diachi2, String ghichu2, String dungtich2, String ngaynhan2, String ngaytra2){
        ContentValues values=new ContentValues();
        values.put(DbHelper.KHXEMAY_HOTTEN, hoten2);
        values.put(DbHelper.KHXEMAY_NGAYSINH, ngaysinh2);
        values.put(DbHelper.KHXEMAY_CMND, cmnd2);
        values.put(DbHelper.KHXEMAY_DIACHI, diachi2);
        values.put(DbHelper.KHXEMAY_GHICHU, ghichu2);
        values.put(DbHelper.KHXEMAY_DUNGTICH, dungtich2);
        values.put(DbHelper.KHXEMAY_NGAYNHAN, ngaynhan2);
        values.put(DbHelper.KHXEMAY_NGAYTRA, ngaytra2);
            return db.update(DbHelper.TABLE_KHACHHANGXEMAY,values,DbHelper.KHXEMAY_CMND + " = " + cmnd2,null);
    }

    public int deleteKhachHangXemay(int cmnd2){
        return db.delete(DbHelper.TABLE_KHACHHANGXEMAY,DbHelper.KHXEMAY_CMND + " = " +cmnd2,null);
    }


    private KhachHangXemay cursorToKhachHang(Cursor cursor){
        KhachHangXemay values = new KhachHangXemay();
        values.setHoten2(cursor.getString(0));
        values.setNgaysinh2(cursor.getString(1));
        values.setCmnd2(cursor.getInt(2));
        values.setDiachi2(cursor.getString(3));
        values.setGhichu2(cursor.getString(4));
        values.setDungtich2(cursor.getString(5));
        values.setNgaynhan2(cursor.getString(6));
        values.setNgaytra2(cursor.getString(7));

        return values;
    }

    public List<KhachHangXemay> ListAllKhachHangXemay(){
        List<KhachHangXemay> lstKhachHangXemay = new ArrayList<KhachHangXemay>();
        Cursor cursor=db.query(DbHelper.TABLE_KHACHHANGXEMAY,allColumns,null,null,null,null,null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                KhachHangXemay  values= cursorToKhachHang(cursor);
                lstKhachHangXemay.add(values);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return  lstKhachHangXemay;
    }
    public  Boolean KiemTraKHXemay(int cmnd2){
        Boolean daco=false;
        List<KhachHangXemay> lstKhachHangXemay = ListAllKhachHangXemay();
        int i=0;
        while ((!daco) && (i<lstKhachHangXemay.size()))
            if (lstKhachHangXemay.get(i).getCmnd2()==cmnd2)
                daco= true;
            else i++;
        return daco;
    }

    public void close(){
        db.close();
        myDbHelper.close();
    }

}
