#include <stdio.h>

// 希尔排序函数
void shellSort(int arr[], int n) {
    // 使用Knuth序列确定初始间隔
    int h = 1;
    while (h < n / 3)
        h = 3 * h + 1;

    while (h >= 1) {
        // 将数组变为h有序
        for (int i = h; i < n; i++) {
            // 将arr[i]插入到arr[i-h], arr[i-2*h], arr[i-3*h]...之中
            for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                // 交换arr[j]和arr[j-h]
                int temp = arr[j];
                arr[j] = arr[j - h];
                arr[j - h] = temp;
            }
        }
        h = h / 3; // 减小间隔
    }
}

int main() {
    int arr[] = {12, 34, 54, 2, 3};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("原始数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    shellSort(arr, n);

    printf("排序后的数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    return 0;
}
