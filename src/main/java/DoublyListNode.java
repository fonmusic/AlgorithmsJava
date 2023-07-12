public class DoublyListNode {
    int value;
    DoublyListNode prev;
    DoublyListNode next;

    DoublyListNode(int value) {
        this.value = value;
    }

    public static DoublyListNode reverseDoublyLinkedList(DoublyListNode head) {
        DoublyListNode current = head;
        DoublyListNode newHead = null;

        while (current != null) {
            DoublyListNode next = current.next;
            current.next = current.prev;
            current.prev = next;

            newHead = current;
            current = next;
        }

        return newHead;
    }

    private static void printDoublyLinkedList(DoublyListNode head) {
        DoublyListNode current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DoublyListNode head = new DoublyListNode(1);
        head.next = new DoublyListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DoublyListNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DoublyListNode(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Source list:");
        printDoublyLinkedList(head);

        DoublyListNode reversedHead = reverseDoublyLinkedList(head);

        System.out.println("Reversed list:");
        printDoublyLinkedList(reversedHead);
    }
}
