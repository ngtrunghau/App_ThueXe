package com.example.app_thuexe.DuLieu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends  SQLiteOpenHelper{

    public static final String DB_NAME = "App_ThueXe";
    public static final int DB_VERSION = 2 ;
    public static final String TABLE_KHACHHANGOTO = "khachhangoto";

    public static final String KHOTO_HOTTEN="hotten";
    public static final String KHOTO_NGAYSINH="ngaysinh";
    public static final String KHOTO_CMND="cmnd";
    public static final String KHOTO_DIACHI="diachi";
    public static final String KHOTO_GHICHU="ghichu";
    public static final String KHOTO_SOCHO="socho";
    public static final String KHOTO_NGAYNHAN="ngaynhan";
    public static final String KHOTO_NGAYTRA="ngaytra";
    public static final String KHOTO_TAIXE="taixe";
    public static final String CREATE_TABLE_KHACHHANGOTO
            = " Create Table " + TABLE_KHACHHANGOTO + " ( " + KHOTO_HOTTEN + " Text, " + KHOTO_NGAYSINH + " Text, " + KHOTO_CMND + " Integer Primary Key Autoincrement, " + KHOTO_DIACHI + " Tetx, " + KHOTO_GHICHU + " Text, " + KHOTO_SOCHO + " Text, " + KHOTO_NGAYNHAN + " Text, " + KHOTO_NGAYTRA + " Text, " + KHOTO_TAIXE + " Text); ";



    public static final String TABLE_KHACHHANGXEMAY = "khachhangxemay";

    public static final String KHXEMAY_HOTTEN="hotten2";
    public static final String KHXEMAY_NGAYSINH="ngaysinh2";
    public static final String KHXEMAY_CMND="cmnd2";
    public static final String KHXEMAY_DIACHI="diachi2";
    public static final String KHXEMAY_GHICHU="ghichu2";
    public static final String KHXEMAY_DUNGTICH="dungtich2";
    public static final String KHXEMAY_NGAYNHAN="ngaynhan2";
    public static final String KHXEMAY_NGAYTRA="ngaytra2";
    private static final String CREATE_TABLE_KHACHHANGXEMAY
            = " Create Table " + TABLE_KHACHHANGXEMAY + " ( " + KHXEMAY_HOTTEN + " Text, " + KHXEMAY_NGAYSINH + " Text, " + KHXEMAY_CMND + " Integer Primary Key Autoincrement, " + KHXEMAY_DIACHI + " Tetx, " + KHXEMAY_GHICHU + " Text, " + KHXEMAY_DUNGTICH + " Text, " + KHXEMAY_NGAYNHAN + " Text, " + KHXEMAY_NGAYTRA + " Text); ";



    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KHACHHANGOTO);
        db.execSQL(CREATE_TABLE_KHACHHANGXEMAY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" Drop Table If Exists " + TABLE_KHACHHANGOTO );
        db.execSQL(" Drop Table If Exists " + TABLE_KHACHHANGXEMAY );
        onCreate(db);
    }
}

