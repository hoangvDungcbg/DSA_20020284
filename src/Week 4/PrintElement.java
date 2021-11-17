package GIT.DSA_20020284.src.Week4;

public class PrintElement {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static void printLinkedList(SinglyLinkedListNode head) {
        while(head != null){

            System.out.println(head.data);
            head=head.next;
        }

    }
}