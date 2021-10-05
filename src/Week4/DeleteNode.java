package GIT.DSA_20020284.src.Week4;

public class DeleteNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        SinglyLinkedListNode p;
            if(position==0){
                llist=llist.next;
            }
            else{
                p=llist;
                for(int i=0;i<position-1;i++){
                    p=p.next;
                    
                }
                p.next=p.next.next;
            }
            return llist;
        }
    }
