import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, index;

        Interval(int l, int r, int w, int index) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.index = index;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.r != b.r)
                return Integer.compare(a.r, b.r);

            return Integer.compare(a.l, b.l);
        });

        // right endpoints
        int[] rights = new int[n];

        for (int i = 0; i < n; i++) {
            rights[i] = arr[i].r;
        }

        // prev[i] = number of intervals that can come before i
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(rights, arr[i].l);
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {

            Interval cur = arr[i - 1];

            for (int k = 0; k <= 4; k++) {

                // Don't take current interval
                State notTake = dp[i - 1][k];

                State best = new State(
                    notTake.score,
                    new ArrayList<>(notTake.indices)
                );

                // Take current interval
                if (k > 0) {

                    State before = dp[prev[i - 1]][k - 1];

                    List<Integer> newList =
                        new ArrayList<>(before.indices);

                    newList.add(cur.index);

                    Collections.sort(newList);

                    State take = new State(
                        before.score + cur.w,
                        newList
                    );

                    if (better(take, best)) {
                        best = take;
                    }
                }

                dp[i][k] = best;
            }
        }

        List<Integer> answer = dp[n][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // Find number of intervals whose right endpoint < left
    static int findPrevious(int[] rights, int left) {

        int lo = 0;
        int hi = rights.length;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (rights[mid] < left) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    static boolean better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score;
        }

        return lexicographicallySmaller(a.indices, b.indices);
    }

    static boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}