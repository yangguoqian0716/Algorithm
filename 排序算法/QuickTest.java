package SortAlgorithm;

import java.util.Arrays;
import java.util.SplittableRandom;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Quick {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void ex(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //需对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        int DivideNumber = partition(a, lo, hi);
        //让左子组有序
        sort(a, lo, DivideNumber - 1);
        sort(a, DivideNumber + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针，分别指向最小索引处与最大索引处的下一个位置
        int left = lo;
        int right = hi + 1;
        //切分
        while (true) {
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素,停止指针移动；
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到比分界值大的元素；
            while (less(a[++left], key)) {
                if (left == hi) {
                    break;
                }
            }
            //判断left>=right,如果是，则扫描完毕结束循环，否则交换元素位置即可；
            if (right <= left) {
                break;
            } else {
                ex(a, left, right);
            }
        }

        ex(a, lo, right);
        return right;
    }
}