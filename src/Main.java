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
        int totalDeliveryDays = calculateDeliveryDays(deliveryDistance);
        StringBuilder daysForDisplay = modifyWordDay(totalDeliveryDays);
        System.out.printf("На доставку потребуется %s %s.%n", totalDeliveryDays, daysForDisplay);
    }
    public static void checkLeapYear (int year) {
        if (year % 4 == 0 && year % 100 !=0 || year % 400 == 0) {
            System.out.println(year + " год - високосный.");
        } else {
            System.out.println(year + " год не является високосным.");
        }
    }

    public static void recommendApp(int OS, int deviceYear) {
        if (OS != 0 && OS != 1) {
            throw new IllegalArgumentException("Недопустимый тип операционной системы.");
        }
        if (deviceYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Недопустимый год выпуска устройства.");
        }
        String osString = OS == 0 ? "iOS" : "Android";
        String versionString = deviceYear == LocalDate.now().getYear() ? "полную" : "облегченную";
        System.out.printf("Установите %s версию приложения для %s по ссылке.%n", versionString, osString);
    }

    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20) {
            return 1;
        } else {
            return (int) Math.round((double) deliveryDistance / 40) + 1;
        }
    }

    public static StringBuilder modifyWordDay(int numberOfDays) {
        StringBuilder daysForDisplay = new StringBuilder();
        if (numberOfDays >= 11 && numberOfDays <= 14) {
            daysForDisplay.append("дней");
            return daysForDisplay;
        }
        String days = Integer.toString(numberOfDays);
        switch (days.charAt(days.length() - 1)) {
            case '1':
                daysForDisplay.append("день");
                break;
            case '2':
            case '3':
            case '4':
                daysForDisplay.append("дня");
                break;
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '0':
                daysForDisplay.append("дней");
        }
        return daysForDisplay;
    }
}