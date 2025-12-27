package ST;

public class st {
    static int tree[];

    public static void init(int n) {
        tree = new int[4*n];
    }

    public static void buildST(int arr[], int i, int start, int end) {// 
        if(start == end) {
            tree[i] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildST(arr, 2*i+1, start, mid);// left subtree - 2*i+1
        buildST(arr, 2*i+2, mid+1, end);// right subtree - 2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
    }

    // Queries on ST - O(log n)
    public static int getSum(int i, int si, int sj, int qi, int qj) {
        if(qj < si || qi > sj) {// non overlapping
            return 0;
        } else if(si >= qi && sj <= qj) {// complete overlap
            return tree[i];
        } else {// partial overlap
            int mid = (si + sj) / 2;
            int left = getSum(2*i+1, si, mid, qi, qj);
            int right = getSum(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    //Update on ST - O(log n) - (OWN) 
    public static void updateUtil(int idx,int i, int si, int sj, int val) {
        if(si == sj) {
            tree[i] = val;
            return;
        }
        int mid = (si + sj) / 2;
        if(idx <= mid) {// left
            updateUtil(idx, 2*i+1, si, mid, val);
        } else {// right
            updateUtil(idx, 2*i+2, mid+1, sj, val);
        }

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }

    public static void update(int arr[], int idx, int val) {
        int n = arr.length;
        if (idx >= n) {
            System.out.println("Index value for updating is out of the length of the array.");
            return;
        }
        arr[idx] = val;
        updateUtil(idx, 0, 0, n-1, val);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        int qi = 2, qj = 5;
        System.out.println("Sum of " + qi + " to " + qj + " = " + getSum(0, 0, n-1, qi, qj));

        update(arr, 9, 2);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
