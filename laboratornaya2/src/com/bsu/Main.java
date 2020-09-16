package com.bsu;

import java.security.InvalidParameterException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter rows: ");
            int rows = scanner.nextInt();
            if (rows <= 0) {
                throw new InvalidParameterException("should be more than 0");
            }

            System.out.println("Enter columns: ");
            int columns = scanner.nextInt();
            if (columns <= 0) {
                throw new InvalidParameterException("should be more than 0");
            }


            int[][] matrix = new int[rows][columns];

            for (int rowsCount = 0; rowsCount < rows; rowsCount++) {
                for (int columnsCount = 0; columnsCount < columns; columnsCount++) {
                    matrix[rowsCount][columnsCount] = randomNumbersInRange(0, 20);
                }
            }
            matrixView(matrix);
            System.out.println("sort and transformed matrix");
            int answer = maxNumberTwoTimes(matrix, rows, columns);
            System.out.println("the answer");
            System.out.println(answer);
        }
    }

    private static int[] sortAndTransferMatrix(int[][] matrix, int rows, int columns) {
        int rac = 0;
        int[] copyOfMatrix = new int[rows * columns];
        //transform matrix
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                copyOfMatrix[rac] = matrix[i][j];
                rac++;
            }
        }
        //sort
        for (int i = rows * columns - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (copyOfMatrix[j] > copyOfMatrix[j + 1]) {
                    int tmp = copyOfMatrix[j];
                    copyOfMatrix[j] = copyOfMatrix[j + 1];
                    copyOfMatrix[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < rows * columns; ++i) {
            System.out.print(copyOfMatrix[i] + " ");
        }
        System.out.println();
        return copyOfMatrix;
    }

    public static int maxNumberTwoTimes(int[][] matrix, int rows, int columns) {
        int[] copyOfMatrix = sortAndTransferMatrix(matrix, rows, columns);
        boolean gotAns = false;
        int ans = 5228;
        int count = 1;
        for (int i = rows * columns - 2; i >= 0; --i) {
            if (copyOfMatrix[i] == copyOfMatrix[i + 1]) {
                count++;
            }
            else {
                if (count == 2 && !gotAns) {
                    gotAns = true;
                    ans = copyOfMatrix[i + 1];
                }
                count = 1;
            }
        }
        if (count == 2 && !gotAns) {
            gotAns = true;
            ans = copyOfMatrix[0];
        }
        if (!gotAns) {
            System.out.println("there is no only 2 max numbers");
        }
        return ans;
    }

    private static void arrayCopy(int[][] Source, int[][] Destination) {
        for (int i = 0; i < Source.length; i++) {
            System.arraycopy(Source[i], 0, Destination[i], 0, Source[i].length);
        }
    }

    private static int randomNumbersInRange(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private static void matrixView(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}