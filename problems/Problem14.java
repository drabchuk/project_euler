package problems;

import java.util.*;

public class Problem14 {

    public static final int BOUND = 1000000;

    private static HashMap<Integer, Integer> pathLengthMap = new HashMap<>();
    private static int maxPath = 0;
    private static int maxPathFrom = 0;

    public static void main(String[] args) {
        //init();
        //Set<Integer> nodes = pathLengthMap.keySet();
        //System.out.println(solve());
        System.out.println(solveSimple());
    }

    private static int solveSimple() {
        int max = 0;
        int maxNumber = 1;
        for (int i = 1; i < BOUND; i++) {
            int count = 0;
            int val = i;
            while(val != 1) {
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

    private static void init() {
        int treeNodeValueBound = Integer.MAX_VALUE >> 1;
        pathLengthMap.put(1, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int i = 0;
        while (i++ < 100_000_000) {
            int node = queue.remove();
            int nextLength = pathLengthMap.get(node) + 1;
            if (node < treeNodeValueBound) {
                int next = node << 1;
                queue.add(next);
                pathLengthMap.put(next, nextLength);
            }
            if (node % 6 == 4) {
                int next1 = (node - 1) / 3;
                pathLengthMap.put(next1, nextLength);
                queue.add(next1);
            }
        }
    }

    private static int solve() {
        for (int i = 1; i < BOUND; i++) {
            int path = path(i);
            //System.out.println(i + " " + path);
        }
        return maxPathFrom;
    }

    private static int path(int from) {
        if (pathLengthMap.containsKey(from)) {
            return pathLengthMap.get(from);
        } else {
            int next = next(from);
            int path = path(next) + 1;
            pathLengthMap.put(from, path);
            if (maxPath < path && next < BOUND) {
                maxPath = path;
                maxPathFrom = next;
            }
            return path;
        }
    }

    private static int next(int n) {
        return ((n & 1) == 1) ? 3 * n + 1 : n >> 1;
    }

}
