import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args){
        System.out.println("Welcome to Health Kiosk");
        char letter = 'a';
        String service;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter service code(P/L/T/C): ");
        letter = input.next().charAt(0);

        service = switch(letter){
            case 'P'-> service = "Pharmacy Desk";
            case 'L'-> service = "Lab Desk";
            case 'T'-> service = "Triage Desk";
            case 'C'-> service = "Counseling Desk";
            default-> service = "Invalid service code";
        };
        System.out.println("Go to: " + service);

        int healthMetric = 0;
        double weight;
        double height;
        double BMI = 0;
        double dosage;
        double angle;
        String category;
        char upper;
        final double tablets = 250;
        int numberofTablets;
        int num1,num2,num3,num4;
        String code;

        if(service == "t") {
            System.out.print("Enter health metric(1 for BMI,2 for Dosage round-up,3 for simple trig helper): ");
            healthMetric = input.nextInt();
            switch (healthMetric) {
                case 1:
                    System.out.print("Enter weight(in kg): ");
                    weight = input.nextDouble();
                    System.out.print("Enter height(in meters): ");
                    height = input.nextDouble();

                    BMI = weight / (height * height);
                    System.out.println("BMI: " + Math.round(BMI * 10) / 10.0);

                    if (BMI < 18.5) {
                        category = "Underweight";
                    } else if (BMI >= 18.5 && BMI < 25) {
                        category = "Normal";
                    } else if (BMI >= 25 && BMI < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }
                    System.out.println("BMI: " + BMI + " Category: " + category);
                    break;

                case 2:
                    System.out.print("Enter dosage(in mg): ");
                    dosage = input.nextDouble();


                    numberofTablets = (int) Math.ceil(dosage / tablets);
                    System.out.println("Number of tablets: " + numberofTablets);
                    break;

                case 3:
                    System.out.print("Enter your angle in degrees: ");
                    angle = input.nextDouble();
                    double radians = Math.toRadians(angle);
                    double sineValue = Math.sin(radians);
                    double cosineValue = Math.cos(radians);
                    double sineRounded = (Math.round(sineValue * 1000) / 1000.0);
                    double cosineRounded = (Math.round(cosineValue * 1000) / 1000.0);

            }
        }

        // Task 3
        Random random = new Random();
        char randomUpper = (char) (random.nextInt(26) + 65);
        System.out.println("Random Upper: " + randomUpper);
        String upperLetter = Character.toString(randomUpper);
        num1= random.nextInt(7)+3;
        String firstNum= String.valueOf(num1);
        num2= random.nextInt(7)+3;
        String secondNum= String.valueOf(num2);
        num3= random.nextInt(7)+3;
        String thirdNum= String.valueOf(num3);
        num4= random.nextInt(7)+3;
        String fourthNum= String.valueOf(num4);
        code = (upperLetter + firstNum + secondNum + thirdNum + fourthNum);
        System.out.println("Code: " + code);

        if(code.length()==5)
            System.out.println("Valid length of code");
        else
            System.out.println("Invalid code");

        char firstLetter = code.charAt(0);

        if(Character.isLetter(firstLetter))
            System.out.println("Valid letter");
        else
            System.out.println("Invalid letter");

        if(Character.isDigit(num1) &&  Character.isDigit(num2) && Character.isDigit(num3) && Character.isDigit(num4)){
            System.out.println("Numbers are valid");
        }
        else
            System.out.println("Invalid numbers");

        // Task 4
        System.out.println("Enter you first name: ");
        String firstName = input.next();
        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (base - 'A'+2)%26);
        String lastTwoOfID;
        if(code.length() >=2){
            lastTwoOfID = code.substring(code.length()-2);
        }
        else{
            lastTwoOfID = code;
        }

        String display="" + shifted + lastTwoOfID + "-" + healthMetric;
        System.out.println("Display code: " + display);

        // Task 5
        System.out.println("Service Summary");
        String ID = "ID=" + code;
        String partOfID = "Code=" + display;

        String summary;
        if (service.equals("t")) {
            if (healthMetric==1) {
                summary = "Triage | " + ID + " | BMI=" + BMI + " | " + partOfID;
            }
            else if (healthMetric==2) {
                summary = "Triage | " + ID + " | Tablets=" + tablets + " | " + partOfID;
            }
            else if (healthMetric==3) {
                summary = "Triage | " + ID + " | sine=" + sineRounded + " | " + partOfID;
            }
            else{
                summary = "Triage | " + ID + " | " + partOfID;
            }
        }
        else if (service.equals("P")) {
            summary = "PHARMACY | " + ID + " | " + partOfID ;
        } else if (service.equals("L")) {
            summary = "LAB | " + ID + " | " + partOfID ;
        } else if (service.equals("C")) {
            summary = "COUNSELING | " + ID + " | " + partOfID ;
        } else {
            summary = service.toUpperCase() + " | " + ID + " | " + partOfID;
        }
        System.out.println("Summary: " + summary);


        input.close();

    }
}