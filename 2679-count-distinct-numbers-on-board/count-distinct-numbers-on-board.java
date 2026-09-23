class Solution {
    public int distinctIntegers(int n) {

        int[] arr = new int[n];
        arr[0] = n;

        int count = 1;
        int k = 0;

        while (k < count) {

            int num = arr[k];

            for (int i = 1; i <= n; i++) {

                if (num % i == 1) {

                    boolean found = false;

                    for (int j = 0; j < count; j++) {
                        if (arr[j] == i) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        arr[count] = i;
                        count++;
                    }
                }
            }

            k++;
        }

        return count;
    }
}