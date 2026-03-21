class Solution {

    lateinit var memo: IntArray

    fun numDecodings(s: String): Int {
        memo = IntArray(s.length+1){-1}
        val ans = solve(s, 0, s.length)
        return if(ans == -1) 0 else ans
    }

    fun solve(s: String, curr: Int, n: Int): Int {
        if(curr >= n) return 1

        if(memo[curr] != -1) return memo[curr]

        val ch = s[curr]
        if(ch == '0') return 0
        val nextCh = if(curr < n-1) s[curr+1] else 'N'

        val pickOne = if(nextCh != '0') solve(s, curr+1, n) else 0
        val pickTwo = if(nextCh != 'N' && ch <= '1' || ch == '2' && nextCh <= '6') solve(s, curr+2, n) else 0

        memo[curr] = pickOne + pickTwo
        return memo[curr]
    }
}