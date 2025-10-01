package com.sarang;
/*
    find all prime numbers <= n (40)
    Approach --> a array contains boolean values for num < n (true means not prime, false means prime).
    then we will modify the array according to the prime check logic modify the boolean values accordingly.
    if we find a prime number, then convert all its multiples as true (logic in notebook)
    All the remaining FALSE's in the array are the primes
 */
public class Sieve {

    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n+1];
        sieve(n, primes);
    }

    // false in array means n is prime
    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i*i <= n ; i++) {
            if(primes[i] == false) {
                for (int j = i*2; j <= n; j=j+i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if(primes[i] == false) {
                System.out.print(i + " ");
            }
        }
    }
}
