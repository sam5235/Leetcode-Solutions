class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long left = Integer.MAX_VALUE, right = k;
        for (int station : stations) {
            right += station;
            left = Math.min(left, station);
        }

        while (left <= right) {
            long mid = (left + right) >> 1;
            if (helper_2(Arrays.copyOf(stations, stations.length), r, k, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    //Time: O(R + N); Space: O(1)
    private boolean helper_2(int[] stations, int r, int k, long x){
        long res = 0, used = 0;
        for (int i = 0; i < r; i++)
            res += stations[i];

        for (int i = 0; i < stations.length && k >= used; i++) {
            if (i + r < stations.length) res += stations[i + r];
            if (i - r > 0) res -= stations[i - r - 1];

            long diff = Math.max(0, x - res);
            res += diff;
            stations[Math.min(stations.length - 1, i + r)] += diff;
            used += diff;
        }
        return k >= used;
    }
}
