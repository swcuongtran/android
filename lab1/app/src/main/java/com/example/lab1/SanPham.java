package com.example.lab1;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String tensp;
    private int hinhsp;
    private String motasp;
    private  int giasp;

    public SanPham(){

    }
    public SanPham(String tensp, int hinhsp, String motasp, int giasp){
        this.tensp = tensp;
        this.hinhsp = hinhsp;
        this.motasp = motasp;
        this.giasp = giasp;
    }
    public String getTensp(){return tensp;}
    public void setTensp(){this.tensp = tensp;}
    public int getHinhsp(){return hinhsp;}
    public void setHinhsp(){this.hinhsp = hinhsp;}
    public String getMotasp(){return motasp;}
    public void setMotasp(){this.motasp = motasp;}
    public int getGiasp(){return giasp;}
    public void setGiasp(){this.giasp = giasp;}
}
