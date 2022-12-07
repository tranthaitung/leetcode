package com.example.leetcode.strings

fun strStr(haystack: String, needle: String): Int {
  val len = needle.length
  var endIndex = len

  for (i in 0..haystack.length - len) {
    val s: String = haystack.subSequence(i, endIndex++) as String
    if (s == needle) {
      return i
    }
  }
  return -1
}

fun findLongestCommonPrefix(strs: Array<String>): String {

  return ""
}