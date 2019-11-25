package app.controller.requestmodel;

public class SelectedProduct {
    public int pid;
    public int quantity;
    public boolean inCartons;

    public SelectedProduct(int pid, int quantity, boolean inCartons) {
        this.pid = pid;
        this.quantity = quantity;
        this.inCartons = inCartons;
    }
}
