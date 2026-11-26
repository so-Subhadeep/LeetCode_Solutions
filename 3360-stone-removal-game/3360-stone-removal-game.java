class Solution {
    public boolean canAliceWin(int n) {
        int turn = 10;
        boolean aliceTurn = true;

        while (n >= turn) {
            n -= turn;
            turn--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}