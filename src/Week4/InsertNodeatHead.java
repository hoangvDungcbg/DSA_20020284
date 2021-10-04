package GIT.DSA_20020284.src.Week4;
public class insertNodeAtHead {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode node=new SinglyLinkedListNode(data);
    node.next=llist;
    llist=node;
    return llist;
    

}
}