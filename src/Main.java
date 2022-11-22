import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();
        while (true) {

            printMenu();

            int command = scanner.nextInt();

            selectAction(command,reportManager);
            if (command == 1234) {
                System.out.println("Программа завершена");
                break;
            }
        }
    }

    public static void printMenu() {

        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
    }

    public static void selectAction(int command,ReportManager reportManager) {

        if (command == 1) {
            reportManager.readFileMonthly();
            System.out.println("Отсчет за месяц считан.");
        } else if (command == 2) {
            reportManager.readFileYearly("resources/y.2021.csv");
            System.out.println("Отсчет за год считан.");
        } else if (command == 3) {
            reportManager.checkingFiles();
        } else if (command == 4) {
            reportManager.outputInformationMonthly();
        } else if (command == 5) {
            reportManager.outputInformationYearly();
        } else if (command == 1234) {
            System.out.println("Выполняется завершение программы...");
        } else {
            System.out.println("Такой команды нету,введите снова.");
        }

    }

}





