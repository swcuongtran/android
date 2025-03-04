package module;

import java.util.ArrayList;

public class MonHoc {
    private String tenmh;
    private ArrayList<SinhVien> dsSinhVien = new ArrayList<>();

    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public MonHoc(){

    }
    public MonHoc(String tenmh){
        this.tenmh = tenmh;
    }
    public String getTenmh(){
        return tenmh;
    }
    public void setTenmh(String tenmh){
        this.tenmh = tenmh;
    }
    @Override
    public String toString(){
        return getTenmh();
    }
}
