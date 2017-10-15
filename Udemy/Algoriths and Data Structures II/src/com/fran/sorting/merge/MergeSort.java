package com.fran.sorting.merge;

public class MergeSort {

    private int[] nums;
    private int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        tempArray = new int[nums.length];
    }

    public void mergeSort(int low, int high) {

        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        merge(low, middle, high);
    }

    public void showResult() {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy nums[i] -> temp[i]
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int left = low;
        int right = middle + 1;
        int index = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while ((left <= middle) && (right <= high)) {
            if (tempArray[left] <= tempArray[right]) {
                nums[index] = tempArray[left];
                left++;
            } else {
                nums[index] = tempArray[right];
                right++;
            }

            index++;
        }

        // Copy the rest of the left side of the array into the target array
        while (left <= middle) {
            nums[index] = tempArray[left];
            index++;
            left++;
        }

        // Copy the rest of the right side of the array into the target array
        while (right <= high) {
            nums[index] = tempArray[right];
            index++;
            right++;
        }
    }
}

