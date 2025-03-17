import java.util.Arrays;
import java.util.Random;

public class quicksorter {
    public static void main(String[] args) {
        for (int i : new int[]{0, 10, 50, 200}) {
            System.out.println("Verifying sort of length " + i + "...");
            int[] list = genArray(i);
            System.out.println("Random array: " + Arrays.toString(list));
            quicksort(list);
            System.out.println("Sorted array: " + Arrays.toString(list));
            System.out.println("Sorted correctly: " + verify_sort(list));
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (high-low<=1) return; // if we're operating on a portion of length 1 (or somehow lower), it is definitely sorted.

        int pivot = choosePivot(low, high);

        while (true) {
            int highPoint = -1; // I'm pretty sure it is impossible for this value to not be overwritten, but just in case, it defaults to -1
            for (int i = low; i < high; i++) {
                if (array[i] >= array[pivot]) { // We'll take the pivot as the highpoint if the pivot is already the greatest number in the list segment
                    highPoint = i;
                    break;
                }
            }

            int lowPoint = -1; // It *is* possible for this to not be overwritten
            for (int i = high - 1; i >= low; i--) {
                if (array[i] < array[pivot]) {
                    lowPoint = i;
                    break;
                }
            }

            if (lowPoint < highPoint) { // rightmost point lower than pivot left of leftmost point greater than pivot.
                swap(array, pivot, highPoint);
                quicksort(array, low, highPoint); // the "high" argument is not inclusive, so we can inclue highPoint, which now refers to the pivot.
                quicksort(array, highPoint + 1, high); // the "low" argument is inclusive, so we add 1 to avoid potential infinite recursion
                return; // Tony says I'm "esoteric"
            }
            swap(array, lowPoint, highPoint);
        }
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length); // this is purely for convenience
    }

    public static boolean verify_sort(int[] array) {
        for (int i=1; i<array.length; i++) {
            if (array[i-1] > array[i]) return false;
        }
        return true;
    }

    private static int choosePivot(int low, int high) {
        return high-1;
    }

    private static void swap(int[] array, int a, int b) {
        if (a<0 || b<0) return;
        int i = array[a];
        array[a] = array[b];
        array[b] = i;
    }

    public static int[] genArray(int len) {
        int[] array = new int[len];
        Random rand = new Random();
        for (int i=0; i<len; i++)
            array[i] = rand.nextInt(); // % 20;
        return array;
    }
}
