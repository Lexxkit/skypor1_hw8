package com.lexxkit;

import java.time.LocalDate;

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
        int currentDate = LocalDate.now().getYear();
        return deviceYear >= currentDate;
    }

    public static String getClientOSName(int clientOSCode) {
        if (clientOSCode == 0) {
            return "iOS";
        }
        return "Android";
    }

}
