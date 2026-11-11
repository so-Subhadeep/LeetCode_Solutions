
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);

        long ans = common * Math.min(costBoth, cost1 + cost2);

        ans += (long) Math.max(0, need1 - need2) * Math.min(cost1, costBoth);

        ans += (long) Math.max(0, need2 - need1) * Math.min(cost2, costBoth);

        return ans;
    }
}
