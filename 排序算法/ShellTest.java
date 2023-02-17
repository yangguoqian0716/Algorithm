package SortAlgorithm;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args){
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Shell{
    public static void sort(Comparable[] a){
        int h=1;
        while(h<a.length/2){
            h=2*h+1;
        }
        while(h>=1){
            for(int i=h;i<a.length;i++){
                for(int j=i;j>=h;j-=h){
                    if(greater(a[j-h],a[j])){
                        ex(a,j-h,j);
                    } else{
                        break;
                    }
                }
            }
            h=h/2;
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
