/*
Напишите метод, на вход которого подаётся двумерный строковый массив
размером 4х4. При подаче массива другого размера необходимо бросить
исключение MyArraySizeException. Далее метод должен пройтись по всем
элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией,
в какой именно ячейке лежат неверные данные. В методе main()
вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.
*/
public class ArraySumCalculator {
    public static void main(String[] args) {
        String[][] array = {
                {"1","2","2","2"},
                {"1","2","2","2"},
                {"1","2","2","2"},
                {"1","2","2","2"}
        };

        try{
            int result = calculateArraySum(array);
            System.out.println("Сумма элементов массива " + result);
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println("Ошибка " + e.getMessage());
        }

    }

    /*
    метода calculateArraySum выполняет проверку размера массива и суммирует его элементы,
    бросая соответствующие исключения в случае ошибок.
     */
    public static int calculateArraySum(String[][] array) throws MyArraySizeException, MyArrayDataException{
        int rows = array.length;
        int columns = array[0].length;
        //проверка размера массива
        if (rows !=4 || columns !=4){
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }

        int sum = 0;

        // Проходим по всем элементам массива и суммируем их
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    // В случае ошибки преобразования бросаем исключение с информацией о ячейке
                    throw new MyArrayDataException("Неверные данные в ячейке " + i + " " + j);
                }
            }

        }
        return sum;
    }


}

/*
используется наследование от классов Exception, чтобы создать собственные
исключения MyArraySizeException и MyArrayDataException.
 */
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

