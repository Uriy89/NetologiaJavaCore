package java_core.homework2_2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_00; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count1 = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        System.out.println(count1);

       List<String> count2 = persons.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        System.out.println(count2);

        List<Person> countWoman = persons.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getAge() <= 60)
                .filter(p -> p.getSex() == Sex.WOMAN)
                .filter(p -> p.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        List<Person> countMan = persons.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getAge() <= 65)
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());


        for (Person p : countWoman) {
            System.out.println(p);
        }
        for (Person p : countMan) {
            System.out.println(p);
        }
    }
}
