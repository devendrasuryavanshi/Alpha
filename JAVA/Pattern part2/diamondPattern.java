public class diamondPattern {

    public static void diamond_Pattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n*2-1; j++) {
                if(j>n-i && j<=n*2-1-(n-i)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        for(int i=n-1; i>=1; i--) {
            for(int j=1; j<=n*2-1; j++) {
                if(j>n-i && j<=n*2-1-(n-i)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        diamond_Pattern(4);
    }
}
