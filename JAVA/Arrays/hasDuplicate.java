package Arrays;

public class hasDuplicate {

    public static boolean has_Duplicate(int arr[]) {
        int num = 1;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print(num+++" ");
                if(arr[i] == arr[j]) {
                    return true;
                }
            } 
        }
        // return has_Duplicate;
        return false;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        System.out.println(has_Duplicate(arr));
    }
}
