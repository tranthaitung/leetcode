package com.example.leetcode.linkedlist

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.LinkedList
import javax.annotation.PostConstruct


//@Service
class LinkedListExample {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(LinkedListExample::class.java)
  }

  fun example(){
    val linked = LinkedList<String>()
    linked.add("tung")
    linked.get(0)

    val array = java.util.ArrayList<String>()
    array.add("tung")

    array.get(0)
  }


}