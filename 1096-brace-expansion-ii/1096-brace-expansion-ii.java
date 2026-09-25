class Solution {
    Set<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs(String s) {
        int r = s.indexOf('}');

        if (r == -1) {
            set.add(s);
            return;
        }

        int l = s.lastIndexOf('{', r);

        String left = s.substring(0, l);
        String right = s.substring(r + 1);

        String[] parts = s.substring(l + 1, r).split(",");

        for (String part : parts) {
            dfs(left + part + right);
        }
    }
}