import java.util.Arrays;
import java.util.Random;

public class quicksorter {
    public static void main(String[] args) {
        int[] list = genArray(10);
        System.out.println(Arrays.toString(list));
        quicksort(list);
        System.out.println(Arrays.toString(list));

    }
    public static void quicksort(int[] array, int low, int high) {
        int pivot = choosePivot(low, high);
        int lowPoint=0;
        int highPoint=0;
        do {
            for (int i = low; i < high; i++)
                if (array[i] > array[pivot]) {
                    highPoint = i;
                    break;
                }
            for (int i = high-1; i > low; i--)
                if (array[i] < array[pivot]) {
                    lowPoint = i;
                    break;
                }
            swap(array, highPoint, lowPoint);
        } while (lowPoint > highPoint);
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length);
    }
    private static int choosePivot(int low, int high) {
        return high-1;
    }
    private static void swap(int[] array, int a, int b) {
        int i = array[a];
        array[a] = array[b];
        array[b] = i;
    }

    public static int[] genArray(int len) {
        int[] array = new int[len];
        Random rand = new Random();
        for (int i=0; i<len; i++)
            array[i] = rand.nextInt() % 20;
        return array;
    }
}
