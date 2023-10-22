import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group? ");
        int numPeople = scan.nextInt();
        System.out.print("Enter a tip percentage (1-100): ");
        int tipPercent = scan.nextInt();

        double totalMealCost = 0;
        Vector<Double> costList = new Vector<Double>();
        Vector<String> foodList = new Vector<String>();
        int i = 0;
        while (true) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): $");
            double cost = scan.nextDouble();
            if (cost == -1) {
                break;
            }
            costList.add(cost);
            totalMealCost += cost;
            System.out.print("Enter the item name: ");
            String food = scan.nextLine();
            foodList.add(food);
            i++;
        }
        int a = 0;
        double totalTip = tipTotal(tipPercent, totalMealCost);
        double costTotal = totalCost(totalMealCost, totalTip);
        double costPerPerson = costPerPerson(totalMealCost, numPeople);

        System.out.println("-----------------------------");
        System.out.println("Total bill before tip: $" + totalMealCost);
        System.out.println("Total percentage: " + tipPercent + "%");
        System.out.println("Total tip: $" + totalTip);
        System.out.println("Total bill with tip: $" + costTotal);
        System.out.println("Per person cost before tip: $" + (totalMealCost / numPeople));
        System.out.println("Tip per person: $" + (totalTip / numPeople));
        System.out.println("Total cost per person: $" + costPerPerson);
        System.out.println("-----------------------------");
        System.out.println("Itemized List:");

        while (a < i) {
            System.out.println(foodList.get(a) + ": $" + costList.get(a));
            a++;
        }
        System.out.println("Thank you, have a nice day!");
    }

    public static double tipTotal(int tipPercent, double totalMealCost) {
        return ((double) tipPercent / 100) * totalMealCost;
    }

    public static double totalCost(double totalMealCost, double tipTotal) {
        return totalMealCost + tipTotal;
    }

    public static double costPerPerson(double totalMealCost, int numPeople) {
        return totalMealCost / numPeople;
    }

}

