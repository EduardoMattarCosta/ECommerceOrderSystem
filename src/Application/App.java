package Application;

import Models.*;
import Models.Enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.print("Status: ");
        Status status = Status.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many Itens does this order have:");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter the #" +(i+1)+ "item:" );
            sc.nextLine();
            System.out.println("Enter the product name:");
            String productName = sc.nextLine();
            System.out.println("Enter the product price:");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity:");
            int quantity = sc.nextInt();

            Product prod = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(quantity, prod);
            order.addItem(orderItem);

        }
        System.out.println();
        System.out.println(order);

        sc.close();

    }
}
