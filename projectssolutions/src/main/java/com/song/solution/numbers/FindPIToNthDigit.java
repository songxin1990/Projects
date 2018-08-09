package com.song.solution.numbers;


import java.io.*;
import java.util.Scanner;

/**
 * Created by 001844 on 2018/1/2.
 */
public class FindPIToNthDigit {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input decimal places");
        int decimal = scanner.nextInt();
        getDecimalPI(decimal);
    }

    public static String getDecimalPI(int decimal) throws IOException {
        final int EXTRA_LEN = 2;
        if (decimal < 0) {
            System.out.printf("invalid decimal %d", decimal);
            return null;
        } else if (decimal == 0) {
            return "3";
        }
        File filePI = new File(ClassLoader.getSystemResource("pi.txt").getFile());

        if (filePI == null || !filePI.exists()) {
            System.out.println("PI file not found");
            return null;
        }
        long piLen = filePI.length();
        if (decimal >= piLen - EXTRA_LEN) {
            System.out.println("out of index");
            return null;
        } else {
            BufferedReader br = new BufferedReader(new FileReader(filePI));
            char[] chars = new char[decimal + EXTRA_LEN];
            br.read(chars, 0, decimal + EXTRA_LEN);
            return new String(chars);
        }
    }
}
