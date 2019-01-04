package insertionsort;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class InsertionSort {
    public static int[] createRandomIntArray( int size) {
    int[] answer = new int[ size];
    Random generator = new Random();
    for( int index = 0; index < answer.length; index++) {
        answer[index] = generator.nextInt(100) + 1;
    }
    return answer;
}
    public static int insertionSort(int[] arr){
        int counter = 0;
        for(int i = 1; i< arr.length; i++){
            int key = arr[i]; counter++;
            int j = i-1; counter++;
            while(j>=0 && key<arr[j]){
                arr[j+1] = arr[j]; counter++;
                j--; counter++;
            }
            arr[j+1] = key;  counter++;
        }
        return counter;
    }
    public static void PrintLine(int n){
        long sqr = n*n;
        String format = "%-10d%-10d%-20.2f%f%n"; //this is just to make it look nice
        long sum = 0;
        for(int i = 0; i<50;i++){
            int[] A = createRandomIntArray(n);
            int c = insertionSort(A);
            sum+=c;
        }
        double avr = sum/50; //finds average of all 50 trials of insertion sort
        double r = avr/(n*n); //ratio of average number of steps and n
        System.out.printf(format, n, sqr, avr, r);
    }
    public static void main(String[] args) {
       String format = "%-10s%-10s%-20s%s%n"; 
       System.out.printf(format, 'n', "n^2", "average", "ratio");
       PrintLine(10);
       PrintLine(100);
       PrintLine(1000);
       PrintLine(10000);
    }
    
}
