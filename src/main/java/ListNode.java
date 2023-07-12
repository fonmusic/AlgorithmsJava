public class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println("Source list:");
        printLinkedList(listNode);

        ListNode reversedHead = reverseLinkedList(listNode);

        System.out.println("Reversed list:");
        printLinkedList(reversedHead);

    }
}
