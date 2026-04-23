package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;

        if (args.length == 0) {
            System.out.print("값을 입력하세요: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } else {
            input = args[0];
        }

        System.out.println(Calc.run(input));
    }
}