import java.util.Scanner;

public class ActivityThreeEquibal {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int totalQuantity = 0;
      double totalCost = 0;
      double usdToPhp = 56.00;
      
      System.out.println("Menu:");
      System.out.println("C1 = Php 100.00");
      System.out.println("C2 = Php 150.00");
      System.out.println("C3 = Php 200.00");
      System.out.println("Add-ons:");
      System.out.println("R1 = Php 35.00");
      System.out.println("R2 = Php 50.00");
   
      while (true) {
         System.out.print("Enter Order Code C1/C2/C3/R1/R2 (or 'E' to exit/order): ");
         String orderCode = scanner.nextLine().trim().toUpperCase();
      
         if (orderCode.equals("E")) {
            break;
         }
         System.out.print("Enter Quantity: ");
         int quantity = scanner.nextInt();
         scanner.nextLine();
      
         double cost = 0;
         switch (orderCode) {
            case "C1":
               cost = 100.00 * quantity;
               break;
            case "C2":
               cost = 150.00 * quantity;
               break;
            case "C3":
               cost = 200.00 * quantity;
               break;
            case "R1":
               cost = 35.00 * quantity;
               break;
            case "R2":
               cost = 50.00 * quantity;
               break;
            default:
               System.out.println("Invalid Order Code. Please enter a valid code.");
               continue;
         }
      
         totalCost += cost;
         totalQuantity += quantity;
      
         System.out.println("Order Code: " + orderCode);
         System.out.println("Quantity: " + quantity);
         System.out.println("Total Cost: Php " + cost);
      }
   
      System.out.println("Total Quantity: " + totalQuantity);
      System.out.println("Total Price (PHP): Php " + totalCost);
      double totalUsd = totalCost / usdToPhp;
      System.out.println("Total Price (USD): $" + String.format ("%.2f", totalUsd));
      System.out.println("Thank you for your purchase!");
      
      scanner.close();
   }
}



import java.util.Scanner;

public class RoutesActivity {
   public static void main(String[] args) {
      System.out.println("Cebu City (Start)");
      System.out.println("Minglanilla (Route 1)");
      System.out.println("San Fernando (Route 2)");
      System.out.println("Carcar (Route 3)");
      System.out.println("Barili (Route 4.1)");
      System.out.println("Dumanjug (Route 4.1.1)");
      System.out.println("Alcantara (Route 4.1.2)");
      System.out.println("Moalboal (End)");
   }
}