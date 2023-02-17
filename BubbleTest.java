import java.util.Arrays;

public class BubbleTest {
    public static void main(String args[]){
        Integer[] arr ={3,5,1,2,6,9,8,4,7};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
