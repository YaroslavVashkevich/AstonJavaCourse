package ru.aston.course.lesson5.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).forEach(System.out::println);
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
        String str = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted().toList().toString();
        System.out.println(str);
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("Trader not found"));
        int sum = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).mapToInt(Transaction::getValue).sum();
        System.out.println(sum);
        int max = transactions.stream().mapToInt(Transaction::getValue).max().getAsInt();
        System.out.println(max);
        transactions.stream().min(Comparator.comparing(transaction -> transaction.getValue())).ifPresentOrElse(System.out::println, () -> System.out.println("Transaction not found"));
    }
}
