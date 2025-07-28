import java.util.*;

public class Main {
// 0 - n l != 0 3 - m 
  public static void merge(int arr[], int l, int m, int r) {
    int nL = m - l + 1;
    int nR = r - m;
    int tempL[] = new int[nL];
    int tempR[] = new int[nR];

    // copy arr from L -> M in tempL
    for(int i = 0; i < nL; i ++) {
      tempL[i] = arr[l + i];
    }

    // copy arr from M + 1 - R in tempR
    for(int j = 0; j < nR; j++) {
      tempR[j] = arr[m + 1 + j];
    }


    int k = l, i = 0, j = 0;
    // merge part
    while(i < nL && j < nR) {
      if(tempL[i] < tempR[j]) {
        arr[k++] = tempL[i++];
      } else {
        arr[k++] = tempR[j++];
      }
    }

    while(i < nL) {
      arr[k++] = tempL[i++];
    }

    while(j < nR) {
      arr[k++] = tempR[j++];
    }
  }

  public static void mergeSort(int arr[], int l, int r) {
    if(r - l <= 1) return;

    int m = l + (r - l) / 2;

    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);

    merge(arr, l, m, r);
  }


  public static void main(String[] args) {
    int arr[] = {5, 6, 2, 1, 8, 3};
    mergeSort(arr, 0, 5);

    System.out.println(Arrays.toString(arr));
  }
}