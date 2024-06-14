#include <stdio.h>

// 选择排序函数
void selectionSort(int arr[], int n) {
    int i, j, min_idx;
    // 遍历数组
    for (i = 0; i < n-1; i++) {
        // 找到最小元素的索引
        min_idx = i;
        for (j = i+1; j < n; j++) {
            if (arr[j] < arr[min_idx])
                min_idx = j;
        }
        // 交换arr[i]和arr[min_idx]
        int temp = arr[i];
        arr[i] = arr[min_idx];
        arr[min_idx] = temp;
    }
}


int main() {
    int arr[] = {64, 25, 12, 22, 11};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("原始数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    selectionSort(arr, n);

    printf("排序后的数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
    
    return 0;
}
