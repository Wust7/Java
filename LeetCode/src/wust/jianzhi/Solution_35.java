package wust.jianzhi;

public class Solution_35 {
    public static void main(String[] args) {
        Node head = new Node(3);
        Node N1 = new Node(2);
        Node N2 = new Node(1);
        head.random = null;
        head.next = N1;
        N1.next = N2;
        N2.next = null;
        N1.random = head;
        N2.random = null;

        Node endHead = new Node(0);
        Node p = head;
        Node q = endHead;
        while(p!=null){
            Node node = new Node(p.val);
            q.next = node;
            p = p.next;
            q = q.next;
        }
        p = head;
        while(p!=null){

//            for(int i =0;)
        }
    }
}
