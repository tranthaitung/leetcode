package com.demo.leetcode.linkedlist;

public class LinkedListSolutions {
    // Driver method
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merge = mergeTwoLists(l1,l2);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;

        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}

