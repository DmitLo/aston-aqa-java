import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //создаем файл
        AppData appData = new AppData(new String[]{"N, data, sqr"}, new int[][]{{1, 1, 1}, {2, 2, 4}});
        appData.save("./file.csv");

        //читаем файл
        System.out.println(Arrays.deepToString(appData.getData()));
    }
}