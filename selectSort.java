public class selectSort {//简单选择排序

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int position = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[position] > array[j]) {
                    position = j;
                }
            }
                    int temp = array[i];
                    array[i] = array[position];
                    array[position] = temp;

                for (int a : array) {
                    System.out.print(a + " ");
                }
                System.out.println();

        }
    }

    public static void main(String[] args) {
        selectSort demo1 = new selectSort();
        int[] array2 = new int[]{5,4,8,0,9,3,2,6,7,1};
        demo1.selectSort(array2);
    }
}
