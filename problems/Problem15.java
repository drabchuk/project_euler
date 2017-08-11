package problems;

public final class Problem15 {

    public static final int N = 20;

    private static long count;
    private static final int Nminus1 = N - 1;

    public static final void main(String[] args) {

        dfs(0, 0);
        System.out.println(count);

    }

    private static final void dfs(int x, int y) {
        if (x < Nminus1) {
            dfs(x + 1, y);
            if (y < N - 1) {
                dfs(x, y + 1);
            }
        } else {
            if (y < Nminus1) {
                dfs(x, y + 1);
            } else {
                count++;
            }
        }
    }


}
