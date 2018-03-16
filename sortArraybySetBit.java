import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
     
    static int total_one(int num)
    {
        int count_one = 0, temp;
        while(num != 0){
            temp = num & 1;
            if(temp == 1)
                count_one++;
            num >>= 1;
        }
        
        return count_one;
    }
    
    
    static int[] rearrange(int[] elements) {
        int result[] = Arrays.copyOf(elements, elements.length);
        
        for(int i=0; i<result.length-1; i++){
            for(int j=0; j<result.length-i-1; j++){
                if(total_one(result[j]) > total_one(result[j+1])){
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
                else if(total_one(result[j]) == total_one(result[j+1])){
                    if(result[j] > result[j+1]){
                        int temp = result[j];
                        result[j] = result[j+1];
                        result[j+1] = temp;
                    }
                }
            }
        }
        
        return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        n = Integer.parseInt(in.nextLine().trim());
        int[] elements = new int[n];
        int element;
        for (int i = 0; i < n; i++) {
            element = Integer.parseInt(in.nextLine().trim());
            elements[i] = element;
        }
        
        // call rearrange function
        int[] results = rearrange(elements);
        
        for (int i = 0; i < results.length; i++) {
            System.out.println(String.valueOf(results[i]));
        }
    }
}