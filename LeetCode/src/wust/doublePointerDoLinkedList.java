package wust;

import org.junit.Test;

import java.util.PriorityQueue;

public class doublePointerDoLinkedList {

    //dummy虚拟节点应用:合并两个有序链表
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //p需要用于遍历整个最终结果链表，因而若没有dummy节点或者其他指针的话，结果将无法返回
        //因而需要创建dummy节点作为头节点，让p来遍历其后所有节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy,p1 = l1,p2=l2;//一个指针用于记录最终链表，另外两个指针用于记录两个原始链表
        while(p1!=null&&p2!=null){
            if(p1.val>p2.val){
                p.next=p2;
                p2=p2.next;
            }else{
                p.next=p1;
                p1=p1.next;
            }
            p=p.next;
        }
        if(p1!=null){
            p.next=p1;
        }
        if(p2!=null){
            p.next=p2;
        }
        return dummy.next;
    }

    //dummy虚拟节点应用:给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    ListNode partition(ListNode head, int x){
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1=dummy1,p2=dummy2,p=head;
        while(p!=null){
            if(p.val<x){
                p1.next=p;
                p1=p1.next;
            }else{
                p2.next=p;
                p2=p2.next;
            }
            ListNode temp = p.next;
            p.next=null;
            p=temp;
        }
        p1.next=dummy2.next;
        return dummy1.next;
    }
    //dummy虚拟节点应用:给你一个链表数组，每个链表都已经按升序排列
    ListNode mergeKLists(ListNode[] lists){
        ListNode dummy = new ListNode(-1);
        ListNode p =dummy;//用于指向最小节点，以便将其下个节点返回列表中
        //自然排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a, b)->(a.val-b.val));
        for (ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            p.next=min;
            if(min.next!=null){
                pq.add(min.next);
            }
            p=p.next;
        }
        return dummy.next;
    }

    //dummy虚拟节点应用:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode x = findNthFromEnd(head, n + 1);
        //删除第x个节点
        x.next=x.next.next;
        return dummy.next;
    }

    //查找倒数节点
    private ListNode findNthFromEnd(ListNode head,int k){
        ListNode p1 = head;
        while(k>0){
            p1=p1.next;
            k--;
        }
        ListNode p2 = head;
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }


    //快慢指针的关键在于慢指针走K步，快指针走nK步，因而需要重点关注相差的(n-1)K步
    //快慢指针，对于偶数个节点，指针停留在中间前一个还是后一个自行设置，下面为后一个
    ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //快慢指针应用：链表是否有环K=k
    boolean hasCycle(ListNode head) {
        ListNode slow = head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    //快慢指针应用：如果链表中含有环，如何计算这个环的起点？K=k-m(m:第一次相遇点)
    ListNode cycleBegin(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while(fast!=slow){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //快慢指针应用：删除排序链表中的重复元素
    ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode fast=head,slow=head;
        while(fast!=null){
            if(fast.val!= slow.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast=fast.next;
        }
        slow.next=null;
        return head;
    }



    //左右指针：就是两个指针相向而行或者相背而行
    //两个链表是否相交:如果相交，算法应该返回相交的那个节点；如果没相交，则返回 null。
    ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA,p2=headB;
        /**
         * 最终弹出条件p1!=p2,有两种情况：
         * 1.遍历到两条链表的交点
         * 2.两个指针都遍历完一次headA和headB，因而p1、p2都指向空
         */
        while(p1!=p2){
            if(p1!=null)p1=p1.next;
            else p1=headB;
            if(p2!=null)p2=p2.next;
            else p2=headA;
        }
        return p1;
    }


}
