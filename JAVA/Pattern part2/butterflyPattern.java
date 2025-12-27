public class butterflyPattern {
    //butterfly_Patter - it is complex to understand (not preferred)
    public static void butterfly_Pattern(int n) {
        for(int i=1; i<=n; i++) {
            if(i<=n/2) {
                for(int j=1; j<=n; j++) {
                    if(j<=i || j>n-i) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            } else {
                for(int j=1; j<=n; j++) {
                    if(j<=i-(i*2-(n+1)) || j>n-(i-(i*2-(n+1)))) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
    
    //butterfly_Patter2 - it is easy to understand (preferred)
    public static void butterfly_Pattern2(int n) {
        // half pattern (above)
        for(int i=1; i<=n; i++) {
            innerFunction(n*2, i);
            System.out.println();
        }

        // half pattern (below)
        for(int i=n; i>=1; i--) {
            innerFunction(n*2, i);
            System.out.println();
        }
    }

    public static void innerFunction(int n, int i) {
        for(int j=1; j<=n; j++) {
            if(j<=i || j>n-i) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
    }
    
    public static void main(String[] args) {
        // butterfly_Pattern(8);
        butterfly_Pattern2(4);
    }
}
