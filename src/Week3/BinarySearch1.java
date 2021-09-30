import java.util.Arrays;

class BinarySearch1 {
    int binarySearch(int arr[], int x) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
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