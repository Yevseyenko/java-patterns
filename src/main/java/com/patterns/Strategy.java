package com.patterns;

import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        c.setStrategy(new SelectingSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11, 4, 2, 7, 8, 54};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr1);

        int[] arr2 = {3, -8, 2, 0, 33, 1, 3, 2};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);
    }
}
//Changing of states goes with setting client from outside
// watch State pattern
//Context
class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting");
        System.out.println("to:\t" + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

class SelectingSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Selecting sorting");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int i = barrier + 1; i < arr.length - 1; i++) {
                if (arr[i] < arr[barrier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Insertinging sorting");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}
