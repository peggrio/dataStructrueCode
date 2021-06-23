public class mergeSort {//归并排序

    public void mergeSort(int[] array, int start, int end) {//递归算法
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public void merge(int[] array, int start, int mid, int end) {
        //开辟一个长度为end-start+1的数组
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 != mid + 1 && p2 != end + 1) {//两个数组（内部已有序）比较，较小者排入temp
            if (array[p1] <= array[p2]) {
                temp[p] = array[p1];
                p1++;
            } else {
                temp[p] = array[p2];
                p2++;
            }
            p++;
        }
        while (p1 != mid + 1) {
            temp[p] = array[p1];
            p1++;
            p++;
        }
        while (p2 != end + 1) {
            temp[p] = array[p2];
            p2++;
            p++;
        }
        p=0;
        //注意此步，不要漏了
        for(int i=start;i<=end;i++){
            array[i]=temp[p];
            p++;
        }
    }
    public void mergeSort_2(int[] array) {//非递归算法
        for (int len = 1; len <array.length; len *= 2) {
            for (int i = 0; i + len < array.length; i += len * 2) {
                int start = i;
                int mid = i + len - 1;
                int end = i + 2 * len - 1;
                if (end > array.length - 1) {
                    //整个待排序数组为奇数的情况
                    end = array.length - 1;
                }
                merge(array, start, mid, end);
            }
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        mergeSort demo1 = new mergeSort();
        int[] array2 = new int[]{5, 4, 8, 0, 9, 3, 2, 6, 7, 1};
        int[] array3=new int[]{2,4,3,5,4,1,5,2,6,4,8};
        int[] array4=new int[]{1,2};
        demo1.mergeSort_2(array2);
    }
}
