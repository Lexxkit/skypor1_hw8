package com.lexxkit;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    // Task 1
        System.out.println("Task 1. Check if a year is a leap year.\n");

        int myYear = 1985;
        printYearCharacteristic(myYear);

        // Task 2
        System.out.println("\nTask 2. Which app version - Lite or Full?\n");

        int clientDeviceYear = 2020;
        int clientOS = 0;
        printAppType(clientOS, clientDeviceYear);

        // Task 3
        System.out.println("\nTask 3. Calculate delivery.\n");

        int deliveryDistance = 39;

        int deliveryDays = getDeliveryDays(deliveryDistance);
        System.out.println("Your delivery will take: " + deliveryDays + " days.");

        // Task 4
        System.out.println("\nTask 4. Check sorted string for duplicate chars.\n");
        String initialStr = "aabccddefgghiijjkk";

        checkStringForDuplicatesAndPrint(initialStr);

        // Task 5
        System.out.println("\nTask 5. Reverse an array.\n");
        int[] nums = {3, 2, 1, 6, 5};

        System.out.println("Initial array: " + Arrays.toString(nums));
        reverseArray(nums);
        System.out.println("Reversed array: " + Arrays.toString(nums));

        //Task 6. Additional.
        System.out.println("\nTask 6. Calculate an average expense.\n");
        int[] dailyExpenses = generateRandomArray();

        double averageExpense = getAverageExpense(dailyExpenses);
        System.out.printf("Average daily expense is %.2f rubles.\n", averageExpense);


    }

    public static double getAverageExpense(int[] expenses) {
        int monthlyExpensesAmount = getMonthlyExpensesAmount(expenses);
        return monthlyExpensesAmount * 1.0 / expenses.length;
    }

    public static int getMonthlyExpensesAmount(int[] expenses) {
        int amount = 0;
        for (int expense : expenses) {
            amount += expense;
        }
        return amount;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void printYearCharacteristic(int year) {

        boolean isLeapYear = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);

        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is an ordinary year.");
        }
    }

    public static void printAppType(int clientOS, int deviceYear) {
        boolean isPhoneNew = isDeviceNew(deviceYear);
        String clientOSName = getClientOSName(clientOS);

        if (isPhoneNew) {
            System.out.println("Install " + clientOSName + " application from the link.");
        } else {
            System.out.println("Install light version of " + clientOSName + " application from the link.");
        }
    }

    public static boolean isDeviceNew(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear >= currentYear;
    }

    public static String getClientOSName(int clientOSCode) {
        if (clientOSCode == 0) {
            return "iOS";
        }
        return "Android";
    }

    public static int getDeliveryDays(int distance) {
        int deliveryDays = 1;

        for (int i = distance - 20; i > 0 ; i -= 40) {
            deliveryDays += 1;
        }

        return deliveryDays;
    }

    public static void checkStringForDuplicatesAndPrint(String sortedString) {
        char[] chars = sortedString.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                System.out.println("Duplicate character was found: " + chars[i]);
                return;
            }
        }
        System.out.println("NO duplicate characters were found.");
    }

    public static void reverseArray(int[] arr) {
        int tempNum;

        for (int i = 0; i < arr.length / 2; i++) {
            tempNum = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tempNum;
        }
    }

}
