import java.math.BigInteger;
import java.util.Scanner;

public class LargeFactorial {

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();
        
        BigInteger factorialResult = factorial(number);
        
        System.out.println("Factorial of " + number + " is: ");
        System.out.println(factorialResult);
        
        scanner.close();

    }
}