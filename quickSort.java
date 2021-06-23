public class quickSort {
    public void quickSort(int start,int end,int[] array){
        if(start>=end){
            return;
        }
        int pivot=partition_2(array,start,end);//确定用于比较的基准数字的位置
        quickSort(start,pivot-1,array);
        quickSort(pivot+1,end,array);

    }
    public int partition(int[] array,int left, int right){
        //左右指针互换
        //详细思路见https://blog.csdn.net/libaineu2004/article/details/82253412
        int pivot=array[left];//取第一个元素为基准元素
        int staticLeft=left;//要保留这个pivot的位置信息

        while(left<right){
            //right左移到停下
            while(right>left&&pivot<=array[right]){
                right--;
            }
            while(right>left&&pivot>=array[left]){
                left++;
            }
            //right和left都停止，交换他们的位置

            if(left<right) {//注意要先加这一个判断哦
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }
        //pivot和指针重合点交换
        array[staticLeft]=array[left];
        array[left]=pivot;

/*        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();*/

        return left;
    }
    public int partition_2(int[] array,int left,int right){
        //逐坑法
        //详细思路见https://blog.csdn.net/libaineu2004/article/details/82253412
        int pivot=array[left];
        while(left<right){
            while(right>left&&array[right]>=pivot){
                right--;
            }
            array[left]=array[right];
            while(left<right&&pivot>=array[left]){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=pivot;
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
        return left;
    }
    public static void main(String[] args) {
        quickSort demo1=new quickSort();
        int[] array2=new int[]{5,4,8,0,9,3,2,6,7,1};
        demo1.quickSort(0,array2.length-1,array2);

    }
}

