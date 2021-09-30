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
