
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), ans, map);
        return ans;
    }

    void backtrack(String digits, int index, StringBuilder path,
                   List<String> ans, String[] map) {
        if (index == digits.length()) {
            ans.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, index + 1, path, ans, map);
            path.deleteCharAt(path.length() - 1);
        }
    }
}