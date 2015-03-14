package org.sk.benchmarkapp;

/**
 * Created by sk on 21-01-2015.
 */
public class ArrayMethods {

    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {

            array[i] = (int) (Math.random() * 100);

        }
        return array;

    }

    public int[] generateBestArray(int size) {

        int [] array = new int[size];
        for(int i=0;i<array.length;i++){
            array[i] = i+1;

        }
        return array;

    }

    public int[] generateWorstArray(int size) {

        int[] array = new int[size];
        int last = size;
        for (int i = 0; i < array.length; i++) {
            array[i] = last;
            last--;

        }
        return array;

    }

    public int[] cloneArray(int[] array){

        int[] clone = new int[array.length];
        int j=0;
        for(int i=0;i<clone.length;i++){
            clone[i] = array[j];
            j++;
        }
        return clone;

    }

    public int[] insertionSort(int [] array) {

        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;

        }
        return array;
    }

    public int[] selectionSort(int [] array) {

        for(int i=0;i<array.length-1;i++){
            int min = i;
            for(int j=i+1;j<array.length;j++) {
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;

        }
        return array;
    }


    public int[] bubbleSort(int[] array) {


        for (int pass=1;pass<=array.length;pass++) {
            for (int i=0;i<array.length-pass;i++) {

                if (array[i] > array[i+1]) {
                    int temp = array[i+1];
                    array[i+1]=array[i];
                    array[i]=temp;
                }
            }

        }
        return array;
    }

}
