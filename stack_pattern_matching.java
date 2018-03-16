import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] result =  new int[expressions.length];
        Stack<Character> s = new Stack<Character>();
        int i,j, max_replacement;
        
        for(i=0; i<expressions.length; i++){
            max_replacement = maxReplacements[i];
            for(j=0; j<expressions[i].length(); j++){
                
                if(expressions[i].charAt(j) == '<')
                    s.push(expressions[i].charAt(j));
                    
                else if(expressions[i].charAt(j) == '>'){
                    if(!s.isEmpty()){
                        char temp = s.pop();
                        if(temp != '<'){
                            if(max_replacement != 0)
                                max_replacement -= 1;
                            else{
                                result[i] = 0;
                                break;
                            }
                        }
                    }
                    else{
                        if(max_replacement != 0)
                                max_replacement -= 1;
                            else{
                                result[i] = 0;
                                break;
                            }
                    }
                }
            }
            
            if(j==expressions[i].length() && s.isEmpty())
                result[i] = 1;
            else{
                result[i] = 0;
                while(!s.isEmpty())
                    s.pop();
            }
        }
        return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
     public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] res;
        
        int _expressions_size = 0;
        _expressions_size = Integer.parseInt(in.nextLine().trim());
        String[] _expressions = new String[_expressions_size];
        String _expressions_item;
        for (int _expressions_i = 0; _expressions_i < _expressions_size; _expressions_i++) {
            try {
                _expressions_item = in.nextLine();
            } catch (Exception e) {
                _expressions_item = null;
            }
            _expressions[_expressions_i] = _expressions_item;
        }
        
        int _maxReplacements_size = 0;
        _maxReplacements_size = Integer.parseInt(in.nextLine().trim());
        int[] _maxReplacements = new int[_maxReplacements_size];
        int _maxReplacements_item;
        for (int _maxReplacements_i = 0; _maxReplacements_i < _maxReplacements_size; _maxReplacements_i++) {
            _maxReplacements_item = Integer.parseInt(in.nextLine().trim());
            _maxReplacements[_maxReplacements_i] = _maxReplacements_item;
        }
        
        res = balancedOrNot(_expressions, _maxReplacements);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
}
