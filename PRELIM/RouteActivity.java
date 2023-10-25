import java.util.Scanner;

public class RouteActivity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cebu Route Planner!");

        String selectedRoute = planRoute(scanner, "Cebu to Mingla", "Mingla to San Fernando", "San Fernando to Carcar");
        System.out.println("Your selected route: " + selectedRoute);

        scanner.close();
    }

    private static String planRoute(Scanner scanner, String... routes) {
        for (int i = 0; i < routes.length; i++) {
            System.out.println("Route " + (i + 1) + ": " + routes[i]);

            if (i == routes.length - 1) {
                System.out.print("Is this the final destination? (yes/no): ");
                String finalDestination = scanner.nextLine().toLowerCase();

                if (finalDestination.equals("yes")) {
                    return routes[i];
                }
            } else {
                System.out.print("Is Route " + (i + 1) + " obstructed? (yes/no): ");
                String obstructedRoute = scanner.nextLine().toLowerCase();

                if (obstructedRoute.equals("yes")) {
                    String alternativeRoute = planAlternativeRoute(scanner, routes[i]);
                    System.out.println("Taking alternative route: " + alternativeRoute);
                    return alternativeRoute;
                }
            }
        }
        return "No valid route selected.";
    }

    private static String planAlternativeRoute(Scanner scanner, String currentRoute) {
        String alternativeRoute = null;

        switch (currentRoute) {
            case "San Fernando to Carcar":
                System.out.print("Choose an alternative route (4.1 for Barili-Dumanjug-Alcantara-Moalboal, 4.2 for Sibonga): ");
                String alternativeRouteChoice = scanner.nextLine();
                if (alternativeRouteChoice.equals("4.1")) {
                    alternativeRoute = planRoute(scanner, "Barili to Dumanjug", "Dumanjug to Alcantara", "Alcantara to Moalboal");
                } else if (alternativeRouteChoice.equals("4.2")) {
                    alternativeRoute = planRoute(scanner, "Sibonga to Dumanjug", "Dumanjug to Alcantara", "Alcantara to Moalboal");
                }
                break;
            case "Sibonga to Dumanjug":
                System.out.print("Choose an alternative route (4.2.1 for Dumanjug to Alcantara, 4.2.2 for Alcantara to Moalboal): ");
                String nestedAlternativeRouteChoice = scanner.nextLine();
                if (nestedAlternativeRouteChoice.equals("4.2.1")) {
                    alternativeRoute = planRoute(scanner, "Dumanjug to Alcantara", "Alcantara to Moalboal");
                } else if (nestedAlternativeRouteChoice.equals("4.2.2")) {
                    alternativeRoute = planRoute(scanner, "Alcantara to Moalboal");
                }
                break;
            case "Alcantara to Moalboal":
                alternativeRoute = "Alcantara to Moalboal";
                break;
            case "Barili to Dumanjug":
            case "Dumanjug to Alcantara":
                System.out.println("Route " + currentRoute + " is obstructed. Choosing alternative route.");
                alternativeRoute = planAlternativeRoute(scanner, currentRoute);
                break;
            default:
                System.out.println("Invalid route choice.");
                break;
        }

        return alternativeRoute;
    }
}
