package ST;

public class MaxMinST {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build ST - O(n)
    public static void buildST(int arr[], int i, int si, int sj) {
        if(si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildST(arr, 2*i+1, si, mid);
        buildST(arr, 2*i+2, mid+1, sj);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    // O(log n)
    public static int getMax(int i, int si, int sj, int qi, int qj) {
        if(qj < si || qi > sj) {// non overlapping
            return Integer.MIN_VALUE;
        } else if(si >= qi && sj <= qj) {// complete overlap
            return tree[i];
        } else {// partial overlap
            int mid = (si + sj) / 2;
            int left = getMax(2*i+1, si, mid, qi, qj);
            int right = getMax(2*i+2, mid+1, sj, qi, qj);

            return Math.max(left, right);
        }
    }

    // O(log n) - (OWN)
    public static void updateUtil(int idx, int i, int si, int sj, int val) {
        if(si == sj) {
            tree[i] = val;
            return;
        }

        int mid = (si + sj) / 2;
        if(idx <= mid) {// left
            updateUtil(idx, 2*i+1, si, mid, val);
        } else {
            updateUtil(idx, 2*i+2, mid+1, sj, val);
        }
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        if(idx >= n) {
            return;
        }

        arr[idx] = newVal;
        updateUtil(idx, 0, 0, n-1, newVal);
    }
    
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        int qi = 5, qj = 8;
        System.out.println(getMax(0, 0, n-1, qi, qj));
        int idx = 4, newVal = 16;
        update(arr, idx, newVal);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}
