public class insertSort {//直接插入排序和折半插入排序
    public void insertSort(int[] array){//直接插入排序
        //创建一个比array长度大一的数组
        int[] newArray=new int[array.length+1];
        for (int i = 0; i <array.length ; i++) {
            newArray[i+1]=array[i];
        }//从1开始装入

        for (int i = 2; i <newArray.length ; i++) {
            if(newArray[i]<newArray[i-1]){//如果比最后一个数都大，就不用比了
                newArray[0]=newArray[i];
                newArray[i]=newArray[i-1];//最后一个数向后移一位\
                int j;
                for (j = i-2; newArray[0]<newArray[j]; j--) {
                    newArray[j+1]=newArray[j];
                }
                newArray[j+1]=newArray[0];
            }
            //print
            for (int j = 1; j < newArray.length; j++) {
                System.out.print(newArray[j]+" ");
            }
            System.out.println();
        }
    }
    public void binaryInsertSort(int[] array){//折半插入排序
//创建一个比array长度大一的数组
        int[] newArray=new int[array.length+1];
        for (int i = 0; i <array.length ; i++) {
            newArray[i+1]=array[i];
        }//从1开始装入
        for (int i = 2; i < newArray.length; i++) {
                newArray[0]=newArray[i];
                int low=1;
                int high=i-1;
                int mid;
                while(low<=high){
                    mid=low+(high-low)/2;
                    if(newArray[0]<newArray[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            for (int j = i-1; j >=low; j--) {
                newArray[j+1]=newArray[j];//记录后移
            }
                newArray[low]=newArray[0];//注意此步
                //print
                for (int j = 1; j < newArray.length; j++) {
                    System.out.print(newArray[j]+" ");
                }
                System.out.println();
                }
    }
    public static void main(String[] args) {
        insertSort demo1=new insertSort();
        int[] array=new int[]{5,4,8,0,9,3,2,6,7,1};
        demo1.binaryInsertSort(array);
    }
}
