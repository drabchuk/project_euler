package problems;

import math_lib.prime.PrimeNumbers;

import java.util.Arrays;
import java.util.List;

public class Problem204 {

    private static final int TYPE = 5;
    private static final int BOUND = 100_000_000;

    public static void main(String[] args) {
        System.out.println(solve());
    }

    private static int solve() {
        return hammingNumbersCountOfType(TYPE, BOUND);
    }

    private static int hammingNumbersCountOfType(int type, int bound) {
        List<Integer> primes = PrimeNumbers.primeNumbers(type);
        int[] node = new int[type];
        Arrays.fill(node, 0);
        return 0;
    }

    private static void dfs(int[] node) {
        System.out.println();
        for (int i = 0; i < node.length; i++) {
            System.out.print(node[i] + " ");
        }
        int[] nextNode = new int[node.length];
        for (int i = 0; i < node.length; i++) {
            System.arraycopy(node, 0, nextNode, 0, node.length);
            nextNode[i]++;
            if (nextNode[i] > 4) {
                return;
            } else {
                dfs(nextNode);
            }
        }
    }

}
