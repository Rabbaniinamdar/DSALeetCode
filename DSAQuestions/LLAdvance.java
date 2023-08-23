class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        next = null;
    }
}

public class LLAdvance {
    public int intersection(Node listA, Node listB) {
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
        return tempA.val;
    }

    public Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Move one pointer to the head and then move both pointers at the same pace
        Node temp = head;
        while (slow != temp) {
            slow = slow.next;
            temp = temp.next;
        }
        return slow; // Node where the cycle starts
    }

    public static Node merge(Node list1, Node list2) {
        Node head = new Node(0);
        Node currNode = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }
            currNode = currNode.next;
        }
        if (list1 == null) {
            currNode.next = list2;
        } else {
            currNode.next = list1;
        }
        return head.next;
    }

    static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        Node secondHalf = middle.next;
        middle.next = null;

        Node sortedFirst = sortList(head);
        Node sortedSecond = sortList(secondHalf);
        return merge(sortedFirst, sortedSecond);
    }

    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    static Node rotatRight(Node head, int k) {
        int length = 0;
        Node cuNode = head;
        while (cuNode != null) {
            cuNode = cuNode.next;
            length++;
        }
        k = k % length;
        for (int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    static Node flattenLL(Node head) {
        head.next = flattenLL(head.next);
        head = merge(head, head.next);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(6);

        // Node head1 = new Node(5);
        // addTwoNumbers(head, head1);

        printList(head);
        rotatRight(head, 2);
        // merge(head, head1);
        // Node sortedList = sortList(head);
        printList(head);
    }
}
