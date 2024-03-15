// GFG: Linked List that is Sorted Alternatingly

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.sort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends

/*
 * class Node {
 * int data;
 * Node next;
 * 
 * public Node (int data){
 * this.data = data;
 * this.next = null;
 * }
 * }
 */

class Solution {

    public Node sort(Node head) {

        if (head == null || head.next == null)
            return head;

        if (head.data > head.next.data) {
            head = reverse(head);
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        return ascending(head, last);

    }

    public Node ascending(Node head, Node last) {

        Node curr = head;

        while (curr.next != last && curr.next != last.next) {

            Node temp1 = curr.next;
            curr.next = temp1.next;
            curr = curr.next;

            if (last.next == null) {
                last.next = temp1;
                temp1.next = null;
            } else {
                Node temp2 = last.next;
                last.next = temp1;
                temp1.next = temp2;
            }

        }

        return head;
    }

    Node reverse(Node head) {
        Node p = null;
        Node q = head, n = head;

        while (q != null) {
            n = n.next;

            q.next = p;
            p = q;
            q = n;

        }

        return p;
    }

}