
// we can run all methods inside the class main.
public class Main {
    public static void main(String[] args) {

        // we create a new link list.
        LinkList myLinklist = new LinkList(1);

        // and using the (myLinkList with the . next to list, we can call any method we
        // created).

        myLinklist.append(2);
        myLinklist.append(3);
        myLinklist.append(4);

        // myLinklist.reverse();

        myLinklist.printList();
    }

}