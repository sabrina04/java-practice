import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PatternMatcher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String email_regex = ".+@gmail\\.com$";
        Pattern p = Pattern.compile(email_regex);
        Matcher m;
        List<String> l = new ArrayList<String>();
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            m = p.matcher(emailID);
            if(m.find())
                l.add(firstName);
        }
        Collections.sort(l);
        for(String s : l)
            System.out.println(s);
    }
}
