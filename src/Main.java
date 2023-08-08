import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lottery lot = new Lottery();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("""                    
                    1. Добавить игрушку
                    2. Изменить частоту выпадения игрушки
                    3. Провести розыгрыш и сохранить результат
                    4. Выход
                    ->\s""");
            var sel = scan.next();
            switch (sel) {
                case "1" -> lot.addToy();
                case "2" -> lot.changeWeightLoss();
                case "3" -> lot.lottery();
                case "4" -> {
                    System.out.println("Еще увидемся!");
                    System.exit(4);
                }
                default -> System.out.println("Данные неверны. Введите снова");
            }
        }
    }
}