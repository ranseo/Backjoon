package dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Solution9095{
    fun solution(n:Int):Int {
        val dp = Array<Int>(4+n){0}
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        if(n<4) return dp[n]
        for(i in 4..n) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
        }
        return dp[n]
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))


    val solution = Solution9095()

    repeat(br.readLine().toInt()) {
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val n = Integer.parseInt(st.nextToken())
        println(solution.solution(n))
    }


}