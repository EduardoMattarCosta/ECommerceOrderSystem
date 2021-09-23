package Models;

import Models.Enums.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd,mm,yyyy");

    private Date moment;
    private Status orderStatus;
    private Client client;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order() {}

    public Order(Date moment, Status orderStatus, Client client) {
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public Status getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        this.items.add(item);
    }

    public void removeItem(OrderItem item){
        this.items.remove(item);
    }

    public double getTotal(){
        double total =0.0;
        for(OrderItem item : items){
            total += item.getSubTotal();
        }
        return  total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(orderStatus + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}

