class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMedium {
    static Node head;
    int size;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void display() {
        Node cuNode = head;
        while (cuNode != null) {
            System.out.print(cuNode.data + " ");
            cuNode = cuNode.next;
        }
    }

    int size() {
        int ct = 0;
        Node cuNode = head;
        while (cuNode != null) {
            cuNode = cuNode.next;
            ct++;
        }
        return ct;
    }

    void getNFromStart(int n) {
        if (head.next == null) {
            return;
        }
        if (size() < n) {
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < n; i++) {
            cuNode = cuNode.next;
        }
        System.out.println(cuNode.data);
    }

    void getNFromLast(int n) {
        if (head.next == null) {
            return;
        }
        if (size() < n) {
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < size() - n; i++) {
            cuNode = cuNode.next;
        }
        System.out.println(cuNode.data);
    }

    void removeNFromStart(int n) {
        if (head == null) {
            return;
        }
        if (n >= size()) {
            return;
        }
        if (n == 0) {
            head = head.next;
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < n - 1; i++) {
            cuNode = cuNode.next;
        }
        cuNode.next = cuNode.next.next;
    }

    void removeNFromEnd(int n) {
        if (head == null) {
            return;
        }
        if (n >= size()) {
            return;
        }
        if (n == size()) {
            head = head.next;
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < size() - n - 1; i++) {
            cuNode = cuNode.next;
        }
        cuNode.next = cuNode.next.next;
    }

    public void getIndex(int idx) {
        Node cuNode = head;
        for (int i = 0; i < size(); i++) {
            if (i == idx) {
                System.out.println(cuNode.data);
                return;
            }
            cuNode = cuNode.next;
        }
    }

    void middleOfLL() {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    Node deleteMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    void reverseLL() {
        if (head == null && head.next == null) {
            return;
        }
        Node prevNode = null;
        Node curNode = head;

        while (curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        head = prevNode;
    }

    public Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = size();
        if (size < k) {
            return head;
        }
        Node prevNode = null;
        Node curNode = head;
        Node nextNode = null;
        int count = 0;
        while (curNode != null && count < k) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            count++;
        }
        if (nextNode != null && size - count >= k) {
            head.next = reverseKGroup(nextNode, k);
        } else {
            head.next = nextNode;
        }
        return prevNode;
    }

    public Node segregateEvenOdd() {
        if (head == null)
            return null;
        Node odd = head;
        Node even = head.next;
        Node ans = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = ans;
        return head;
    }

    public static int intersection(Node listA, Node listB) {
        Node tempA = listA;
        Node tempB = listB;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        tempA = listA;
        tempB = listB;
        if (lenA > lenB) {
            int m = lenA - lenB;
            for (int i = 0; i < m; i++) {
                tempA = tempA.next;
            }
        } else {
            int n = lenB - lenA;
            for (int i = 0; i < n; i++) {
                tempB = tempB.next;
            }
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA.data;
    }

    public static void main(String[] args) {
        LinkedListMedium ll = new LinkedListMedium();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.display();
        System.out.println();
        // ll.reverseKGroup(head, 2);
        ll.segregateEvenOdd();
        // ll.reverseKGroup(head.next, 0);
        ll.display();
        // LinkedListMedium.display();
        // sort(LinkedListMedium.head);
        // System.out.println();
        // LinkedListMedium.display();

    }
}