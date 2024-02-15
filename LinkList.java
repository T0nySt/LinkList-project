public class LinkList {
    private Node head;
    private Node tail;
    private int length;

    // a constructor that creates a link list.
    LinkList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // we created this class so we dont have to code a node each time we want to use
    // a method.
    class Node {
        int value;
        Node next;

        // this constructor is to set value to its respeted node.
        Node(int value) {
            this.value = value;
        }
    }

    // this method is used to obtain the link list and print out each node(value),
    // using a temp node.
    public void getList() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // these getters methods are useful to display the value of a typical node in
    // the link list to debug our code.
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("length: " + length);
    }

    // this method allows us to make a node at the end of the list.
    public void append(int value) {
        // creating a new node with a value
        Node newNode = new Node(value);

        // checking to see if the list is empty, if it is, make the the head node and
        // tail node point to the node we made.
        if (length == 0) {
            head = newNode;
            tail = newNode;

            // if its nots empty, whatever tail is pointing at, make it the new node, and
            // make tail the new node.
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        // because we increased the link list with a node, we have to update the length
        // by 1;
        length++;

    }

    // this method allows us to remove the last node in a link list.
    public Node removeLast() {
        // we check to see if the list in empty, if it is return null.
        if (length == 0)
            return null;
        // we create two temporary nodes, and make it point to a head node.
        Node temp = head;
        Node pre = head;

        // we want to iterate the link list until temp is pointing at to null. while its
        // iterating, make pre equal to temp.
        while (temp.next != null) {
            temp = temp.next;
            pre = temp;
        }
        // outside the iteration we make tail equal to pre and whatever tail in pointing
        // at to null and decrement the length of the list by 1.
        tail = pre;
        tail.next = null;
        length--;

        // we want to check again if the length of the list is 0, if it is make the head
        // and tail node point to null.
        if (length == 0) {
            head = null;
            tail = null;
        }
        // at the end of the method, just return the removed temp node.
        return temp;
    }

    // this method allows us to make a node at the start of the link list.
    public void prepend(int value) {

        // we create a node that we want to add.
        Node newNode = new Node(value);

        // we check if the length is empty, if it is, head and tail are equal to the new
        // node.
        if (length == 0) {
            head = newNode;
            tail = newNode;
            // if its not empty make the new node point to what head is, and make the head
            // the new node.
        } else {
            newNode.next = head;
            head = newNode;
        }
        // because we increased the length of the list we have to increment the length
        // by 1.
        length++;
    }

    // this method allows us to remove the first node in a list.
    public Node removeFirst() {
        // first edge case if the list in null.
        if (length == 0)
            return null;

        // we create a temporary node and make it equal to head.
        Node temp = head;
        // we make the head node point to to the next node.
        head = head.next;

        // we make the node temp is at and point it to null to remove it from the list
        temp.next = null;
        // we decrement the length of the list by 1.
        length--;

        // now this edge case if we have only 1 node in the list, because head.next is
        // null, and temp is null, which leaves tail point at a node.
        if (length == 0) {
            tail = null;
        }
        // we return the temp node at the end of the method.
        return temp;
    }

}