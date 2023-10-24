import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(first(1, 2));
        second(5);
        System.out.println(third(7));
        forth("Привет", 5);
        fifth(2023);

        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(sixth(arr));

        System.out.println(seventh());

        int[] arrEighth = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(eighth(arrEighth));
        System.out.println(ninth(arrEighth));
        tenth(5);
        System.out.println(eleven(6, 5));
    }

    public static boolean first(int a, int b) {
        int c = a + b;
        if (c >= 10 & c <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void second(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean third(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void forth(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static void fifth(int year) {
        boolean leapyear = (
                year > 1584 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)));
        if (leapyear)
            System.out.println("Год " + year + " високосный");
        else
            System.out.println("Год " + year + " не високосный");
    }

    public static String sixth(int[] a) {
        int[] b = new int[10];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                b[i] = 0;
            } else {
                b[i] = 1;
            }
        }
        return Arrays.toString(b);
    }

    public static String seventh() {
        int a[] = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        return Arrays.toString(a);
    }

    public static String eighth(int[] a) {
        int[] b = new int[12];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                b[i] = a[i] * 2;
            } else {
                b[i] = a[i];
            }
        }
        return Arrays.toString(b);
    }

    public static String ninth(int[] a) {
        int[] c = new int[12];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                c[i] = a[i] * 2;
            } else {
                c[i] = a[i];
            }
        }
        return Arrays.toString(c);
    }

    public static void tenth(int len) {
        int[][] b = new int[len][len];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (i == j) {
                    b[i][j] = 1;
                    System.out.print(b[i][j]);
                } else {
                    b[i][j] = 0;
                    System.out.print(b[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static String eleven(int len, int initialValue) {
        int[] b = new int[len];
        Arrays.fill(b, initialValue);
        return Arrays.toString(b);
    }


}

