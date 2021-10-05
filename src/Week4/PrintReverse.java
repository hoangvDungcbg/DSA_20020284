package GIT.DSA_20020284.src.Week4;

public class PrintReverse {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
            SinglyLinkedListNode p=llist;
            SinglyLinkedListNode nex=null,prev=null;
            while(p!=null){
                nex=p.next;
                p.next=prev;
                prev=p;
                p=nex;
            }
        llist=prev;
        while(llist!=null){
            System.out.println(llist.data);
            llist=llist.next;
        }    
        }
    
}
