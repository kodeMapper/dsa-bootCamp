public class Test {

    static boolean check(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(check(5));
    }
}


// we can reduce the time complexity of the above code by running the for loop till the square root of n
// we can use Measure-Command {java basics} to check the time taken by the code to run