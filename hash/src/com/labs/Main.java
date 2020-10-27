package com.labs;

public class Main {

    public static void main(String[] args) {
        ChainHashTable<String, Double>chainTable = new ChainHashTable<>();
        chainTable.insert("hello", 1.0);
        System.out.println(chainTable.getFillFactor());
        chainTable.insert("it", 2.3);
        System.out.println(chainTable.getFillFactor());
        chainTable.insert("is", 9.4);
        System.out.println(chainTable.getFillFactor());
        chainTable.insert("me", 3.5);
        System.out.println(chainTable.getFillFactor());

        System.out.println("размер " +chainTable.getSize());
        System.out.println("получить " +chainTable.get("is"));
        System.out.println("Удаление 1 " + chainTable.remove("is"));
        System.out.println("Удаление 2" +chainTable.remove("is"));
        System.out.println("Размер " +chainTable.getSize());
        System.out.println("пустой " +chainTable.isEmpty());


        System.out.println("LINEAR");

        LinearProbingTable<String, Boolean>linearProbingTable = new LinearProbingTable<>();
        linearProbingTable.insert("LIVE", true);
        linearProbingTable.insert("A", false);
        System.out.println(linearProbingTable.getSize());
        linearProbingTable.insert("LIFE", false);
        System.out.println(linearProbingTable.getFillFactor());
        linearProbingTable.insert("YOU WILL", true);
        linearProbingTable.insert("REMEMBER", false);

        System.out.println(linearProbingTable.getFillFactor());
        System.out.println(linearProbingTable.get("REMEMBER"));
        System.out.println(linearProbingTable.remove("REMEMBER"));
        System.out.println(linearProbingTable.remove("YOU WILL"));
        System.out.println(linearProbingTable.getSize());
        System.out.println(linearProbingTable.isEmpty());
    }
}
