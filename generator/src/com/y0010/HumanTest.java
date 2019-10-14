package com.y0010;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HumanTest {
    public static void main(String[] args) {
        Set<Human> humanSet = createTestHashSet();
        createTestLinkedHashSet(humanSet);
        createTestTreeSet(humanSet);
        createTestTreeSetWithSurnameComparator(humanSet);
        createTestTreeSetWithAgeComparator(humanSet);
    }

    private static Set<Human> createTestHashSet() {
        Set<Human> set = new HashSet<Human>();
        set.add(new Human("Yeric", "Boric", 18));
        set.add(new Human("Some", "Gmuric", 19));
        set.add(new Human("Som", "Sam", 19));
        set.add(new Human("Long", "Jam", 19));
        set.add(new Human("Def", "Ref", 19));
        set.add(new Human("Gum", "Rum", 41));
        set.add(new Human("Roberto", "Franssolly", 54));

        System.out.println(set.toString());

        return set;
    }

    private static void createTestLinkedHashSet(Set<Human> humans) {
        Set<Human> linkedSet = new LinkedHashSet<>(humans);

        System.out.println(linkedSet.toString());
    }

    private static void createTestTreeSet(Set<Human> humans) {
        Set<Human> treeSet = new TreeSet<>(humans);

        System.out.println(treeSet.toString());
    }

    private static void createTestTreeSetWithSurnameComparator(Set<Human> humans) {
        Set<Human> treeSet = new TreeSet<>(new HumanComparatorByLastName());
        treeSet.addAll(humans);

        System.out.println(treeSet.toString());
    }

    private static void createTestTreeSetWithAgeComparator(Set<Human> humans) {
        Set<Human> treeSet = new TreeSet<>(new HumanComparatorByAge());
        treeSet.addAll(humans);

        System.out.println(treeSet.toString());
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human first, Human second) {
        if (first == null || second == null)
            return first == second ? 0 : first != null ? 1 : -1;

        return first.getLastName().compareToIgnoreCase(second.getLastName());
    }
}

class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human first, Human second) {
        if (first == null || second == null)
            return first == second ? 0 : first != null ? 1 : -1;

        return Integer.compare(first.getAge(), second.getAge());
    }
}