import javax.imageio.IIOException;
import java.io.*;

/*
1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается
целиком.
Структура csv файла:
● Строка заголовок с набором столбцов
● Набор строк с целочисленными значениями
● Разделитель между столбцами - символ точка с запятой (;)
(Пример прикреплен на скриншоте)

Для хранения данных использовать класс вида:
public class AppData {
   private String[] header;
   private int[][] data;
   // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются
 */

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            //записываем заголовок
            StringBuilder headerLine = new StringBuilder();
            for (int i = 0; i < header.length; i++) {
                headerLine.append(header[i]);
                if (i < header.length - 1) {
                    headerLine.append(";");
                }
            }
            writer.write((headerLine.toString()));
            writer.newLine();
            //записываем данные
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            //читаем заголовок
            String headerLine = reader.readLine();
            header = headerLine.split(";");

            //считываем данные
            StringBuilder dataLines = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                dataLines.append(line);
                dataLines.append("/n");
            }

            String[] dataRow = dataLines.toString().split("/n");
            data = new int[dataRow.length][header.length];
            for (int i = 0; i < dataRow.length; i++) {
                String[] row = dataRow[i].split(";");
                for (int j = 0; j < row.length; j++) {
                    data[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void setHeader(String[] header) {
//        this.header = header;
//    }
//
//    public void setData(int[][] data) {
//        this.data = data;
//    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
