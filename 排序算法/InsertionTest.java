package SortAlgorithm;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args){
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Insertion{
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(greater(a[j-1],a[j])){
                    ex(a,j-1,j);
                }else{
                    break;
                }
            }
        }
    }
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    public static void ex(Comparable[] a,int i,int j){
        Comparable temp;
        temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}


