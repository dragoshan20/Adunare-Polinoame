package com.company;

public class Polinom {
    int grad; // gradul polinomului
    int[] coef; // coeficientii polinomului

    public Polinom(int grad, int[] coef) { // constructorul implicit
        this.grad = grad;

        this.coef = new int[grad + 1];
        for (int i = 0; i <= grad; i++)
            this.coef[i] = coef[i];
    }

    public Polinom(Polinom p) { // constructorul de copiere
        if (this!=p) {
            grad = p.grad;
            coef = new int[grad+1];

            for (int i = 0; i <= grad; i++)
                coef[i] = p.coef[i];
        }
    }

    //rez = p1.add(p2);

    public Polinom add(Polinom p1) { // metoda pentru adunarea polinoamelor
        Polinom rez; // polinomul rezultat
        if (this.grad > p1.grad) { // verificam gradul carui polinom este mai mare si il bagam in rez, apoi adunam la acesta polinomul mai mic
            rez = new Polinom(this);
            for (int i = 0; i <= p1.grad; i++)
                rez.coef[i] += p1.coef[i];
        }
        else {
            rez = new Polinom(p1);
            for (int i = 0; i <= this.grad; i++)
                rez.coef[i] += this.coef[i];
        }
        return rez;
    }

    public Polinom mul(Polinom p1) { // metoda pentru produsul polinoamelor
        int gradRez = this.grad + p1.grad; // gradul polinomului produs este suma gradelor polinoamelor inmultite
        int[] coefRez = new int[gradRez + 1];
        for (int i = 0; i <= gradRez; i++)
            coefRez[i] = 0;
        Polinom rez = new Polinom(gradRez, coefRez);
        for (int i = 0; i <= this.grad; i++) {
            for (int j = 0; j <= p1.grad; j++) {
                rez.coef[i + j] += this.coef[i] * p1.coef[j] ; // se inmultesc coeficientii
            }
        }

        return rez;
    }

}
