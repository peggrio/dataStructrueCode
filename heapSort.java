public class heapSort {

    public void heapSort(int[] array){
//如果是升序排序就用大顶堆，否则就用小顶堆
  //1.构建大顶堆
        for(int i=array.length/2-1;i>=0;i--){
            //i是从下到上，从左到右第一个非叶子节点，从该结点开始向前调整
            adjustHeap(array,i,array.length);
        }
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
        //2.调整堆结构，交换堆顶与堆尾元素
        for(int j=array.length-1;j>0;j--){
            swap(array,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(array,0,j);//重新对堆进行调整
            for(int i:array){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public void adjustHeap(int[] array,int start,int length){//关键步骤
        int temp=array[start];//先取出当前元素
        for(int k=2*start+1;k<length;k=k*2+1){//从start节点的左子节点开始,也就是2i+1处开始
            if(k+1<length&&array[k]<array[k+1]){//如果左节点小于右节点，则k转换到右节点
                k++;
            }
            if(array[k]>temp){//找到了最大的子节点，跟父节点比较
                array[start]=array[k];
                start=k;//交换，使父节点成为最大的那个
            }else{
                break;
            }
        }
        array[start]=temp;
    }
    public void swap(int[] array,int a, int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    public static void main(String[] args) {
        heapSort demo1=new heapSort();
        int[] array=new int[]{5,4,8,0,9,3,2,6,7,1};
demo1.heapSort(array);

    }
}
