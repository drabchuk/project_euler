package problems;

import math_lib.prime.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem204 {

    private static final int TYPE = 100;
    private static final int BOUND = 1000_000_000;
    private static ArrayList<Integer> primes;
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println(solve());
    }

    private static int solve() {
        return hammingNumbersCountOfType(TYPE, BOUND);
    }

    private static int hammingNumbersCountOfType(int type, int bound) {
        List<Integer> primesList = PrimeNumbers.primeNumbers(type);
        primes = new ArrayList<>(primesList);
        int[] node = new int[primes.size()];
        Arrays.fill(node, 0);
        dfs(node, 0, 0);
        return counter;
    }

    private static void dfs(int[] node, int cursor, long previousHemming) {
        int[] nextNode = new int[node.length];
        long h = 1;
        for (int i = 0; h <= BOUND; i++) {
            System.arraycopy(node, 0, nextNode, 0, node.length);
            nextNode[cursor] = i;
            System.out.println();
            for (int j = 0; j < node.length; j++) {
                System.out.print(nextNode[j] + " ");
            }
            System.out.println();
            h = hemming(nextNode);
            if (previousHemming != h && h <= BOUND) {
                counter++;
                previousHemming = h;
            }
            System.out.println(h);
            if (cursor == node.length - 1) {
                continue;
            } else {
                dfs(nextNode, cursor + 1, previousHemming);
            }
        }
    }

    private static long hemming(int[] pows) {
        long n = 1L;
        for (int i = 0; i < pows.length; i++) {
            n *= (long) Math.pow(primes.get(i), pows[i]);
        }
        return n;
    }

}
