public class Bubble {
        public static void sort(Comparable[] a){
            for(int i=a.length-1;i>0;i--){//i决定多少个元素参与冒泡
                for(int j=0;j<i;j++){
                    if(greater(a[j],a[j+1])){
                        ex(a,j,j+1);
                    }
                }//i是参与冒泡元素的最大索引，故j不可超过i
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


