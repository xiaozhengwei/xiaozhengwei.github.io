package quicksort;

public class QuickSort {

    /**
     * 获取基准元素的下标。
     *
     * @param array 待排序的数组
     * @param left  起点索引
     * @param right 终点索引
     * @return
     */
    public static int partition(int[] array, int left, int right) {
        int num = array[left];
        int index = left;

        for (int i = index + 1; i <= right; i++) {
            if (array[i] < num) {
                index++;
                swap(array, i, index);
            }

        }
        if (index != left) {
            array[left] = array[index];
            array[index] = num;
        }

        return index;
    }

    /**
     * 数组中，交换两个元素的位置
     */
    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }


    private static void quickSort(int[] array, int left, int right) {
        if (left == right)
            return;


        int index = partition(array, left, right);


        if (index > left) {
            quickSort(array, left, index - 1);
        }

        if (index < right) {
            quickSort(array, index + 1, right);
        }


    }

    //    public static void main(String[] args) {
//        int[] array = {5, 1, 3, 7, 4, 2, 6};
//        quickSort(array, 0, 6);
//
//        for (int num : array) {
//            System.out.print(num + " ");
//        }
//    }


    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 10, 11, 12, 13, 14, 1, 2, 3, 4, 5,};
        int[] arr1 = {6, 7, 8, 9, 10, 11, 12, 13, 14, 1, 2, 3, 4, 5,};
        System.out.println(searchMin(arr));

    }

    // 仅针对于不重复的数组
    private static int searchMin(int[] array) {

        int low = 0;
        int high = array.length - 1;

        int mid = low;

        // 进入循环说明,数组为:[2,3,4,5,6,7,1] 这样的形式
        // 就是说肯定不是从小到大的数组
        while (array[low] > array[high]) {
            // 如果low比high大,而且他俩相差1
            // 则代表 arr[high]就是最小的数
            if (high - low == 1) {
                return array[high];
            }
            // 取中间的坐标
            mid = (low + high) / 2;

            if (array[low] == array[high] && array[low] == array[mid])
                return minInOrder(array, low, high);

            if (array[mid] >= array[low])
                low = mid;
            else if (array[mid] <= array[high]) {
                high = mid;
            }
        }

        return array[mid];

    }


    private static int minInOrder(int[] array, int low, int high) {

        int result = array[low];

        for (int i = low + 1; i <= high; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;

    }

}
