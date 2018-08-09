package com.song.solution.numbers;

import java.util.*;

/**
 * Created by 001844 on 2018/1/2.
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input needed fibonacci sequence length");

        int len = scanner.nextInt();
        if (len <= 0) {
            System.out.printf("length invalid %d", len);
            System.exit(0);
        }
        List<Long> list = gen(len);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Long> gen(int len) {
        if (len <= 0) {
            return Collections.emptyList();
        }
        List<Long> list = new ArrayList<Long>(len);
        for (int i = 0; i < len; i++) {
            list.add(fibonacci(i));
        }
        return list;
    }


    /*怎么写测试用例？*/
    private static long fibonacci(long n) {
        if (n == 0) {
            return 0L;
        } else if (n == 1) {
            return 1L;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


}
