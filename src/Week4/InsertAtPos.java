package GIT.DSA_20020284.src.Week4;

public class InsertAtPos {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode n=new SinglyLinkedListNode(data);
            SinglyLinkedListNode h=llist;
            if(position==0){
                
                n.next=llist;
                return n; 
            }       
            int count=0;
            while(count<position-1){
                h=h.next;
                count++;
            }
            n.next=h.next; 
            h.next=n;
            return llist;
    
        }
}
