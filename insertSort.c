#include <stdio.h>

// 插入排序函数
void insertionSort(int arr[], int n) {
    int i, key, j;
    // 遍历数组
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;

        // 将arr[0..i-1]中的所有比key大的元素向右移动一个位置
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}


int main() {
    int arr[] = {12, 11, 13, 5, 6};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("原始数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    insertionSort(arr, n);

    printf("排序后的数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    return 0;
}
