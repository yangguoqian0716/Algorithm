package SortAlgorithm;

import java.util.Arrays;

public class FactorialTest {
    public static void main(String[] args) {
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Merge{
    private static Comparable[] assist;

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void ex(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    private static void sort(Comparable[] a,int lo,int hi){
      if(hi<=lo){
          return;
      }
      //对lo到hi之间的数据分为两组
        int mid=lo+(hi-lo)/2;
        //分别对每组数据进行排序，就是被划分出来的子数组进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //再将被分开的且各自已经排好序的两个数组进行归并
        merge(a,lo,hi,mid);
    }
    private static void merge(Comparable[] a,int lo,int hi,int mid){
        int i=lo;
        int p1=lo;
        int p2=mid+1;
        while(p1 <= mid && p2 <= hi){
            if(less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else{
                assist[i++]=a[p2++];
            }
        }

        while(p1<=mid){
            assist[i++]=a[p1++];
        }

        while(p2<=hi){
            assist[i++]=a[p2++];
        }

        for(int j=lo;j<=hi;j++){
            a[j]=assist[j];
        }
    }
}