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

        // this constructor is to set value to its respected node.
        Node(int value) {
            this.value = value;
        }
    }

    // this method is used to obtain the link list and print out each node(value),
    // using a temp node.
    public void printList() {
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

            // if its nots empty, whatever tail is pointing at, point it the new node, and
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
        // outside the iteration we make tail equal to pre and whatever tail is pointing
        // at, point to null. We decrement the length of the list by 1.
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
        // first edge case if the list in empty.
        if (length == 0)
            return null;

        // we create a temporary node and make it equal to head.
        Node temp = head;
        // we make the head node point to to the next node.
        head = head.next;

        // we make the node temp and point it to null to remove it from the list
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

    // this method allows us to obtain a node at a particular index.
    public Node get(int index) {

        // we want to check if we obtain an index withen the link list, its cannot be
        // less then 0 or greater then the length.
        if (index < 0 || index >= length) {
            return null;
        }
        // we dont use the tail or head to iterate in this method, so we create a
        // temporary node that goes through the list.
        Node temp = head;

        // we want to check a certain index in the link list, so we just create a
        // forloop and iterate with temp pointing to next.
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        // once we have a specific node that we want out of the loop, we just return it.
        return temp;

    }

    // this method is going to set (the value of a node) at a (particular index).
    public boolean set(int index, int value) {

        // we can create a temporary node and leverage it with the get method we
        // created.
        Node temp = get(index);

        // now the get method is going to do 2 things, if the index is out of range, it
        // will return null, otherwise its going to return a pointer to a node with the
        // set method value.
        if (temp != null) {
            temp.value = value;
            return true;
        }
        // if we did not find the index with the if statement, we return false.
        return false;
    }

    // this method allows us to set a node with a particular value at a particular
    // index.
    public boolean insert(int index, int value) {

        // edge case to check if the index is out of bounds.
        if (index < 0 || index > length) {
            return false;
        }

        // check to see if the index is at the start of the link list, if it is we can
        // use the prepend method to add a node there.
        if (index == 0) {
            prepend(value);
            return true;
        }

        // if its at the end, we can use the append method to set it there.
        if (index == length) {
            append(value);
            return true;
        }

        // if we wanna insert the the middle of the link list, we create a new node, and
        // create a temporary node with the get method of an index before it, (the index
        // - 1 means make the node we want behind another node).
        Node newNode = new Node(value);
        Node temp = get(index - 1);

        // we then make the new node point to our temporary node next pointer and make
        // the temp node our new nodecand increase the length by 1.
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    // this method allows us to remove a node at a specific index.
    public Node remove(int index) {

        // check to see if the node is withen bounds
        if (index < 0 || index > length)
            return null;

        // check if the node is at the beginning.
        if (index == 0)
            return removeFirst();

        // if it isnt in the beginning we check at the end of the link list.
        if (index == length - 1)
            return removeLast();

        // if we wanna remove in the middle, we create 2 temporary nodes, we dont want
        // to lose the link list while removing a specific node.
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;

    }

    // this method allows us to reverse a link list.
    public void reverse() {

        // we first create a temporary node pointing at head.
        Node temp = head;

        // and then we make the head point to tail, (this is needed to reverse the link
        // list).
        head = tail;

        // once head is set to tail, we now make tail point to temp.
        tail = temp;

        // we now create another temporary node called before point at null.
        Node before = null;

        // finally we make another temporary node called after and make it one step
        // ahead of temp.
        Node after = temp.next;

        // we want to iterate throught the link list, so we create a forloop.
        for (int i = 0; i < length; i++) {
            // inside the loop we always want to check that after is 1 step ahead of temp.
            after = temp.next;
            // we now make the pointer of temp point to before, which looks like this: null
            // <--- before <--- temp.
            temp.next = before;
            // we dont want to lose the link list so we make the before node point to temp.
            before = temp;
            // and we repeat this process by making temp equal to after.
            temp = after;

        }

    }

}