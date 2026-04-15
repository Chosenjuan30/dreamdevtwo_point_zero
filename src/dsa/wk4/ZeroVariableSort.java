package dsa.wk4;

public class ZeroVariableSort {

        public static int[] sort(int[] arr, int n, int i) {

            if (n <= 1) {
                return arr;
            }

            if (i == n - 1) {
                return sort(arr, n - 1, 0);
            }

            if (arr[i] > arr[i + 1]) {

                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
            }


            return sort(arr, n, i + 1);
        }

        public static void main(String[] args) {
            int[] data = {64, 34, 25, 12, 22, 11, 90};

            sort(data, data.length, 0);

            for (int val : data) {
                System.out.print(val + " ");
            }
        }
    }

