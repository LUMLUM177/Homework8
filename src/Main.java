import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    private static void checkingTheLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - не високосный год");
        }
    }

    private static void installTheOperatingSystem(int typeOS, int yearRelease) {
        int checkYear = 2015;
        if (typeOS == 0 && yearRelease >= checkYear) {
            System.out.println("Для вашей операционной системы iOS требуется установить обычную версию приложения.");
        }
        if (typeOS == 0 && yearRelease <= checkYear) {
            System.out.println("Для вашей операционной системы iOS требуется установить lite-версию приложения.");
        }
        if (typeOS == 1 && yearRelease >= checkYear) {
            System.out.println("Для вашей операционной системы Android требуется установить обычную версию приложения.");
        }
        if (typeOS == 1 && yearRelease <= checkYear) {
            System.out.println("Для вашей операционной системы Android требуется установить lite-версию приложения.");
        }
    }

    private static int calculateNumberDaysDelivery(int distance) {
        int minimalDistance = 20;
        int changeableDistance = 40;
        int deliveryDays = 1;
        for (int i = distance; i > minimalDistance; i -= changeableDistance) {
            deliveryDays++;
        }
        return deliveryDays;
    }

    private static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static int calculateSumArray(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    private static double calculateAverageExpensesArray(int[] array) {
        int sumMonth = calculateSumArray(array);
        return (double) sumMonth / array.length;
    }

    private static void reverseElementsArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            array[i] = array[i] + array[array.length - i - 1];
            array[array.length - i - 1] = array[i] - array[array.length - i - 1];
            array[i] = array[i] - array[array.length - i - 1];
        }
        System.out.print("Массив после переставления элементов: ");
        System.out.println(Arrays.toString(array));
    }

    private static void removeDuplicateLetters(String challenge) {
        System.out.println("Начальная строка - " + challenge);
        char[] words = challenge.toCharArray();
        int countDubles = 0;
        System.out.println("Выполняется проверка на дубли...");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == words[i + 1]) {
                System.out.print("Дубль обнаружен! Повторяющаяся буква на позиции: " + (i + 2));
                System.out.println(", это буква: " + words[i]);
                countDubles++;
                break;
            }
        }
        if (countDubles == 0) {
            System.out.println("В этой строке дублей не обнаружено!");
        }
    }

    public static void main(String[] args) {
        // task 1
        /**
         * Реализуйте метод, который получает в качестве параметра год, а затем проверяет,
         * является ли он високосным, и выводит результат в консоль.
         */
        int currentYear = LocalDate.now().getYear();
        checkingTheLeapYear(currentYear);
        // task 2
        /**
         * Напишите метод, куда подаются два параметра: тип операционной системы (ОС)
         * ( 0 — iOS или 1 — Android) и год выпуска устройства.
         * Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
         */
        int typeOS = 1;
        installTheOperatingSystem(typeOS, currentYear);
        // task 3
        /**
         * Наша задача — написать метод, который на вход принимает дистанцию
         * и возвращает итоговое количество дней доставки.
         */
        int deliveryDistance = 95;
        int numberOfDeliveryDays = calculateNumberDaysDelivery(deliveryDistance);
        System.out.print("Для доставки товара на расстояние " + deliveryDistance);
        System.out.println(" километров потребуется дней: " + numberOfDeliveryDays);
        // task 4
        /**
         * Напишите метод, который получает на вход массив и переставляет все его элементы в обратном порядке.
         * Рекомендуем написать этот метод без возвращаемого значения. Вы будете приятно удивлены, что даже если мы
         * не вернем массив, первоначальный массив изменится, когда мы будем модернизировать пришедший в виде
         * параметра массив внутри метода.
         */
        int[] array = {7, 3, 2, 1, 6, 5};
        System.out.print("Начальный массив: ");
        System.out.println(Arrays.toString(array));
        reverseElementsArray(array);
        System.out.print("Массив после срабатывания метода: ");
        System.out.println(Arrays.toString(array));
        // task 5
        /**
         * Напишите метод, который в виде параметра принимает отсортированную строку. Например, aabccddefgghiijjkk.
         * С помощью цикла проверьте, что в строке нет дублей, и выведите в консоль сообщение об этом.
         * Если дубль найден, нужно прервать поиск по остальным символам и вывести сообщение о присутствии дубля,
         * причем с указанием, какой именно символ задублирован. Затем сразу же прервать выполнение метода.
         * Сам метод ничего возвращать не должен (void).
         */
        String challenge = "abcdeefghijjk";
        removeDuplicateLetters(challenge);
        // task 6
        /**
         * Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов
         * и вычислить среднее значение, которое нужно вернуть из метода в виде результата.
         * Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
         * То есть для работы этого метода нужно будет создать еще методы (1 или более), которые его будут обслуживать
         * и вычислять промежуточные результаты.
         * Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
         */
        int[] expenses = generateRandomArray();
        double averageExpensesPerDay = calculateAverageExpensesArray(expenses);
        System.out.printf("Средние траты в день составляют: %.2f рублей. ", averageExpensesPerDay);
    }
}