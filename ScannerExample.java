import java.util.*;
import java.io.*;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c); 
 /*       
        int d=0,e=0,f=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = br.readLine();
            d = Integer.parseInt(s);
            s = br.readLine();
            e = Integer.parseInt(s);
            s = br.readLine();
            f = Integer.parseInt(s);
        }   
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);  */
    }
}