package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        System.out.print("Введите минимальное значение элемента: ");
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        System.out.print("Введите максимальное значение элемента: ");
        int max = sc.nextInt();
        System.out.print("Введите порядок матрицы: ");
        int order = sc.nextInt();
        int[][] matrix = new int[order][order];
        System.out.println();
        System.out.println("Изначальная матрица:");
        matrixGenerator(matrix, min, max);
        matrixShow(matrix);
        System.out.println("Матрица отсортированная по строкам:");
        SwapRows(matrix, order);
        System.out.println();
        System.out.println("Матрица отсортированная по столбцам:");
        SwapColums(matrix, order);
    }

    public static int[][] matrixGenerator(int[][] matrix, int min, int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * ((max - min) + 1)) + min;
            }
        }
        return matrix;
    }

    public static void matrixShow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void SwapRows(int[][] matrix, int order) {
        double[] avg = new double[order];
        double[] avg2 = new double[order];
        //вычисление средних значений строк
            for (int i = 0; i < matrix.length; i++) {
                double sred = 0;
                for (int j = 0; j < matrix[i].length; j++)
                    sred += matrix[i][j];
                sred = sred / order;
                avg[i] = sred;
                avg2[i] = avg[i];
        }
        int[][] clone = new int[order][order];

        //сортировка по возростанию массива avg2
        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < avg2.length-1; i++) {
                if(avg2[i] > avg2[i+1]){
                    isSorted = false;

                    buf = avg2[i];
                    avg2[i] = avg2[i+1];
                    avg2[i+1] = buf;
                }
            }
        }

        //сортировка и перенос в массив clone
        for(int c = 0;c< matrix.length;c++)
            for (int i = 0; i < matrix.length; i++) {
                if(avg2[c]==avg[i])
                    for (int j = 0; j < matrix[i].length; j++)
                        clone[c][j]=matrix[i][j];
            }
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone[i].length; j++) {
                System.out.print(clone[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void SwapColums(int[][] matrix, int order) {
        double[] avg = new double[order];
        double[] avg2 = new double[order];
        //вычисление средних значений строк
        for (int i = 0; i < matrix.length; i++) {
            double sred = 0;
            for (int j = 0; j < matrix[i].length; j++)
                sred += matrix[j][i];
            sred = sred / order;
            avg[i] = sred;
            avg2[i] = avg[i];
        }
        int[][] clone = new int[order][order];

        //сортировка по возростанию массива avg2
        boolean isSorted = false;
        double buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < avg2.length-1; i++) {
                if(avg2[i] > avg2[i+1]){
                    isSorted = false;

                    buf = avg2[i];
                    avg2[i] = avg2[i+1];
                    avg2[i+1] = buf;
                }
            }
        }

        //сортировка и перенос в массив clone
        for(int c = 0;c< matrix.length;c++)
            for (int i = 0; i < matrix.length; i++) {
                if(avg2[c]==avg[i])
                    for (int j = 0; j < matrix[i].length; j++)
                        clone[j][c]=matrix[j][i];
            }
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone[i].length; j++) {
                System.out.print(clone[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
















//Генератор случайных чисел в заданном диапазоне
    /*public static int randomNumber(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return (int) x;
    }*/