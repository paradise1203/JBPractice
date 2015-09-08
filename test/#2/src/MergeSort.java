public final class MergeSort {

    public static void runMergeSort(String[] mas) {
        int l = 0,
                r = mas.length - 1;
        mergeSort(mas, l, r);
    }

    private static String[] merge(int l1, int r1, int l2, int r2, String[] tmp, String[] mas) {
        int n = r1 - l1 + 1,
                m = r2 - l2 + 1;
        String[] a = new String[n];
        String[] b = new String[m];
        for (int i = 0, k = l1; i < n; i++, k++)
            a[i] = mas[k];
        for (int i = 0, k = l2; i < m; i++, k++)
            b[i] = mas[k];
        int i = 0,
                j = 0,
                k = 0;
        while (i < n && j < m) {
            if (a[i].compareTo(b[j]) <= 0) {
                tmp[k] = a[i];
                i++;
                k++;
            } else {
                tmp[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < n) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            tmp[k] = b[j];
            j++;
            k++;
        }
        return tmp;
    }

    private static void mergeSort(String[] mas, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(mas, l, m);
            mergeSort(mas, m + 1, r);
            String[] tmp = new String[r - l + 1];
            tmp = merge(l, m, m + 1, r, tmp, mas);
            for (int i = 0; i <= r - l; i++)
                mas[i + l] = tmp[i];
        }
    }

}
