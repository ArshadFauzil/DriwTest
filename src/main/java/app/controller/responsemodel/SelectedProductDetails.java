package app.controller.responsemodel;

public class SelectedProductDetails {
    public String name;
    public double pricePerUnit;
    public int quantity;
    public int cartons;
    public int units;
    public double totalProductPrice;

    public SelectedProductDetails(String name, double pricePerUnit, int quantity, int cartons, int units, double totalProductPrice) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.cartons = cartons;
        this.units = units;
        this.totalProductPrice = totalProductPrice;
    }
    public SelectedProductDetails() {}
}
