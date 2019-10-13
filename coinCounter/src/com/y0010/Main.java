package com.y0010;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int coinTypes[] = { 1, 2, 5, 10, 25 };
        Arrays.sort(coinTypes);

        // reverse sorted array
        for (int i = 0; i < coinTypes.length / 2; ++i) {
            int tmp = coinTypes[i];
            coinTypes[i] = coinTypes[coinTypes.length - i - 1];
            coinTypes[coinTypes.length - i - 1] = tmp;
        }
        int currentIndex = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how much do u have in coins:\n>>");
        int coins = sc.nextInt();
        int coinsCount[] = new int[coinTypes.length];
        while (coins > 0 && currentIndex < coinTypes.length) {
            if (coins < coinTypes[currentIndex]) {
                ++currentIndex;
            } else {
                ++coinsCount[currentIndex];
                coins -= coinTypes[currentIndex];
            }
        }
        for (int i = 0; i < coinsCount.length; ++i) {
            System.out.println(Integer.toString(coinTypes[i]) + " format: " + Integer.toString(coinsCount[i]));
        }
    }
}
