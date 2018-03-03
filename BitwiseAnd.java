import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BitwiseAnd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int max = 0;
            for(int j=1; j<=(n-1); j++){
                for(int m=j+1; m<=n; m++){
                    int temp = j&m;
                    if(temp>max && temp<k)
                        max = j&m;
                }
            }
            System.out.println(max);
        }
    }
}
