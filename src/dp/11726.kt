package dp

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.reflect.KProperty

class Memorize<T, R>(val func: (T) -> R) {
    private val cache = mutableMapOf<T, R>()
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = { n: T ->
        cache.getOrPut(n) { func(n) }
    }
}

class Soultion11726 {
    fun solution(n:Int) : Int {
        val dp = Array(n+1){0.toBigInteger()}
        dp[0] = 0.toBigInteger()
        dp[1] = 1.toBigInteger()
        dp[2] = 2.toBigInteger()

        if(n>2)
            for(i in 3..n) {
                dp[i] = dp[i-1] + dp[i-2]
            }

        return (dp[n] % 10007.toBigInteger()).toInt()

    }

}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val st = StringTokenizer(input, " ")
    val n = Integer.parseInt(st.nextToken())

    val solution = Soultion11726()

    println(solution.solution(n))
}
