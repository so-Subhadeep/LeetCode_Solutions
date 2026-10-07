class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();

        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }

        dfs(s, 0, left, right, ans);

        return ans;
    }

    private void dfs(String s, int start, int leftRem,
                     int rightRem, List<String> ans) {

        if (leftRem == 0 && rightRem == 0) {
            if (isValid(s))
                ans.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Skip duplicate removals
            if (i > start && s.charAt(i) == s.charAt(i - 1))
                continue;

            // Remove '('
            if (leftRem > 0 && s.charAt(i) == '(') {
                String next = s.substring(0, i) + s.substring(i + 1);

                dfs(next, i, leftRem - 1, rightRem, ans);
            }

            // Remove ')'
            if (rightRem > 0 && s.charAt(i) == ')') {
                String next = s.substring(0, i) + s.substring(i + 1);

                dfs(next, i, leftRem, rightRem - 1, ans);
            }
        }
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else if (c == ')') {
                balance--;

                if (balance < 0)
                    return false;
            }
        }

        return balance == 0;
    }
}