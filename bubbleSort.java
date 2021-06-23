public class bubbleSort {//冒泡排序

    public void bubbleSort(int[] array){
        int n=array.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            //print
            for(int a:array){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    //改良版
    public void bubbleSort_2(int[] array){
        int n=array.length;
        boolean check=false;
        for(int i=0;i<n-1;i++){
            if(check){break;}
            check=true;
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    check=false;
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            //print
            for(int a:array){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        bubbleSort demo1=new bubbleSort();

/*        int[] array=new int[]{5,4,8,0,9,3,2,6,7,1};
        demo1.bubbleSort(array);*/
        int[] array2=new int[]{1,2,3,4,8,7,6,5};
        demo1.bubbleSort_2(array2);
    }
}
