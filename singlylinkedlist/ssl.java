class ssl{
    public static class Node{
        String value;
        Node next;

        public Node(String x){
            value = x;
            next = null;
        }
    }

    public static class SinglyLinkedList{

        public static Node createList(){
            // Create a list of nodes A->B->C->D->E->F
            Node a = new Node("A");
            Node b = new Node("B");
            Node c = new Node("C");
            Node d = new Node("D");
            Node e = new Node("E");
            Node f = new Node("F");

            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
            e.next = f;

            return a;
        }

        // Note that the variable "nodeList" actually is only the head
        public static String getValue(Node nodeList, String val){ 
            if (nodeList.value.equals(val)){
                return nodeList.value;
            }
            while(!nodeList.value.equals(val) && nodeList.next != null){
                nodeList = nodeList.next;
                if (nodeList.value.equals(val)){
                    return nodeList.value;
                }
            }
            return "This node does not exist.";
        }

        public static void insert(Node nodeList, String newNode){
            Node head = nodeList;
            while(head.next != null){
                head = head.next;
            }
            head.next = new Node(newNode);
            System.out.printf("You inserted a new node: ", head.next.value);
        }
    }

    public static void main(String[] args){
        Node head = SinglyLinkedList.createList();
        System.out.println(SinglyLinkedList.getValue(head, "A"));
        System.out.println(SinglyLinkedList.getValue(head, "H"));
        SinglyLinkedList.insert(head, "H");
        System.out.println(SinglyLinkedList.getValue(head, "H")); // fix needed, no output shown
    }
}