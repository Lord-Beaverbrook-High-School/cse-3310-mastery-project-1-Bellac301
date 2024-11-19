import java.util.Scanner;

//import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Main {

    public static char display() {


        System.out.println("Press 1 to display");
        // System.out.println("Press 2 to the populate the array sequentially");
        System.out.println("Press 3 to quick sort");

        return 0;
    }

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.print(display());
        int choice;
        boolean run = true;
        int[] arr ={4, 1, 6, 3, 7, 8, 9, 5};
        int low = arr[0];
        while (run) {
            System.out.println("Chose one: ");
            choice = myScan.nextInt();
            if (choice == 1) {
                displayN(arr);
                run = true;
            }// else if (choice == 2) {
            //popR(arr);
            //run = true;
            // }
            else if (choice == 3) {
                quicksort(arr, 0, arr.length - 1);
            }

        }
    }

    public static void displayN(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

    }

    //public static int[] popR(int[] arr) {
    //for (int i = 0; i < 10; i++) {
    //arr[i] = (int) Math.round(Math.random() * 10);
    //}
    //return arr;
    //}

//everything above this point is just so I can organize and test my algorithm easily, it's my code
//I copied from skill builder 1 into here

    public static void quicksort(int[] arr, int begin, int end) {//quick sort
        if (begin < end) { // if array has one or fewer elements it stops the call, (base cae)

            // partition array to get pivot in the correct place, splitting it into sub arrays
            int partitionin = partition(arr, begin, end);

            // recursively sort elements
            quicksort(arr, begin, partitionin - 1); // left side of pivot (lower end)
            quicksort(arr, partitionin+ 1, end); // right of pivot (higher end)
        }
    }

    public static int partition(int[] arr, int begin, int end){

        int pivot = arr[end]; // setting my pivot which is last element in my array, each time it gets called on
        // it changes values that's why I use [end] instead of arr.length + 1
        int i = (begin - 1); // my first element, set it as high, so it can be iterated from that point+ above,
        // as well as change values to the first unsorted element everytime it's called

        for (int j = begin; j < end; j++) { // for iterating throughout the array, the initial partition will split
            //array and use this for/if statement to iterate through the sub arrays simultaneously
            if (arr[j] <= pivot) { //if element is bigger than pivot, my condition statement
                i++;
                //swap element at i with j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot with the greater element temp, my other condition statement to sort the other part of
        //the array
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1 ; // return index
    }


}

// sources: https://www.geeksforgeeks.org/java-program-for-quicksort/
// Mrs. Wolfe
// sadie

// I tested it by constantly shortening the code and changing values as I print it out
// for example ill start with 9,8 then ill add 6, then 4, and switch the order after making it longer
// to see how the swapping portion behaves at every value added