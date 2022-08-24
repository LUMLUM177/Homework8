import java.time.LocalDate;

public class Main {
    public static void checkingTheLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - не високосный год");
        }
    }

    public static void installTheOperatingSystem(int typeOS, int yearRelease) {
        int checkYear = 2015;
        if (typeOS == 0) {
            if (yearRelease >= checkYear) {
                System.out.println("Для вашей операционной системы iOS требуется установить обычную версию приложения");
            } else {
                System.out.println("Для вашей операционной системы iOS требуется установить lite-версию приложения");
            }
        } else {
            if (yearRelease >= checkYear) {
                System.out.println("Для вашей операционной системы Android требуется установить обычную версию приложения");
            } else {
                System.out.println("Для вашей операционной системы Android требуется установить lite-версию приложения");
            }
        }
    }

    public static void calculateNumberDaysDelivery(int distance) {
        int minimalDistance = 20;
        int changeableDistance = 40;
        int deliveryDays = 1;
        for (int i = distance; i > minimalDistance; i -= changeableDistance) {
            deliveryDays++;
        }
        System.out.println("Для доставки товара на расстояние " + distance + " километров потребуется дней: " + deliveryDays);
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public static double calculateAverageExpenses(int[] array) {
        int sumMonth = calculateSum(array);
        return (double) sumMonth / array.length;
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
        int typeOS = 0;
        installTheOperatingSystem(typeOS, currentYear);
        // task 3
        /**
         * Наша задача — написать метод, который на вход принимает дистанцию
         * и возвращает итоговое количество дней доставки.
         */
        int deliveryDistance = 95;
        calculateNumberDaysDelivery(deliveryDistance);
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
        double averageExpensesPerDay = calculateAverageExpenses(expenses);
        System.out.printf("Средние траты в день составляют: %.2f рублей. ", averageExpensesPerDay);
    }
}