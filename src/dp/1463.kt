package dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

private class Solution1463 {
    fun solution(n: Int) : Int {
        val dp = Array<Int>(n + 5) { 0 }
        dp[1] = 0
        dp[2] = 1
        dp[3] = 1

        if(n<4) return dp[n]

        for (i in 4..n) {


            val a = if (divByThree(i)) {
                1 + dp[i/3]
            } else MAX

            val b = if(divByTwo(i)) {
                1 + dp[i/2]
            } else MAX

            val c = 1 + dp[i-1]

            dp[i] = min(a,b)
            dp[i] = min(dp[i],c)

        }

        return dp[n]
    }

    companion object {
        val divByThree: (Int) -> Boolean = { n -> 0==(n % 3) }
        val divByTwo: (Int) -> Boolean = { n -> 0==(n%2) }
        const val MAX = Int.MAX_VALUE
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val st = StringTokenizer(input, " ")
    val n = Integer.parseInt(st.nextToken())

    val solution = Solution1463()
    println(solution.solution(n))

}