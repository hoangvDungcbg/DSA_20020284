import java.util.Arrays;

class BinarySearch1 {
    int binarySearch(int arr[], int number) {
        Arrays.sort(arr);
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == number)
                return m;
            if (arr[m] < number)
                l = m + 1;
            else {
                h = m - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch1 ob = new BinarySearch1();
        int arr[] = {10, 2, 4, 5, 6};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Không tìm thấy giá trị");
        else {
            result+=1;
            System.out.println("Value location: " + result);
        }
    }
}