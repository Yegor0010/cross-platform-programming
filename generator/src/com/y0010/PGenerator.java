package com.y0010;

import java.util.ArrayList;
import java.util.Random;

public class PGenerator {
    private final int max = 10_000;

    private ArrayList<Integer> primes = new ArrayList<>();

    public PGenerator() {
        primes = getPrimes(max);
    }

    private ArrayList<Integer> getPrimes(int max) {
        boolean isntPrime[] = new boolean[max];
        isntPrime[0] = isntPrime[1] = false;
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < max; ++i) {
            if (!isntPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j < max; j += i) {
                    isntPrime[(int) j] = true;
                }
            }
        } 
        return primes;
    }
    public Integer[] getRandomPrimes(int size) {
        Random random = new Random();
        int primesN = primes.size();

        Integer res[] = new Integer[size];

        for (int i = 0; i < size; ++i) {
            res[i] = primes.get(random.nextInt(primesN));
        }
        return res;
    }
}