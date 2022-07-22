package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix2[0].length;
        int [][] nMatrix = new int[rows][columns];


        for(int nI = 0; nI < columns; nI++) {
            for (int i = 0; i < rows; i++) {
                int result = 0;
                for (int j = 0; j < matrix1[0].length; j++) {
                    result += matrix1[i][j] * matrix2[j][nI];
                }
                nMatrix[i][nI] = result;
                }

        }

        return nMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
