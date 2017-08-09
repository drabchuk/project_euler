package problems;

import java.util.*;

public class Problem14Simple {

    public static final long BOUND = 1000000;

    public static void main(String[] args) {
        System.out.println(solveSimple());
    }

    private static long solveSimple() {
        long max = 0;
        long maxNumber = 1;
        for (long i = 1L; i < BOUND; i++) {
            long count = 0L;
            long val = i;
            while(val != 1L) {
                val = next(val);
                count++;
            }
            if (count > max) {
                max = count;
                maxNumber = i;
            }
        }
        return maxNumber;
    }
    private static long next(long n) {
        return ((n & 1L) == 1L) ? 3L * n + 1L : n >> 1L;
    }

}
