package module;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String masv;
    private String tensv;
    private String diachi;
    private MonHoc monHoc;
    public SinhVien(){}
    public SinhVien(String masv, String tensv,String diachi){
        this.masv = masv;
        this.tensv = tensv;
        this.diachi = diachi;
    }

    public String getMasv() {
        return masv;
    }

    public String getTensv() {
        return tensv;
    }

    public String getDiachi() {
        return diachi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
    @Override
    public String toString(){
        return getMasv() + "\t" +getTensv()+ "\t" + getDiachi();
    }
}
