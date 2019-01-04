/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newheapsort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author User
 */
public class NewHeapSort {
    
        public static int[] createRandomIntArray(int size) {
        int[] answer = new int[size]; 
        Random generator = new Random();
        for(int index = 0; index < answer.length; index++) {
            answer[index] = generator.nextInt(100) + 1;
        }
        return answer;
    }
    
    public static int parent(int i){
        return (i-1)/2;
    }
    public static int leftChild(int i){ // index of left child
        return i*2+1;
    }
    public static int rightChild(int i){ //index of right child
        return i*2+2;
    }
    public static void swap(int[] A, int a, int b){//swaps within an array
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    public static void heapSort(int[] A, int size){
        for(int index = size/2-1;index>=0;index--){
            maxHeapify(A,index,size);
        }
        for(int n = size-1;n>=0;n--){
            swap(A,0,n);
            maxHeapify(A,0,n);
        }
    }
    public static void maxHeapify(int[]A, int i, int n){//n is the largest index evaluated
        int r = rightChild(i);
        int l = leftChild(i);
        int big = i;
        if(r<n&&A[i]<A[r]){
            big = r;
        }
        if(l<n&&A[big]<A[l]){
            big = l;
        }
        if(i!=big){
            swap(A,i,big);
            if(rightChild(big)<=n){
                maxHeapify(A, big, n);
            }
        }
        
    }
    public static void main(String[] args) {
        int[] arr = createRandomIntArray(20);
        System.out.println(Arrays.toString(arr));
        heapSort(arr,20);
        System.out.println(Arrays.toString(arr));
    }
    
}
