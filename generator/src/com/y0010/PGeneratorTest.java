package com.y0010;

import com.y0010.PGenerator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class PGeneratorTest {
    public static void main(String[] args) {
        PGenerator generator = new PGenerator();

        Integer primes[] = generator.getRandomPrimes(20);
        List<Integer> list = Arrays.asList(primes);
        Collections.sort(list);

        printListForward(list);
        printListBackwardByIterator(list);
        printListBackwardByComparator(list);
    }

    private static void printIteratorData(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
    }

    
    private static Iterator<Integer> backIterator(List<Integer> l) {
        return new Iterator<Integer>() {
            private List<Integer> list = l;
            private int index = list.size();
            
            @Override
            public boolean hasNext() {
                return index > 0;
            }
            
            @Override
            public Integer next() {
                return list.get(--index);
            }
        };
    }

    private static void printListForward(List<Integer> list) {
        printIteratorData(list.iterator());
    }
    
    private static void printListBackwardByIterator(List<Integer> list) {
        printIteratorData(backIterator(list));
    }

    private static void printListBackwardByComparator(List<Integer> list) {
        List<Integer> copy = new ArrayList<Integer>(list);
        Collections.sort(list, new DescOrder());

        printIteratorData(list.iterator());
    }
}

class DescOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}