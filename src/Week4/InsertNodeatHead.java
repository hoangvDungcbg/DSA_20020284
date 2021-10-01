static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode node=new SinglyLinkedListNode(data);
    node.next=llist;
    llist=node;
    return llist;
    

}