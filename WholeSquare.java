// Java program to count squares between a and b
class CountSquares
{
    static int countSquares(int a, int b)
    {
        int cnt = 0; // Initialize result
 
        // Traverse through all numbers
        for (int i=a; i<=b; i++)
 
            // Check if current number 'i' is perfect
            // square
            for (int j=1; j*j<=i; j++)
                if (j*j==i)
                    cnt++;
        return cnt;
    }
}
 
// Driver Code
public class PerfectSquares
{
    public static void main(String[] args)
    {
        int a = 9, b = 25;
        CountSquares obj = new CountSquares();
        System.out.print("Count of squares is " +
                         obj.countSquares(a, b));
    }
}