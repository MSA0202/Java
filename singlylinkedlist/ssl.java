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

        public static int len(Node nodeList){
            int currSize = 0;

            if(nodeList == null){
                return currSize;
            }
            
            while(nodeList != null){
                currSize++;
                nodeList = nodeList.next;
            }
            return currSize;
        }

        public static void insert(Node nodeList, String newNode){
            Node head = nodeList;
            while(head.next != null){
                head = head.next;
            }
            head.next = new Node(newNode);
            System.out.printf("You inserted a new node: %s\n", head.next.value);
        }

        public static void insertAt(Node nodeList, String newNode, int position){
            // 1->2->3->null
            // 0, 1, 2, out of bounds
            Node head = nodeList;
            int currentIndex = 0;
            Node nodeToInsert = new Node(newNode);

            if(position < 0 || position >= len(nodeList)){
                System.out.println("Out of bounds.");
            }

            while(currentIndex != position - 1){
                head = head.next;
                currentIndex++;
            }
            nodeToInsert.next = head.next;
            head.next = nodeToInsert;
            System.out.printf("You inserted a new node %s at %s",newNode, position);
            System.out.println();
        }

        public static void removeLast(Node nodeList){

        }

        public static void removeAt(Node nodeList){
            
        }

        public static void printssl(Node nodeList){
            while(nodeList != null){
                System.out.print(nodeList.value + "->");
                nodeList = nodeList.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Node head = SinglyLinkedList.createList();
        System.out.println(SinglyLinkedList.getValue(head, "A"));
        System.out.println(SinglyLinkedList.getValue(head, "H"));
        SinglyLinkedList.printssl(head);
        SinglyLinkedList.insert(head, "H");
        System.out.println(SinglyLinkedList.getValue(head, "H"));
        SinglyLinkedList.printssl(head);
        SinglyLinkedList.insertAt(head, "X", 1);
        SinglyLinkedList.printssl(head);
        SinglyLinkedList.insertAt(head, "Z", SinglyLinkedList.len(head)-1);
        SinglyLinkedList.printssl(head);
    }
}