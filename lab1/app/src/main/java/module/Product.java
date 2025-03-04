package module;

import java.io.Serializable;

public class Product implements Serializable {
    private String namePro;
    private double priPro; 
    private int imagePro;
    public Product(){}
    public Product(String namePro, double priPro, int imagePro){
        this.namePro = namePro;
        this.priPro = priPro;
        this.imagePro = imagePro;
    }
    public String getNamePro() {
        return namePro;
    }

    public void setNamePro(String namePro) {
        this.namePro = namePro;
    }

    public double getPriPro() {
        return priPro;
    }

    public void setPriPro(double priPro) {
        this.priPro = priPro;
    }

    public int getImagePro() {
        return imagePro;
    }

    public void setImagePro(int imagePro) {
        this.imagePro = imagePro;
    }
}
