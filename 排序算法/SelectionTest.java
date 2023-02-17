package SortAlgorithm;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args){
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Selection {
    public static void sort(Comparable[] a){
        for(int i=0;i<a.length-2;i++){
            int minIndex=i;

            for(int j=i+1;j<a.length;j++){
                if(greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            ex(a,i,minIndex);

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


