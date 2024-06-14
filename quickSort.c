#include <stdio.h>

// 交换两个元素的值
void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

// 对数组进行划分，并返回划分的索引
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // 选择最后一个元素作为基准值
    int i = low - 1; // 记录小于基准值的元素的索引

    for (int j = low; j <= high - 1; j++) {
        // 如果当前元素小于等于基准值，则将其交换到小于基准值的区域
        if (arr[j] <= pivot) {
            i++; // 小于基准值的区域大小增加
            swap(&arr[i], &arr[j]); // 交换元素
        }
    }
    swap(&arr[i + 1], &arr[high]); // 将基准值放入正确的位置
    return (i + 1); // 返回基准值的索引
}

// 快速排序函数
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // 划分数组，pi为基准值的索引

        // 对基准值左边的子数组进行快速排序
        quickSort(arr, low, pi - 1);
        // 对基准值右边的子数组进行快速排序
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("原始数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    quickSort(arr, 0, n - 1);

    printf("排序后的数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    return 0;
}
