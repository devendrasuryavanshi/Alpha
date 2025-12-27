package Arrays;

import java.util.Scanner;

public class ArraysCC {
   public static int binarySearch(int num[], int key) {
      int start = 0;
      int end = num.length-1;
      int mid = (start+end)/2;

      while (start <= end) {
         mid = (start+end)/2;

         //comparisons
         if(num[mid] == key) {// found
            return mid;
         } else if(num[mid] > key) {// left
            end = mid-1;
         } else {// right
            start = mid+1;
         }
      }
      return -1;
   }

   //method one using for loop
   public static void reverseArray(int num[]) {
      int temp = 0;
      for(int i=0; i<num.length/2; i++) {
         temp = num[i];
         num[i] = num[(num.length-1)-i];
         num[(num.length-1)-i] = temp;
      }
   }

   //method 2 using while loop
   public static void reverseArray2(int num[]) {
      int first = 0;
      int last = num.length-1;
      while (first < last) {
         int temp = num[last];
         num[last] = num[first];
         num[first] = temp;

         first++;
         last--;  
      }
   }

   public static void printPair(int arr[]) {
      System.out.println((arr.length*(arr.length-1))/2);
      int tp = 0;
      for(int i=0; i<arr.length; i++) {
         for(int j=i+1; j<arr.length; j++) {
            tp++;
            System.out.print("("+arr[i]+", "+arr[j]+") ");
         }
         System.out.println();
      }
      System.out.println(tp);
   }

   public static void subArray(int num[]) {
      System.out.println("total number of sub arrays: "+(num.length*(num.length+1))/2);
      int sum = 0;
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      
      int prefix[] = new int[num.length];
      prefix[0] = num[0];
      for(int i=1; i<prefix.length; i++) {
         prefix[i] = prefix[i-1] + num[i];
      }
      for(int i=0; i<num.length; i++) {
         for(int j=i; j<num.length; j++) {
            // for(int k=i; k<j; k++) {
            //    sum += num[k];
            //    System.out.print(num[k]+" ");
            // }
            sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
            if(max<sum) {
               max = sum;
            }
            if(min>sum) {
               min = sum;
            }
            System.out.print("("+sum+")");
         }
         System.out.println();
      }
      System.out.println("max value of sum of sub arrays= "+max);
      System.out.println("min value of sum of sub arrays= "+min);
   }

   public static void kadanes(int num[]) {
      int cs = 0;
      int ms = Integer.MIN_VALUE;
      for(int i=0; i<num.length; i++) {
         cs += num[i];
         ms = Math.max(cs, ms);
         if(cs < 0){
            cs = 0;
         }
         
      }
      System.out.println("max value of sum of sub arrays= "+ms);
   }

   public static void bubbleSort(int arr[]) {// increasing order
      int n = arr.length;

      for(int turn=0; turn<n-1; turn++) {
         for(int j=0; j<n-1-turn; j++) {
            if(arr[j] > arr[j+1]) {
               int temp = arr[j];
               arr[j] = arr[j+1];
               arr[j+1] = temp;
            }
         }
      }
   }

   public static void selectionSort(int arr[]) {
      int n = arr.length;
      for(int i=0; i<n-1; i++) {
         int minPos = i;
         for(int j=i+1; j<n; j++) {
            if(arr[minPos] > arr[j]) {
               minPos = j;
            }
         }
         //swap
         int temp = arr[i];
         arr[i] = arr[minPos];
         arr[minPos] = temp;
      }
   }

   public static void insertionSort(int arr[]) {
      int n = arr.length;
      for(int i=1; i<n; i++) {
         int curr = arr[i];
         int prev = i-1;
         //finding out the correct pos to insert
         while (prev>=0 && arr[prev] < curr) {
            arr[prev+1] = arr[prev];
            prev--;
         }
         //insertion
         arr[prev+1] = curr;
      }
   }

   public static void countingSort(int arr[]) {
      int largest = Integer.MIN_VALUE;
      for(int i=0; i<arr.length; i++) {
         largest = Math.max(largest, arr[i]);
      }

      int count[] = new int[largest+1];
      for(int i=0; i<arr.length; i++) {
         count[arr[i]]++;
      }

      int j = arr.length-1;
      for(int i=0; i<count.length; i++) {
         while (count[i] > 0) {
            arr[j] = i;
            j--;
            count[i]--;
         }
      }
   }

   public static int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      int answer[] = new int[n];
      for(int i=0; i<n; i++) {
          for(int j=i+1; j<n; j++) {
              if(temperatures[i] < temperatures[j]) {
                  answer[i] = j-i;
                  j = n;
              } else {
               answer[i] = 0;
              }
          }
      }
      return answer;
  }
   

     public static void main(String[] args) {
      //   Scanner sc = new Scanner(System.in);
      //   int num[] = {-1, -2, -3, -4};
      //   int result = binarySearch(num, 9);
      //   System.out.println(result);
      // reverseArray(num);
      // reverseArray2(num);
      // for(int i=0; i<num.length; i++) {
      //    System.out.print(num[i]+" ");
      // }
      // printPair(num);
      // subArray(num);
      // kadanes(num);

      // int arr[] = {3,6,2,1,8,7,4,5,3,1};
      // bubbleSort(arr);
      // selectionSort(arr);
      // insertionSort(arr);
      // countingSort(arr);
      // for(int i=0; i<arr.length; i++) {
      //    System.out.print(arr[i]+" ");
   //   }

   int temperatures[] = {73,74,75,71,69,72,76,73};
   int ans[] = dailyTemperatures(temperatures);
   for(int i=0; i<ans.length; i++) {
      System.out.print(ans[i]+" ");
   }
     }
}