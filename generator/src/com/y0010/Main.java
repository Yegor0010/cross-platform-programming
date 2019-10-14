package com.y0010;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.y0010.PGenerator;

public class Main {

    public static void main(String[] args) {
        Integer primes[] = generatePrimes();
        List<Integer> primesList = convertArrayToList(primes);
        System.out.println("Step 2: converting array to list... " + primesList);

        printSortedList(primesList);
        printShuffledList(primesList);
        printRotatedList(primesList, 2);
        printOnlyDuplicated(primesList);
        printArrayOfList(primesList);
    }

    private static Integer[] generatePrimes() {
        PGenerator generator = new PGenerator();
        Integer primes[] = generator.getRandomPrimes(100);
        System.out.println("Step 1: generating numbers... " + Arrays.toString(primes));
        return primes;
    }

    private static List<Integer> convertArrayToList(Integer arr[]) {
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    private static void printSortedList(List<Integer> list) {
        Collections.sort(list);
        System.out.println("Step 3: sorted list... " + list.toString());

    }

    private static void printShuffledList(List<Integer> list) {
        Collections.shuffle(list);
        System.out.println("Step 4: stuffed everything up... " + list.toString());
    }

    private static void printRotatedList(List<Integer> list, int rot) {
        Collections.rotate(list, rot);
        System.out.println("Step 5: rotating everything for you... " + list.toString());
    }

    private static void printOnlyDuplicated(List<Integer> list) {
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        list.removeIf(e -> map.get(e) < 2);
        System.out.println("Step 6: remove everything for you... " + list.toString());
    }

    private static void printArrayOfList(List<Integer> list) {
        Integer[] array = list.stream().toArray(Integer[]::new);
        System.out.println("Step 7: here we go again! your array: " + Arrays.toString(array));
    }
}
