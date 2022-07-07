package java_core.homework2_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> list = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (Integer i : intList) if (i > 0) list.add(i);
        for (Integer i : list) if (i % 2 == 0) evenList.add(i);

        Collections.sort(evenList);

        System.out.println(evenList);
    }
}
