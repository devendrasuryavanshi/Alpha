package Revision;

public class test {
    public static void rec(int n) {
        if(n < 0) {
            return;
        }
        rec(n-1);
        System.out.print(n+" ");
    }

    public static int sum(int n) {
        if(n == 0) {
            return 0;
        }
        return n + sum(n-1);
    }

    public static int fib(int i) {
        if(i < 2) {
            return i;
        }
        return fib(i-1) + fib(i-2);
    }

    public static boolean isSorted(int arr[], int i) {
        if(i < 2) {
            return true;
        }
        if(arr[i] < arr[i-1]) {
            return false;
        }
        return isSorted(arr, i-1);
    }

    public static int firstOcc(int arr[], int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOcc(arr, i+1, key);
    }

    public static int pow(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * pow(x, n-1);
    }

    public static int ways(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return ways(n-1) + ways(n-2);
    }

    public static void removeDup(String str, int i, StringBuilder sb, boolean map[]) {
        if(i == str.length()) {
            return;
        }
        char ch = str.charAt(i);
        if(!map[ch - 'a']) {
            sb.append(ch);
            map[ch - 'a'] = true;
        }
        removeDup(str, i+1, sb, map);
    }

    public static int friendPair(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int single =  friendPair(n-1);
        int pair = friendPair(n-2);
        int pairWays = (n-1) * pair;
        return single + pairWays;
    }

    public static void binaryStr(int n, String s) {
        if(s.length() == n) {
            System.out.println(s);
            return;
        }
        if(s.length() > 0 && s.charAt(s.length()-1) == '1') {
            binaryStr(n, s+'0');
        } else {
            binaryStr(n, s+'0');
            binaryStr(n, s+'1');
        }
    }
    static String word[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void intToStr(int n) {
        if(n <= 0) {
            return;
        }
        intToStr(n/10);
        System.out.print(word[n%10] + " ");
    }

    public static void back(int arr[], int i) {
        if(i==arr.length) {
            return;
        }
        arr[i] = i+1;
        back(arr, i+1);
        arr[i] -= 2;
    }

    public static void findSub(String str, String ans, int i) {
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        findSub(str, ans+str.charAt(i), i+1);
        findSub(str, ans, i+1);
    }
    
    public static void main(String[] wheels) {
        String str = "abc";
        findSub(str, "", 0);
    }
}

class Automobile {
    // Private method in Automobile class
    String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {
    // Protected method in Car class, overrides Automobile's private method
    String drive() {
        return "Driving car";
    }
    String drive1() {
        return "Driving electric car 2";
    }
}

class ElectricCar extends Car {
    // Public final method in ElectricCar class, overrides Car's protected method
    // @Override
    String drive() {
        return "Driving electric car";
    }

    String drive1() {
        return "Driving electric car 1";
    }
}
