import java.util.Scanner;

/**
 * cisc3150
 * hw4
 * direction: Write a program that finds and prints all the solutions to the N-Queens
 * problem for a given N. At the end of your program, print how many
 * solutions were found.
 * What is the N-Queens problem, you ask?
 * 1) Google it.
 * 2) It's the same as N-1 Queens problem. But with one more Queen.
 *
 * Note: Backtracking is the easy way to do this. Try doing it with
 * arrays/loops instead.
 *
 * My strategy for N Queen Problem in this array/loop implementation is to get the
 * permutation of an array and then check if it's valid or not.
 *
 * I have learnt about how to create a permutation of an array from this web page:
 * http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
 * Also, although I came up with the validation constraints myself for 90%,
 * the following web page helped me get to the final answer:
 * https://developers.google.com/optimization/puzzles/queens
 *
 * Note: outputs are shown in one dimensional array in which index represents the column
 * and the value represents the row. For instance, 1 3 0 2 is the same as
 * {(1, 0), (3, 1), (0, 2), (2, 3)}
 * @author erii sugimoto
 * @since  9/24/2017.
 */
public class NQueenProblem {

    static int count = 0;

    public static void main(String args[]){
        System.out.print("How many Queens do you want to place? ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.print(" - " + N + System.lineSeparator());
        permute(N);
        System.out.println("For " + N + " Queens, there are " + count + " solutions.");
    }

    public static void permute(int N){
        int[] board = new int[N];
        for(int i = 0; i < N; i++)
            board[i] = i;

        permute(board, N);
    }

    public static void permute(int[] board, int n){
        if(n == 1){
            if(isValid(board)) {
                printArray(board);
                count++;
            }
            return;
        }

        for(int i = 0; i < n; i++){
            swap(board, i, n-1);
            permute(board, n-1);
            swap(board, i, n-1);
        }
    }

    public static boolean isValid(int[] board){
        if(board.length > 0){
            for(int col = 0; col < board.length; col++){
                int diff = board[col] - col;
                int sum = board[col] + col;
                for(int row = col+1; row < board.length; row++){
                    if(diff == board[row] - row || sum == board[row] + row) {
                        return false;
                    }
                }
            }
            return true;
        }else
            return false;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.print(System.lineSeparator());
    }


}
