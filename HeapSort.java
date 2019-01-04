/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

/**
 *
 * @author User
 */
public class HeapSort {
    public static double logBase2(int n){
           return Math.log(n)/Math.log(2);
    }
    public static int[] createRandomIntArray(int size) {
        int[] answer = new int[size]; 
        Random generator = new Random();
        for(int index = 0; index < answer.length; index++) {
            answer[index] = generator.nextInt(100) + 1;
        }
        return answer;
    }
    public static int leftChild(int i){ // index of left child
        return i*2+1;
    }
    public static int rightChild(int i){ //index of right child
        return i*2+2;
    }
    //parent(i) = (i-1)/2
    public static void swap(int[] A, int a, int b){//swaps within an array
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    public static int heapSort(int[] A, int size){
        int count = 0;
        for(int index = size/2-1;index>=0;index--){
            count = maxHeapify(A,index,size,count);
        }
        for(int n = size-1;n>=0;n--){
            swap(A,0,n); count++;
            count = maxHeapify(A,0,n,count);
        }
        return count;
    }
    public static int maxHeapify(int[]A, int i, int n, int c){//n is the largest index evaluated
        int r = rightChild(i);  c++; //c is the count
        int l = leftChild(i); c++;//I dont count the steps in rightChild or leftChild bc it is only one step
        int big = i;    c++;
        c++; //count for comparison
        if(r<n&&A[i]<A[r]){
            big = r; c++;
        }
        c++; //count for comparison
        if(l<n&&A[big]<A[l]){
            big = l; c++;
        }
        c++;//count for comparison
        if(i!=big){
            swap(A,i,big); c++; //I dont count the steps within swap
            if(rightChild(big)<=n){
                maxHeapify(A, big, n, c); c++;
            }
        }
        return c;  
    }
    public static void printLine(int size){
        String format = "%-10d%-13.3f%-15.3f%.4f%n"; //this is just to make it look nice
        //n     n*lgn   average     average/(n*lgn)   
        double nlgn = size * logBase2(size);
        long sum = 0;
        for(int i = 0; i<50;i++){
            int[] A = createRandomIntArray(size);
            int c = heapSort(A,size);
            sum+=c;
        }
        double avr = sum*1.0/50;
        double r = avr/nlgn;
        System.out.printf(format, size, nlgn, avr, r); 
    }
    public static void main(String[] args) {
        String format = "%-10s%-13s%-15s%s%n";
        System.out.printf(format, 'n', "n*lg(n)", "average", "ratio");
        printLine(10);
        printLine(100);
        printLine(1000);
        printLine(10000);
        printLine(100000);
    }
    
}