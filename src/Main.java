import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // write your code here


        System.out.println("______________FACTORIAL OF 5_______________");
        System.out.println(factorial(5));

        System.out.println("______________FIBONACCI SERIES TILL 9______________");
        for(int i=0; i<10; i++)
           System.out.print(fibonacciSum(i)+" ");

        System.out.println();
        System.out.println();


        System.out.println("______________FIBONACCI SUM WITH MEMOIZATION TILL 9______________");
        for(int i=0; i<10; i++)
            System.out.print(fibonacciSum(i, new int[i+1])+" ");


        System.out.println();
        System.out.println();
        System.out.println("______________REVERSE STRING OF abcdefgh______________");
        System.out.print(reverseString("abcdefgh"));


        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println("______________ALL SUBSEQUENCES OF abcd______________");
        System.out.print(allSubSequences("abcd"));


        System.out.println();
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println("______________CONVERT 123 TO STRING______________");
        System.out.print(convertIntToString(123));


        System.out.println();
        System.out.println();
        System.out.println("______________REVERSE PAIR OF LINKED LIST______________");
        System.out.println("______________1->2->3->4______________");
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode swapped = swapPairs(head);

        while(swapped != null){
            System.out.println(swapped.val);
            swapped = swapped.next;
        }


        System.out.println();
        System.out.println();
        System.out.println("______________REVERSE CHAR ARRAY IN PLACE hello______________");
        char[] tmp = {'h','e','l','l','o'};
        reverseString(tmp, 0, tmp.length-1);
        System.out.print(tmp);


        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();
        System.out.println("______________PASCAL TRIANGLE FOR 5______________");

        int[][] pascalTriangles = new int[5][];
        pascalsTriangle(5, pascalTriangles);
        System.out.println(Arrays.deepToString(pascalTriangles));


        System.out.println();
        System.out.println();
    }


    private static int factorial(int i){
        if(i<=1)
            return 1;

        return factorial(i-1)*i;
    }

    private static int fibonacciSum(int n){

        if(n<=0)
            return 0;

        if(n==1)
            return 1;


        return fibonacciSum(n-1)+fibonacciSum(n-2);


    }

    private static int fibonacciSum(int n, int[] memo){

        if(n<=0)
            return 0;

        if(n==1)
            return 1;


        if(memo[n] > 0)
            return memo[n];

        memo[n] = fibonacciSum(n-1, memo)+fibonacciSum(n-2, memo);


        return memo[n];
    }


    private static String reverseString(String s){
        if(s.isEmpty())
            return "";


        return reverseString(s.substring(1))+s.charAt(0);
    }

    private static String subSequenceAfter(String partialSequence, String word){

        if(word.isEmpty())
            return partialSequence;


        return subSequenceAfter(partialSequence, word.substring(1))+
                ","+subSequenceAfter(partialSequence+word.charAt(0), word.substring(1));



    }
    private static String allSubSequences(String word){
        return subSequenceAfter("", word);
    }

    private static String convertIntToString(int num){
        if(num<0)
            return convertIntToString(-num);
        if(num<10)
            return num+"";

        return convertIntToString(num/10)+(num%10);
    }

    private static ListNode swapPairs(ListNode listNode){

        if(listNode == null || listNode.next == null)
            return listNode;

        ListNode tmp = listNode.next;

        listNode.next = swapPairs(listNode.next.next);
        tmp.next = listNode;
        listNode = tmp;

        return listNode;
    }


    public static void reverseString(char[] s, int i, int j){
        if(i>=j)
            return;

        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
        reverseString(s, i+1, j-1);
    }

    public static int[] pascalsTriangle(int i, int[][] result){
        if (i==0)
            return new int[]{1};


        result[i-1] = pascalsTriangle(i-1, result);

        int[] newPascal = new int[i+1];
        for(int ind = 0; ind<newPascal.length; ind++){
            if(ind ==0 || ind== newPascal.length-1)
            {
                newPascal[ind] = 1;
            }
            else {

                newPascal[ind] = result[i-1][ind-1]+result[i-1][ind];
            }

        }

        return newPascal;

    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
