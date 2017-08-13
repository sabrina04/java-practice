import java.util.*;
import java.io.*;
import java.lang.Integer;

class HashMapExample{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
        HashMap hm = new HashMap();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            hm.put(name,new Integer(phone));
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            Object found = hm.get(s);
            if(found!=null)   System.out.println(s+"="+found);
            else System.out.println("Not found");
        }
        in.close();
    }
}