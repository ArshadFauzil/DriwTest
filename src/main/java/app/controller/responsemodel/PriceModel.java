package app.controller.responsemodel;

import java.util.List;

public class PriceModel {
    public List<SelectedProductDetails> selectedProduct;
    public double totalPrice;

    public PriceModel(List<SelectedProductDetails> selectedProduct, double totalPrice) {
        this.selectedProduct = selectedProduct;
        this.totalPrice = totalPrice;
    }
}