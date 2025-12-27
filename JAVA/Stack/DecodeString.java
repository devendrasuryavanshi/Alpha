package Stack;

public class DecodeString {
    static String st;

    public static void decodeString(String str) {
        if(str.isEmpty()) {
            return;
        }
        int n = str.charAt(0) - '0';
        System.out.println(n);
        if(Character.isDigit(str.charAt(0))) {
            for(int i=0; i<str.charAt(0) - '0'; i++) {
                st += str.charAt(1);
            }
        } else if(str.charAt(0) == '[' || str.charAt(0) == ']') {
            decodeString(str.substring(1));
        } else {
            st += str.charAt(0);
            decodeString(str.substring(1));
        }
    }
    
    public static void main(String[] args) {
        String str = "2[cv]";
        decodeString(str);
        System.out.println(st);
    }
}
