package com.algorithm;

/**
 * Created by Levy on 2017/1/20.
 */
public class AddTowListNode {
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        //l2.next = l3;
        //ListNode l4 = new ListNode(5);
        //ListNode l5 = new ListNode(6);
        //ListNode l6 = new ListNode(4);
        //l4.next = l5;
        //l5.next = l6;
        ListNode result = new AddTowListNode().addTwoNumbers(l1,l3);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){
            return null;
        }
        ListNode l1_head = l1;
        ListNode l2_head = l2;
        ListNode l1_tmp=null;
        ListNode l2_tmp=null;
        int tmp = 0;
        while (l1!=null&&l2!=null){
            l1_tmp = l1;
            l2_tmp = l2;
            int sum = l1.val+l2.val+tmp;
            if (sum>=10){
                tmp = 1;
            }else {
                tmp=0;
            }
            sum = sum%10;
            l1.val = l2.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null&&l2==null){
            if(tmp == 1) {
                addNode(l1_tmp);
            }
            return l1_head;
        }else if (l1==null){
            if (tmp==1){
                addNode(l2_tmp);
            }
            return l2_head;
        }else {
            if (tmp==1){
                addNode(l1_tmp);
            }
            return l1_head;
        }
    }

    private void addNode(ListNode l){
        if(l.next==null){
            l.next = new ListNode(1);
        }else {
            int sum = l.next.val+1;
            l.next.val = sum%10;
            if (sum ==10){
                addNode(l.next);
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}