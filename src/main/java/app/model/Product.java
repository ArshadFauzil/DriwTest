package app.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Product {
    /*@Id*/
    private int pid;
    private String name;
    private float unitPrice;
    private int cartonSize;

    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getPid() {
        return this.pid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPrice(float price) {
        this.unitPrice = price;
    }
    public float getPrice() {
        return this.unitPrice;
    }
    public void setCartonSize(int size) {
        this.cartonSize = size;
    }
    public int getcartonSize() {
        return this.cartonSize;
    }
}
