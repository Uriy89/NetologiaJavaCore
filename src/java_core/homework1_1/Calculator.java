package java_core.homework1_1;

import java.util.function.*;


public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;


    // Арефметтическая ошибка, возникла из-за попытки деления на 0.
    // Ниже я представил два варианта решения данной проблемы, 1 - с помощью тирнарного выражения,
    // 2 - использование блока try/catch.
    // BinaryOperator<Integer> devide = (x, y) -> x / y;
    // Решение 1
      BinaryOperator<Integer> devide = (x, y) -> y > 0 ? x / y : -1;
    // Решение 2
   /* BinaryOperator<Integer> devide = new BinaryOperator<Integer>() {
        @Override
        public Integer apply(Integer integer, Integer integer2) {
            try {
                return integer / integer2;
            } catch (ArithmeticException a) {
                System.out.println("Деление на 0 не возможно!");
            }
            return -1;
        }
    };*/



    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;


    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
