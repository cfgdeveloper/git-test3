
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author formacio
 */
public class Main {
    
    static Node head;
    
    public static void main(String[] args) {
//        int num = 5;
//        System.out.println("Factorial of " + num + ": " + factorial(num));
//        
//        int[] numList = {10, 20, 30, 40, 50};
//        reverseList(numList);
//
//        System.out.println(MCD(13, 37));
//
//        dec2Bin(28);
//        
//        Node node3 = new Node(3, null);
//        Node node2 = new Node(2, node3);
//        Node node1 = new Node(1, node2);
//        printLinkedList(node1);
//
//        System.out.println(pow(2,15));
//        fibonacciYo(1, 2, 25);
        for (int i = 1; i <= 25; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        
        

    }
    
    public static int factorial(int n) {
        
        if (n == 1) {
            return n;
        }
        
        return n * factorial(n - 1);
    }
    
    public static void reverseList(int[] numList) {
        if (numList.length == 0) {
            return;
        }
        int[] a = new int[numList.length-1];
        for (int i = 0; i < numList.length-1; i++) {
            a[i] = numList[i+1];
        }
        reverseList(a);
        System.out.print(numList[0] + " ");
    }
    
    public static int MCD(int a, int b) {
        int temp = a;
        if (a < b) {
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        }
        return MCD(b, (a%b));
        //System.out.println(a + " " + b);
    }
    
    public static void dec2Bin(int decNum) {
        /*if (decNum == 0) {
            return;
        }
        System.out.println(decNum % 2);
        dec2Bin(decNum / 2);*/
        
        if (decNum > 0) {
            dec2Bin(decNum / 2);
            System.out.print(decNum % 2);
        }
    }

    private static void printLinkedList(Node node) {
        System.out.print(node);
        if (node.hasNext()) {
            //System.out.println(node);
            printLinkedList(node.next());
        }
        //System.out.println(node); //Así se printaría la lista al revés
    }
    
    public static int pow(int base, int exp) {
        
        if (exp == 1) {
            return base;
        }
        
        return base * pow(base, exp - 1);
    }
    
    /* Mi acercamiento al Fibonacci recursivo */
    public static void fibonacciYo(int seed1, int seed2, int max) {
        if (max == 0) {
            return;
        }
        System.out.print(seed1 + "+" + seed2);
        int sum = seed1 + seed2;
        seed1 = seed2;
        seed2 = sum;
        System.out.println("=" + sum);
        fibonacciYo(seed1, seed2, max-1);
    }
    
    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
