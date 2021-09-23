package Models;

public class OrderItem {
    private int quantity;
    private double subTotal;
    private Product product;

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.subTotal = subTotal(quantity,product.getPrice());
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }

    public double subTotal(int quantity, double price){
        return quantity * price;
    }

    @Override
    public String toString() {
        return "Product: "
                + getProduct().getName()
                + ", $"
                + String.format("%.2f", product.getPrice())
                + ", Quantity: "
                + quantity
                + ", Subtotal: "
                + String.format("%.2f", getSubTotal());
    }
}
