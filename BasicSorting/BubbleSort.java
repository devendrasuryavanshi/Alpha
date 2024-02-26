package BasicSorting;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for(int turn=0; turn<n-1; turn++) {
            for(int i=0; i<n-1-turn; i++) {
                if(arr[i] > arr[i+1]) {
                    //swap
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 2};
        bubbleSort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
