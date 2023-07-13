public class BinTree {

    public static void main(String[] args) {
        BinTree tree = new BinTree();

        // Добавление элементов
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);

        // Вывод структуры дерева до поворота
        System.out.println("Дерево до поворота:");
        printTreeStructure(tree.root);

        // Выполнение поворота
        tree.root = tree.rotateRight(tree.root);

        // Вывод структуры дерева после поворота
        System.out.println("Дерево после поворота:");
        printTreeStructure(tree.root);

    }

    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }

        Node node = addNode(root, value);
        if (node == null)
            return false;

        root = node;
        root.color = Color.BLACK;
        return true;
    }

    private Node addNode(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (node.value == value)
            return null;

        if (node.value > value)
            node.left = addNode(node.left, value);
        else
            node.right = addNode(node.right, value);

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }

    private void flipColors(Node node) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    private static void printTreeStructure(Node node) {
        if (node == null)
            return;

        System.out.println("Значение: " + node.value + ", цвет: " + node.color);
        if (node.left != null)
            System.out.println("Левый потомок: " + node.left.value);
        if (node.right != null)
            System.out.println("Правый потомок: " + node.right.value);

        printTreeStructure(node.left);
        printTreeStructure(node.right);

    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.RED;
        }

        Node(int _value) {
            this.value = _value;
            this.color = Color.RED;
        }
    }

    enum Color {RED, BLACK}
}