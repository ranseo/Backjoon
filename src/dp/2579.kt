package dp

import jdk.internal.util.xml.impl.Input
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

class Solution2579() {
    fun solution(n: Int, scores: IntArray) : Int {
        val dp = Array(n+3){0}

        dp[0] = scores[0]
        dp[1] = scores[1]
        if(n<2) return dp[n]
        dp[2] = scores[2]+scores[1]


        for(i in 3..n){
            dp[i] = max(scores[i]+scores[i-1]+dp[i-3], scores[i]+dp[i-2])
        }

        return dp[n]
    }
}

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    val solution = Solution2579()
    var n = 0
    var arr = intArrayOf(0)
    n = br.readLine().toInt()
    repeat(n) {
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val x = Integer.parseInt(st.nextToken())
        arr += intArrayOf(x)
    }

//    arr.forEach {
//        print("$it ")
//    }

    println(solution.solution(n,arr))

}