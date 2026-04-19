package practiceset.recursion;

public class CalculatePower {
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.out.println(calculate_power(x, n)%1000000007);
    }

    public static long calculate_power(int x, int n){
        //base case
        if(n==1)
            return x;

        if(n%2==0){
            return calculate_power(x, n/2) * calculate_power(x, n/2);
        } else{
            return calculate_power(x,n/2) * calculate_power(x,n/2) * x;
        }
    }
}
