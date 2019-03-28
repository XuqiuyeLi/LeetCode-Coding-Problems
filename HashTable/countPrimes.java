class Solution {
    // I didn't get this question right
    // I was thinking a dp array to mark the number of primes before dp[i]
    
    // This solution from discussion to make all the not Prime true and count the false ones
     public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}