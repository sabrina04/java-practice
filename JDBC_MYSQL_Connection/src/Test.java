import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    String S = "Forget  CVs..Save time . x x";
			String[] arr = S.split("\\.|\\?|!");
	        int size = arr.length;
	        int[] count = new int[size];
	        
	        for(int i=0; i<size; i++){
	            String[] temp = arr[i].trim().split("\\s+");    
	            count[i] = temp.length;
	        }
	        
	        Arrays.sort(count);
	        System.out.println(count[size-1]);
	}

}
