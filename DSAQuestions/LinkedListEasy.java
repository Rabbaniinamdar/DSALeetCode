class LinkedListEasy {
    Node head;
    int size;

    LinkedListEasy() {
        size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cuNode = head;
        while (cuNode.next != null) {
            cuNode = cuNode.next;
        }
        cuNode.next = newNode;
    }

    void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    void removeLast() {
        if (head == null || head.next == null) {
            return;
        }
        Node cuNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            cuNode = cuNode.next;
            lastNode = lastNode.next;
        }
        cuNode.next = null;
    }

    void display() {
        Node cuNode = head;
        while (cuNode != null) {
            System.out.print(cuNode.data + " ");
            cuNode = cuNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedListEasy ll = new LinkedListEasy();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(8);
        ll.display();
        ll.removeFirst();
        ll.display();
        ll.removeLast();
        ll.display();

    }
}
