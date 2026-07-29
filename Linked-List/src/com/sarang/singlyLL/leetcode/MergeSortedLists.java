package com.sarang.singlyLL.leetcode;

public class MergeSortedLists {

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    // using extra space
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = new ListNode(100); // ans ka first (just for ref)
        ListNode temp = head;

        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                ListNode node = new ListNode(temp1.val);
                temp.next = node;
                temp = node;
                temp1 = temp1.next;
            }

            else if(temp1.val > temp2.val) {
                ListNode node = new ListNode(temp2.val);
                temp.next = node;
                temp = node;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) {
            temp.next = temp1;
        }

        if(temp2 != null) {
            temp.next = temp2;
        }

        return head.next;
    }

    // without using extra space (in-place)
    public static ListNode mergeTwoListsInPlace(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head = new ListNode(100); // ans ka first (just for ref)
        ListNode temp = head;

        while(temp1 != null && temp2 != null) {
            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }

            else if(temp1.val > temp2.val) {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null) {
            temp.next = temp1;
        }

        if(temp2 != null) {
            temp.next = temp2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;

        ListNode ans = mergeTwoLists(node1, node4);
        while(ans != null) {
            System.out.print(ans.val + "-->" );
            ans = ans.next;
        }

        System.out.println();

        ListNode ans2 = mergeTwoListsInPlace(node1, node4);
        while(ans2 != null) {
            System.out.print(ans2.val + "-->" );
            ans2 = ans2.next;
        }
    }
}
