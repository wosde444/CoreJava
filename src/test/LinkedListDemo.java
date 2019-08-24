package test;

public class LinkedListDemo {
    private Node first;
    private Node last;
    private int size;

    private void addFirst(Integer e) {
        Node node = new Node(e);
        if (this.size == 0) {
            this.first = node;
            this.last = node;
        } else {
            node.next = this.first;
            this.first.pre = node;
            this.first = node;
        }
        size++;
    }

    private void addLast(Integer e) {
        Node node = new Node(e);
        if (this.size == 0) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.pre = this.last;
            this.last = node;
        }
        size++;
    }

    private void add(int index, Integer e) {
        Node node = new Node(e);
        if (index < 1 || index > size) {
            System.out.println("索引位置有误！");
        }
        if (this.size == 0) {
            this.first = node;
            this.last = node;
        } else if (index == 1) {
            addFirst(e);
        } else if (index == size + 1) {
            addLast(e);
        } else {
            int i = 1;
            Node temp = this.first;
            while (temp != null) {
                if (i == index) {
                    node.pre = temp.pre;
                    temp.pre.next = node;
                    temp.pre = node;
                    node.next = temp;
                    size++;
                }
                i++;
                temp = temp.next;
            }
        }
        size++;
    }

    private void showAllEle() {
        Node temp;
        temp = this.first;
        for (int i = 1; i <= size; i++) {
            System.out.println("第" + i + "个元素的值：" + temp.ele);
            temp = temp.next;
        }
    }

    private void showEleOfIndex(int index) {
        Node temp;
        temp = this.first;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                System.out.println("第" + i + "个元素的值：" + temp.ele);
            }
            temp = temp.next;
        }
    }

    private void removeByIndex(int index) {
        if (this.first == null) {
            System.out.println("链表已无元素，无法删除！");
        } else {
            Node temp;
            temp = this.first;
            int i = 1;
            while (temp != null) {
                if (i == index) {
                    System.out.println("此元素的值：" + temp.ele);
                    if (temp == this.first) {
                        this.first = temp.next;
                        temp.next.pre = null;
                    } else if (temp == this.last) {
                        this.last = temp.pre;
                        temp.pre.next = null;
                    } else {
                        temp.pre.next = temp.next;
                        temp.next.pre = temp.pre;
                    }
                    size--;
                    return;
                }
                i++;
                temp = temp.next;
            }
            System.out.println("无此元素，无法删除！");
        }
    }

    private void removeByEle(Integer ele) {
        if (this.first == null) {
            System.out.println("链表已无元素，无法删除！");
        } else {
            Node temp;
            temp = this.first;
            int i = 1;
            while (temp != null) {
                if (temp.ele.equals(ele)) {
                    System.out.println("此元素的值：" + temp.ele);
                    if (temp == this.first) {
                        this.first = temp.next;
                        temp.next.pre = null;
                    } else if (temp == this.last) {
                        this.last = temp.pre;
                        temp.pre.next = null;
                    } else {
                        temp.pre.next = temp.next;
                        temp.next.pre = temp.pre;
                    }
                    size--;
                    return;
                }
                i++;
                temp = temp.next;
            }
            System.out.println("无此元素，无法删除！");
        }
    }

    //结点
    class Node {
        private Node pre;
        private Node next;
        private Integer ele;

        public Node(Integer e) {
            this.ele = e;
            this.next = null;
            this.pre = null;
        }
    }

    public static void main(String[] args) {
        LinkedListDemo myLinkedList = new LinkedListDemo();
        myLinkedList.addLast(123);
        myLinkedList.addLast(333);
        myLinkedList.addLast(444);
        myLinkedList.addLast(55);
        myLinkedList.showAllEle();
        myLinkedList.removeByEle(55);
        myLinkedList.showEleOfIndex(1);
        myLinkedList.showEleOfIndex(2);
        myLinkedList.showEleOfIndex(3);
    }
}
