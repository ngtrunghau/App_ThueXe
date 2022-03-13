package com.example.app_thuexe.DuLieu;

public class KhachHangOto {
    private String hoten;
    private String ngaysinh;
    private int cmnd;
    private String diachi;
    private String ghichu;
    private String socho;
    private String ngaynhan;
    private String ngaytra;
    private String taixe;

    public KhachHangOto(){}



    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getSocho() {
        return socho;
    }

    public void setSocho(String socho) {
        this.socho = socho;
    }

    public String getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(String ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getTaixe() {
        return taixe;
    }

    public void setTaixe(String taixe) {
        this.taixe = taixe;
    }

    public KhachHangOto( String hoten, String ngaysinh, int cmnd, String diachi, String ghichu, String socho, String ngaynhan, String ngaytra, String taixe){

        this.hoten=hoten;
        this.ngaysinh=ngaysinh;
        this.cmnd=cmnd;
        this.diachi=diachi;
        this.ghichu=ghichu;
        this.socho=socho;
        this.ngaynhan=ngaynhan;
        this.ngaytra=ngaytra;
        this.taixe=taixe;
    }
}
