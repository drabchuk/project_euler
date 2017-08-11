package problems;

public class Problem67 extends Problem18 {

    public static void main(String[] args) {
        ROWS = 100;
        Problem18 solver = new Problem67();
        solver.run();
    }

    @Override
    long solve() {
        for (int i = ROWS - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                long left = tree[i + 1][j];
                long right = tree[i + 1][j + 1];
                if (left > right) {
                    tree[i][j] += left;
                } else {
                    tree[i][j] += right;
                }
            }
        }
        return tree[0][0];
    }
}
