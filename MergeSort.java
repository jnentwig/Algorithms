/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Random;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author User
 */
public class MergeSort {
	public static void mSort(int arr[], int l, int r){
		if(l < r){
			int m = (l+r)/2;
			mSort(arr, l ,m);
			mSort(arr, m+1, r);
			merge(arr, l, m , r);
		}
	} 
	public static void merge(int arr[], int l, int m, int r){
		int n1 = m - l + 1; 
		int n2 =  r - m; 
		/* create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];
		/* Copy data to temp arrays L[] and R[] */
		for(int i = 0; i < n1; i++)
			L[i] = arr[l+i];
		for(int j = 0; j < n2; j++)
			R[j] = arr[m+1+j];
		/* Merge the temp arrays back into arr[l..r]*/
		int i = 0; // Initial index of first subarray 
		int j = 0; // Initial index of second subarray 
		int k = l; // Initial index of merged subarray 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy the remaining elements of L[], if there 
		   are any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy the remaining elements of R[], if there 
		   are any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	}
	public static int[] createRandomIntArray( int size) {
    int[] answer = new int[ size]; 
    Random generator = new Random();
    for( int index = 0; index < answer.length; index++) {
        answer[index] = generator.nextInt(100) + 1;
    }
    return answer;
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[] A = createRandomIntArray(10);
		System.out.println(Arrays.toString(A));
		mSort(A,0,9);
		System.out.println(Arrays.toString(A));
	}
}
