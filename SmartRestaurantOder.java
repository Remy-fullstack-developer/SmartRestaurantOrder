

import java.util.Scanner;

public class SmartRestaurantOder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

      
         double DRINK_PRICE = 15.50;
         double STUDENT_DISCOUNT = 0.10;  
         double SENIOR_DISCOUNT = 0.05;  
         double TIP_RATE = 0.10;          
         int SENIOR_AGE = 60;

       
        System.out.print("Enter customer's name: ");
        String name = input.nextLine();                 

        System.out.print("Enter customer's age: ");
        int age = input.nextInt();                     

        System.out.print("Enter price of the meal: $");
        double mealPrice = input.nextDouble();          

        System.out.print("Enter number of drinks: ");
        int drinks = input.nextInt();                   

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = input.nextBoolean();        

        System.out.print("Enter service rating (1 to 5): ");
        int rating = input.nextInt();                  

        System.out.println();

        
        if (rating < 1 || rating > 5) {

            
            System.out.println("ERROR: Service rating must be from 1 to 5.");

        } else {

        

           
            double drinksCost = drinks * DRINK_PRICE;

           
            double subtotal = mealPrice + drinksCost;

           
            double discountRate;

            if (isStudent && age >= SENIOR_AGE) {
                
                if (STUDENT_DISCOUNT > SENIOR_DISCOUNT) {
                    discountRate = STUDENT_DISCOUNT;
                } else {
                    discountRate = SENIOR_DISCOUNT;
                }
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT;
            } else if (age >= SENIOR_AGE) {
                discountRate = SENIOR_DISCOUNT;
            } else {
                discountRate = 0;   
            }

            
            double discountAmount = subtotal * discountRate;

           
            double afterDiscount = subtotal - discountAmount;

            
            double tipAmount;

            if (rating >= 4) {
                tipAmount = afterDiscount * TIP_RATE;
            } else {
                tipAmount = 0;
            }

            
            double finalBill = afterDiscount + tipAmount;

            
            int wholeBill = (int) finalBill;

            
            System.out.println("SMART RESTAURANT");
            System.out.println("Customer: " + name);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeBill);
        }

        input.close();
    }
}
