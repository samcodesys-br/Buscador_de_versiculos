package org.example;

import org.example.Facade.ApiFacade;

import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            System.out.println("Busca de versículos: ");
            System.out.println("> ");
            String word= input.nextLine().toLowerCase();

            ApiFacade facade=new ApiFacade();
            facade.buscarVersiculos(word);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}