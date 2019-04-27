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

    private static String allSubSequences(String word){

        if(word.isEmpty())
            return "";


        char firstLetter = word.charAt(0);
        String remainingString = word.substring(1);

        String remainingStringSubSequences = allSubSequences(remainingString);



        StringBuilder result = new StringBuilder();


        for(String subSequence: remainingStringSubSequences.split(",", -1)){
            result.append(",");
            result.append(subSequence);
            result.append(",");
            result.append(firstLetter);
            result.append(subSequence);
        }
        return result.toString().substring(1);

    }



}