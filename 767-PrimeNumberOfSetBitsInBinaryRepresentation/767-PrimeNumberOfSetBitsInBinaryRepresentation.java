// Last updated: 7/7/2026, 11:01:09 PM
class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        // Prime set bit counts up to 20
        Set<Integer> primes = Set.of(2,3,5,7,11,13,17,19);
        
        int count = 0;
        
        for(int i = left; i <= right; i++){
            int bits = Integer.bitCount(i);
            if(primes.contains(bits)){
                count++;
            }
        }
        
        return count;
    }
}