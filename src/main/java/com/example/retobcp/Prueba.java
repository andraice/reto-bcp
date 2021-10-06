package com.example.retobcp;

import org.springframework.boot.SpringApplication;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

    static int pos23 = 1;
    public static void main(String[] args) {

        /*
        dado un arreglo
        15,17,15,3,3,23,8,1,2,53,57,49,103
        mostrar un arreglo con los numeros primos
        y ascendente
        indicar posicion del numero 23
         */

        List<Integer> numeros = new ArrayList<Integer>();
        numeros.add(15);
        numeros.add(17);
        numeros.add(15);
        numeros.add(3);
        numeros.add(3);
        numeros.add(23);
        numeros.add(8);
        numeros.add(1);
        numeros.add(2);
        numeros.add(53);
        numeros.add(57);
        numeros.add(49);
        numeros.add(103);



        numeros.stream().sorted().filter(x -> {
            return esNumeroPrimo(x);
        }).forEach(x -> {
            if(x < 23){
                pos23++;
            }
            System.out.println(x);
        });

        System.out.println("La posicion del 23 es:");
        System.out.println(pos23);

    }

    private static boolean esNumeroPrimo(int n){
        int count = 2;
        boolean esPrimo = true;
        while ( esPrimo && (count != n)){
            if(n % count == 0)
                esPrimo = false;

            count++;
        }
        return esPrimo;
    }
}
