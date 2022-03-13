package com.example.app_thuexe.XuLy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_thuexe.DuLieu.DbHelper;
import com.example.app_thuexe.DuLieu.KhachHangOto;

import java.util.ArrayList;
import java.util.List;

public class    KhachHangOtoAdapter {
    private DbHelper myDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = { DbHelper.KHOTO_HOTTEN,DbHelper.KHOTO_NGAYSINH,DbHelper.KHOTO_CMND,DbHelper.KHOTO_DIACHI,DbHelper.KHOTO_GHICHU,DbHelper.KHOTO_SOCHO,DbHelper.KHOTO_NGAYNHAN,DbHelper.KHOTO_NGAYTRA,DbHelper.KHOTO_TAIXE};
    public KhachHangOtoAdapter(Context context){
        myDbHelper= new DbHelper(context);
        db= myDbHelper.getWritableDatabase();
    }
    public long insertKhachHangOto(KhachHangOto khachhangoto){
        db=myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.KHOTO_HOTTEN, khachhangoto.getHoten());
        values.put(DbHelper.KHOTO_NGAYSINH, khachhangoto.getNgaysinh());
        values.put(DbHelper.KHOTO_CMND, khachhangoto.getCmnd());
        values.put(DbHelper.KHOTO_DIACHI, khachhangoto.getDiachi());
        values.put(DbHelper.KHOTO_GHICHU, khachhangoto.getGhichu());
        values.put(DbHelper.KHOTO_SOCHO, khachhangoto.getSocho());
        values.put(DbHelper.KHOTO_NGAYNHAN, khachhangoto.getNgaynhan());
        values.put(DbHelper.KHOTO_NGAYTRA, khachhangoto.getNgaytra());
        values.put(DbHelper.KHOTO_TAIXE, khachhangoto.getTaixe());
    return  db.insert(DbHelper.TABLE_KHACHHANGOTO,null,values);
    }
    public int  updateKhachHangOto( String hoten, String ngaysinh, int cmnd, String diachi, String ghichu,String socho, String ngaynhan, String ngaytra, String taixe){
        ContentValues values = new ContentValues();
        values.put(DbHelper.KHOTO_HOTTEN, hoten);
        values.put(DbHelper.KHOTO_NGAYSINH, ngaysinh);
        values.put(DbHelper.KHOTO_CMND, cmnd);
        values.put(DbHelper.KHOTO_DIACHI, diachi);
        values.put(DbHelper.KHOTO_GHICHU, ghichu);
        values.put(DbHelper.KHOTO_SOCHO, socho);
        values.put(DbHelper.KHOTO_NGAYNHAN, ngaynhan);
        values.put(DbHelper.KHOTO_NGAYTRA, ngaytra);
        values.put(DbHelper.KHOTO_TAIXE, taixe);
            return db.update(DbHelper.TABLE_KHACHHANGOTO,values,DbHelper.KHOTO_CMND + " = " + cmnd, null);
    }

    public int deleteKhachHangOto(int cmnd){
        return  db.delete(DbHelper.TABLE_KHACHHANGOTO,DbHelper.KHOTO_CMND + " = " + cmnd,null);
    }
    private KhachHangOto cursorToKhachHang(Cursor cursor){
        KhachHangOto values = new KhachHangOto();
        values.setHoten(cursor.getString(0));
        values.setNgaysinh(cursor.getString(1));
        values.setCmnd(cursor.getInt(2));
        values.setDiachi(cursor.getString(3));
        values.setGhichu(cursor.getString(4));
        values.setSocho(cursor.getString(5));
        values.setNgaynhan(cursor.getString(6));
        values.setNgaytra(cursor.getString(7));
        values.setTaixe(cursor.getString(8));
        return values;
    }

    public List<KhachHangOto> ListAllKhachHangOto(){
        List<KhachHangOto> lstKhachHangOto = new ArrayList<KhachHangOto>();
        Cursor cursor=db.query(DbHelper.TABLE_KHACHHANGOTO,allColumns,null,null,null,null,null);
        if (cursor.getCount()>0) {
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            KhachHangOto  values= cursorToKhachHang(cursor);
            lstKhachHangOto.add(values);
            cursor.moveToNext();
        }
        cursor.close();
        }
        return  lstKhachHangOto;
    }
     public  Boolean KiemTraKHOto(int cmnd){
        Boolean daco=false;
        List<KhachHangOto> lstKhachHangOto = ListAllKhachHangOto();
        int i=0;
        while ((!daco) && (i<lstKhachHangOto.size()))
            if (lstKhachHangOto.get(i).getCmnd()==cmnd)
                daco= true;
            else i++;
            return daco;
     }
     public void close(){
        db.close();
        myDbHelper.close();
     }
}
