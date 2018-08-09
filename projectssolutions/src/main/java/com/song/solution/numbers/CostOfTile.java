package com.song.solution.numbers;

import java.util.Scanner;

/**
 * Created by 001844 on 2018/1/2.
 * 1000.5 * 950.5
 * 60*60
 * 32.5
 */
public class CostOfTile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the floor width and height in cm,separate by * or blank");
        double floorSize = size(scanner.nextLine());

        System.out.println("please input the tile width and height in cm,separate by * or blank");
        double tileSize = size(scanner.nextLine());

        System.out.println("please input the tile cost");
        double tileCost = scanner.nextDouble();
        Double temp = floorSize / tileSize;
        int tileNum = temp.doubleValue() == 0.0 ? temp.intValue() : temp.intValue() + 1;
        double totalCost = tileCost * tileNum;
        System.out.println("tile of floor total cost:" + totalCost);
    }

    private static double size(String sizeParamStr) {
        double size = 0D;
        if (sizeParamStr == null || sizeParamStr.length() == 0) {
            System.out.println("size parameters null,exit");
            System.exit(0);
        }
        if (!sizeParamStr.contains("*") && !sizeParamStr.contains(" ")) {
            System.out.println("size parameters lack separator x or ");
            System.exit(0);
        }
        String separator = null;
        if (sizeParamStr.contains("*")) {
            separator = "\\*";
        } else if (sizeParamStr.contains(" ")) {
            separator = " ";
        }
        String[] strs = sizeParamStr.split(separator);
        double floorWidth = Double.valueOf(strs[0]);
        double floorHeight = Double.valueOf(strs[1]);
        size = floorWidth * floorHeight;
        return size;
    }
}
