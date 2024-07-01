package Chap5_Recursive;

class LinkedList1 {
    Node1 head;

    class Node1 {
        int data;
        Node1 link;

        Node1(int data) {
            this.data = data;
            this.link = null;
        }
    }

    // 노드를 리스트에 추가하는 메서드
    void add(int data) {
        Node1 newNode = new Node1(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1 temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    // 리스트를 출력하는 메서드
    void printList() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    // Merge 메서드
    void Merge(LinkedList1 b) {
        Node1 temp1 = this.head;
        Node1 temp2 = b.head;
        Node1 dummy = new Node1(0); // 더미 노드
        Node1 res = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                res.link = temp1;
                temp1 = temp1.link;
            } else {
                res.link = temp2;
                temp2 = temp2.link;
            }
            res = res.link; // res를 다음 노드로 업데이트
        }

        if (temp1 != null) {
            res.link = temp1;
        } else if (temp2 != null) {
            res.link = temp2;
        }

        this.head = dummy.link; // 새로운 head 설정
    }

    // 리스트를 병합 정렬하는 메서드
    void sort() {
        this.head = mergeSort(this.head);
    }

    // 병합 정렬을 수행하는 재귀 메서드
    private Node1 mergeSort(Node1 h) {
        if (h == null || h.link == null) {
            return h;
        }

        Node1 middle = getMiddle(h);
        Node1 nextOfMiddle = middle.link;

        middle.link = null;

        Node1 left = mergeSort(h);
        Node1 right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    // 두 정렬된 리스트를 병합하는 메서드
    private Node1 sortedMerge(Node1 a, Node1 b) {
        Node1 result;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.link = sortedMerge(a.link, b);
        } else {
            result = b;
            result.link = sortedMerge(a, b.link);
        }

        return result;
    }

    // 리스트의 중간 노드를 찾는 메서드
    private Node1 getMiddle(Node1 h) {
        if (h == null)
            return h;

        Node1 slow = h, fast = h;

        while (fast.link != null && fast.link.link != null) {
            slow = slow.link;
            fast = fast.link.link;
        }
        return slow;
    }


}


public class GPTSorting {
	public static void main(String[] args) {
        LinkedList1 a = new LinkedList1();
        LinkedList1 b = new LinkedList1();

        a.add(3);
        a.add(7);
        a.add(5);

        b.add(8);
        b.add(2);
        b.add(4);
        b.add(9);

        System.out.print("List A before sorting: ");
        a.printList();
        System.out.print("List B before sorting: ");
        b.printList();

        a.sort();
        b.sort();

        System.out.print("List A after sorting: ");
        a.printList();
        System.out.print("List B after sorting: ");
        b.printList();

        a.Merge(b);

        System.out.print("Merged and Sorted List: ");
        a.printList();
    }
}
