public class QuickSortExample {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Đã thêm dấu đóng ngoặc vuông
        int i = (low - 1); // Chỉ số của phần tử nhỏ hơn
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Hoán đổi arr[i+1] và arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
