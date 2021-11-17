package GIT.DSA_20020284.src.Week4;

public class GetValue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode node = head; 
        SinglyLinkedListNode result = head;
        for (int i=0; i<=positionFromTail; i++){
            node = node.next;
        }

        while (node.next != null) {
            node = node.next;
            result = result.next;
        }

        return result.data;
    }
}