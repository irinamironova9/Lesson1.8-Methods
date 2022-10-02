import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        int year = 2022;
        checkLeapYear(year);

        System.out.println("Задание 2");
        int clientOS = 0;
        int clientDeviceYear = 2021;
        recommendApp(clientOS, clientDeviceYear);

        System.out.println("Задание 3");
        int deliveryDistance = 95;
        int minDeliveryDays = 1;
        int firstInterval = 20;
        int interval = 40;
        int totalDeliveryDays = calculateDeliveryDays(deliveryDistance, minDeliveryDays, firstInterval, interval);
        StringBuilder daysForDisplay = new StringBuilder();
        if (totalDeliveryDays == 1) {
            daysForDisplay.append("день");
        } else if (totalDeliveryDays >= 2 && totalDeliveryDays <= 4) {
            daysForDisplay.append("дня");
        } else {
            daysForDisplay.append("дней");
        }
        System.out.println("На доставку потребуется " + totalDeliveryDays + " " + daysForDisplay + ".");
    }
    public static void checkLeapYear (int year) {
        if (year % 4 == 0 && year % 100 !=0 || year % 400 == 0) {
            System.out.println(year + " год - високосный.");
        } else {
            System.out.println(year + " год не является високосным.");
        }
    }

    public static void recommendApp(int OS, int deviceYear) {
        if (OS == 0) {
            if (deviceYear == LocalDate.now().getYear()) {
                System.out.println("Установите версию приложения для iOS по ссылке.");
            } else {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке.");
            }
        } else {
            if (deviceYear == LocalDate.now().getYear()) {
                System.out.println("Установите версию приложения для Android по ссылке.");
            } else {
                System.out.println("Установите облегченную версию приложения для Android по ссылке.");
            }
        }
    }

    public static int calculateDeliveryDays(int deliveryDistance, int minDeliveryDays, int firstInterval, int interval) {
        int totalDeliveryDays;
        if (deliveryDistance <= firstInterval) {
            return minDeliveryDays;
        } else if ((deliveryDistance - firstInterval) % interval == 0) {
            totalDeliveryDays = minDeliveryDays + (deliveryDistance - firstInterval) / interval;
            return totalDeliveryDays;
        } else {
            totalDeliveryDays = minDeliveryDays + 1 + (deliveryDistance - firstInterval) / interval;
            return totalDeliveryDays;
        }
    }
}