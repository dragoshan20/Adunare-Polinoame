package com.company;

import java.util.Scanner;

public class Main {
    final static int MAX_SIZE = 1000;
    static Polinom[] polinoame;

    public static void read() { // citirea polinoamelor
        Scanner scn = new Scanner(System.in);
        System.out.println("Dati numarul de polinoame: ");
        int nr = scn.nextInt();
        polinoame = new Polinom[nr];
        for (int i = 0; i < nr; i++) {
            System.out.println("Dati gradul polinomului: ");
            Scanner s = new Scanner(System.in);
            int grad = s.nextInt();
            int[] coef = new int[grad + 1];
            System.out.println("Dati coeficientii polinomului " +
                    "in ordine crescatoare a puterii monomului");

            String input = s.next();
            coef = input.split(" ");

            Polinom p = new Polinom(grad, coef);
            polinoame[i] = p;
        }

    }

    public static Polinom adunare(Polinom[] polinoame) { // adunarea polinoamelor date
        Polinom rezAdd = new Polinom(0, new int[]{0});
        for (int i = 0; i < polinoame.length; i++)
            rezAdd = rezAdd.add(polinoame[i]);
        return rezAdd;
    }

    public static Polinom inmultire(Polinom[] polinoame) { // inmultirea polinoamelor date
        Polinom rezMul = new Polinom(0, new int[]{1});
        for (int i = 0; i < polinoame.length; i++)
            rezMul = rezMul.mul(polinoame[i]);
        return rezMul;
    }

    public static void print(Polinom p) { // afisarea polinomului rezultat
        for (int i = p.grad; i >= 0; i--) {
            if (p.coef[i] != 0 && p.coef[i] != 1)
                System.out.print(p.coef[i] + "X^" + i);
            else if (p.coef[i] == 1)
                System.out.print("X^" + i);
            if (i > 0)
                System.out.print(" + ");
        }
        System.out.println();
    }

    public static int readOp(String s) { //citire optiuni
        System.out.println(s);
        try {
            Scanner scn = new Scanner(System.in);
            int nr = scn.nextInt();
            return nr;
        } catch (Exception exp) {
            System.out.println("Dati un numar intreg");
            return readOp(s);
        }
    }

    public static int menu() { // meniul programului
        System.out.println();
        System.out.println("1. Introduceti polinoamele");
        System.out.println("2. Suma polinoamelor");
        System.out.println("3. Produsul polinoamelor");
        System.out.println("0. Exit");
        return readOp("Alegeti optiunea: ");
    }

    public static void main(String[] args) { // functia main
        Polinom rezAd;
        Polinom rezMul;
        int op = menu();
        while (op != 0) {
            switch (op) {
                case 1 -> read();
                case 2 ->{
                    System.out.println("Suma polinoamelor este: ");;
                    rezAd = adunare(polinoame);
                    print(rezAd);
                }
                case 3 -> {
                    System.out.println("Produsul polinoamelor este: ");
                    rezMul = inmultire(polinoame);
                    print(rezMul);
                }
                default -> System.out.println("Alegeti o optiune valida");
            }
            op = menu();
        }
    }
}
