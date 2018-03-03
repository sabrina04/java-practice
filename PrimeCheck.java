import java.io.*;
import java.util.*;

public class PrimeCheck {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        int [] n = new int[testcase];
        boolean is_prime = true;
        for(int i=0; i<testcase; i++)
            n[i] = scan.nextInt();
        for(int j=0; j<testcase; j++){
            if(n[j]==2)  is_prime = true;
            else if (n[j]==1 || n[j]%2==0) {
                is_prime = false;
            }
            else{
                //if not, then just check the odds
                for(int i=3; (i*i)<=n[j]; i+=2) {
                    if(n[j]%i==0){
                        is_prime = false;
                        break;
                    }
                }
            }
            if(is_prime)   System.out.println("Prime");
            else{
                System.out.println("Not prime");
                is_prime = true;
            }
        }
    }
}