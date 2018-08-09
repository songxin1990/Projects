package com.song.solution.tdd;

/**
 * Created by 001844 on 2018/1/5.
 */
public class StringCalculator {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        System.out.println(result);
    }

    /*public int add(String numbers) {
        if(numbers==null||numbers.isEmpty()){
            return 0;
        }
//        "1\n2,3";
        numbers = numbers.replace("\n",",");
        String[] numStrs = numbers.split(",");


        int sum = 0;

        return sum;
    }*/
    //;\n1;2
    public static final int add(final String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        StringBuilder delimiterRxp = new StringBuilder(",|\n");
        if (numbers.startsWith("//")) {
            delimiterRxp.append("|").append(numbers.substring(2, 3));
        }
        String numbersWithOnlyDelimiter = numbers.substring(3);

        return add(numbersWithOnlyDelimiter, delimiterRxp.toString());
    }

    private static final int add(String numbersWithOnlyDelimiter, String delimiterRxp) {
        String[] numbersArray = numbersWithOnlyDelimiter.split(delimiterRxp);
        int sum = 0;
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
