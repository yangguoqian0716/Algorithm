#include <stdio.h>
#include <stdlib.h>

// 将两个已排序的子数组合并为一个已排序的数组
void merge(int arr[], int l, int m, int r) {
    int i, j, k;
    int n1 = m - l + 1;
    int n2 = r - m;

    // 创建临时数组
    int L[n1], R[n2];

    // 将数据复制到临时数组 L[] 和 R[]
    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];

    // 将临时数组的数据合并到 arr[l..r]
    i = 0; // 初始化第一个子数组的索引
    j = 0; // 初始化第二个子数组的索引
    k = l; // 初始化合并子数组的索引
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // 将 L[] 中剩余的元素复制到 arr[]
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    // 将 R[] 中剩余的元素复制到 arr[]
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// 归并排序函数
void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        // 计算中间索引
        int m = l + (r - l) / 2;

        // 对左半部分进行归并排序
        mergeSort(arr, l, m);
        // 对右半部分进行归并排序
        mergeSort(arr, m + 1, r);

        // 合并左右两个已排序的子数组
        merge(arr, l, m, r);
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("原始数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    mergeSort(arr, 0, n - 1);

    printf("排序后的数组: \n");
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    return 0;
}
