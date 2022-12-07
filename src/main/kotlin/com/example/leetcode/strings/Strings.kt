package com.example.leetcode.strings

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct


//@Service
class Strings {
  //    @PostConstruct
  companion object {
    private val LOGGER = LoggerFactory.getLogger(Strings::class.java)
  }

  fun strStrInit() {
    val haystack = "a"
    val needle = "a"

    strStr(haystack, needle)
  }

//  @PostConstruct
  fun lengthOfLongestSubstring(): Int {
    val str = "dvdf"
    val seen = HashMap<Char, Int>()
    var start = 0
    var max = 0;

    for (end in str.toCharArray() .indices ){
      if (seen.containsKey(str[end])){
        start = start.coerceAtLeast(seen[str[end]]?.plus(1) ?: 1) // d (end = 2) start = max(0, 2) = 1
      }

      seen[str[end]] = end // d v (end = 1)
      max = max.coerceAtLeast(end - start + 1)

    }

    return max
  }

//  @PostConstruct
  fun validBracket(): Boolean {
    val s = "[({)]}"
    val stack = Stack<Char>()
    for (c in s.toCharArray()) {
      when (c){
        '(' -> stack.push(')')
        '{' -> stack.push('}')
        '[' -> stack.push(']')
        else -> {
          if (stack.isEmpty() || stack.pop() != c){
            return false;
          }
        }
      }
     }
    return stack.isEmpty()
  }

//  @PostConstruct
  fun largestNumber(): String {
    val num = arrayOf(3, 40, 34, 5, 9)
//    if (num == null || num.size === 0) return ""

    // Convert int array to String array, so we can sort later on

    // Convert int array to String array, so we can sort later on
    val s_num = arrayOfNulls<String>(num.size)
    for (i in num.indices) {
      s_num[i] = java.lang.String.valueOf(num[i])
    }

    // Comparator to decide which string should come first in concatenation
    val comp = Comparator<String?> { str1, str2 ->
      val s1 = str1 + str2
      val s2 = str2 + str1
      s2.compareTo(s1) // reverse order here, so we can do append() later
    }

    Arrays.sort(s_num, comp)
    // An extreme edge case by lc, say you have only a bunch of 0 in your int array
    // An extreme edge case by lc, say you have only a bunch of 0 in your int array
    if (s_num[0]!![0] == '0') return "0"

    val sb = StringBuilder()
    for (s in s_num) sb.append(s)

    return sb.toString()
  }


  fun longestCommonPrefix() {
    val s = arrayOf("flower,flow,flight")
    LOGGER.info(findLongestCommonPrefix(s))
  }
}