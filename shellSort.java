public class shellSort {//希尔排序
   //初始增量d=n/2,其后d=d/2
    public void shellSort(int[] array){
        int n=array.length;
        for(int d=n/2;d>=1;d/=2){
            for(int i=d;i<n;i++){
                 int temp=array[i];
                 int k;
                 for(k=i-d;k>=0&&array[k]>temp;k-=d){
                     array[k+d]=array[k];
                 }
                 array[k+d]=temp;
}
            //print
            for(int i:array){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        shellSort demo1=new shellSort();
        int[] array=new int[]{5,4,8,0,9,3,2,6,7,1};
        demo1.shellSort(array);
    }
}
