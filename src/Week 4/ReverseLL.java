package GIT.DSA_20020284.src.Week4;

public class ReverseLL {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
            SinglyLinkedListNode nex=null,prev=null;
            while(llist!=null){
                nex=llist.next;
                llist.next=prev;
                prev=llist;
                llist=nex;
            }
            llist=prev;
            return prev;
            
        }
    
}
