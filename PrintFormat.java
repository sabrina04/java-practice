import java.util.Scanner;

public class PrintFormat {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.printf("%-15s%03d%n", s1, x); //- for left align, 15 for length
		// 0 for leading zero, 3 for length
            }
            System.out.println("================================");

    }
}