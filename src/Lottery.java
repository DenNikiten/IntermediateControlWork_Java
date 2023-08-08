import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Lottery {

    private static List<Toy> toys = new ArrayList<>();
    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

    private static int getId = 1;

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void addToy() {
        Scanner scan = new Scanner(System.in);
        String title;
        int weight;
        while (true) {
            System.out.print("Введите название игрушки: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Неверный ввод. Введите еще раз");
                break;
            }
            System.out.print("Введите частоту выпадения игрушки: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                weight = Integer.parseInt(value);
                if (weight <= 0) {
                    System.out.println("Неверный ввод. Введите еще раз");
                } else {
                    Toy toy = new Toy(getId, title, weight);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        getId++;
                        toys.add(toy);
                        System.out.println("Новая игрушка добавлена");
                    } else {
                        System.out.println("Игрушка уже была добавлена");
                    }
                }
            } else {
                System.out.println("Неверный ввод. Введите еще раз");
            }
            break;
        }
    }

    public void changeWeightLoss() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите id игрушки: ");
        String value = scan.nextLine();
        if (isDigit(value)) {
            int getId = Integer.parseInt(value);
            if (getId >= 0 && getId < toys.size()) {
                System.out.println("Игрушка " + toys.get(getId).getTitle() +
                        " имеет вес " + toys.get(getId).getFrequencyDropoutToy());
                System.out.print("Введите новый вес: ");
                value = scan.nextLine();
                if (isDigit(value)) {
                    int newWeight = Integer.parseInt(value);
                    toys.get(getId).setFrequencyDropoutToy(newWeight);
                    System.out.println("Вес изменен");
                } else {
                    System.out.println("Неверный ввод. Введите еще раз");
                }
            } else {
                System.out.println("Такого id нет");
            }
        } else {
            System.out.println("Неверный ввод. Введите еще раз");
        }
    }

   public Toy getPrize() {
        if (prizes.size() == 0) {
            Random rnd = new Random();
            for (Toy toy : toys) {
                for (int i = 0; i < toy.getFrequencyDropoutToy(); i++) {
                    Toy temp = new Toy(toy.getId(), toy.getTitle(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        return prizes.poll();
    }

  public void lottery() {
        if (toys.size() >= 3) {
            Toy prize = getPrize();
            System.out.println("Приз: " + prize.getTitle());
            saveToFile(prize.getInfo());
        } else {
            System.out.println("Добавьте в призовой фонд не менее 3-ех игрушек");
        }
    }

    private void saveToFile(String text) {
        File file = new File("Save_result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Save_result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
