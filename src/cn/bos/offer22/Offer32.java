package cn.bos.offer22;

/**
 * @classname: Offer32
 * @description: TODO 类描述
 * @author: pyethel
 * @create: 2021/9/2 14:54
 */
public class Offer32 {
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frontNode = head, behindNode = head;
        for (int i = 0; i < k; i++) {
            frontNode = frontNode.next;
        }

        while (frontNode != null) {
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
