package GIT.DSA_20020284.src.Week4;
public class insertNodeAtTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    if(head==null){
        head=new SinglyLinkedListNode(data);
        head.data=data;
    }
    else{
        SinglyLinkedListNode node=head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=new SinglyLinkedListNode(data);
        node.next.data=data;
    }
    return head;

}
}
