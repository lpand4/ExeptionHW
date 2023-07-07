package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            do {
                String data = inputData(sc);
                if (data.equals("exit")) {
                    break;
                }
                try {
                    String[] personData = checkerDataForSize(data);
                    Person person = parseData(personData);
                    System.out.println(person);
                    writeDataToFile(person);
                } catch (MineException e) {
                    System.err.println(e.getMessage());
                }
            } while (true);
        }
    }

    public static void writeDataToFile(Person person) {
        String filename = person.getSurname();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(person.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputData(Scanner sc) {
        String line = null;
        System.out.println("Формат данных: Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(без знаков) пол(f/m)");
        System.out.println("Для выхода напишите - exit");
        System.out.println("Введите свои данные через пробел в подобном формате: ");
        line = sc.nextLine();
        return line;
    }

    private static String[] checkerDataForSize(String data) throws MyDataSizeUpperException, MyDataSizeLowerException {
        String[] stringArray = data.split(" ");
        int normalSize = 6;
        if (stringArray.length < normalSize) {
            throw new MyDataSizeLowerException();
        } else if (stringArray.length > normalSize) {
            throw new MyDataSizeUpperException();
        } else {
            return stringArray;
        }
    }

    private static boolean checkerStringData(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkerNumberData(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkerGenderData(String value) {
        if (value.equals("f") || value.equals("m")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkerDateData(String value) throws MyDataBithdateException {
        try {
            LocalDate date = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (value.equals(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))) {
                return true;
            } else {
                throw new MyDataBithdateException();
            }
        } catch (Exception e) {
            throw new MyDataBithdateException();
        }
    }

    public static Person parseData(String[] data) throws MineException {
        if (!checkerStringData(data[0])) {
            throw new MyDataSurnameException();
        } else if (!checkerStringData(data[1])) {
            throw new MyDataNameException();
        } else if (!checkerStringData(data[2])) {
            throw new MyDataPatronymicException();
        } else if (!checkerDateData(data[3])) {
            throw new MyDataBithdateException();
        } else if (!checkerNumberData(data[4])) {
            throw new MyDataPhoneNumberException();
        } else if (!checkerGenderData(data[5])) {
            throw new MyDataGenderException();
        } else {
            Person person = new Person(data);
            return person;
        }
    }

}

class Person {
    private String name;
    private String surname;
    private String patronymic;
    private String birthdate;
    private String phoneNumber;
    private String gender;

    public Person(String surname, String name, String patronymic, String birthdate, String phoneNumber, String gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public Person(String[] stringParameters) {
        this(stringParameters[0],
                stringParameters[1],
                stringParameters[2],
                stringParameters[3],
                stringParameters[4],
                stringParameters[5]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname).append(" ")
                .append(name).append(" ")
                .append(patronymic).append(" ")
                .append(birthdate).append(" ")
                .append(phoneNumber).append(" ")
                .append(gender).append("\n");
        return sb.toString();
    }
}

class MyDataSizeLowerException extends MineException {
    public MyDataSizeLowerException() {
        super("Колличество введенных данных меньше необходимых!");
    }
}

class MyDataSizeUpperException extends MineException {
    public MyDataSizeUpperException() {
        super("Колличество введенных данных больше необходимых!");
    }
}

class MyDataSurnameException extends MineException {
    public MyDataSurnameException() {
        super("Данные фамилии в неверном формате!");
    }
}

class MyDataNameException extends MineException {
    public MyDataNameException() {
        super("Данные имени в неверном формате!");
    }
}

class MyDataPatronymicException extends MineException {
    public MyDataPatronymicException() {
        super("Данные отчества в неверном формате!");
    }
}

class MyDataBithdateException extends MineException {
    public MyDataBithdateException() {
        super("Данные дня рождения в неверном формате!");
    }
}

class MyDataPhoneNumberException extends MineException {
    public MyDataPhoneNumberException() {
        super("Данные номера телефона в неверном формате!");
    }
}

class MyDataGenderException extends MineException {
    public MyDataGenderException() {
        super("Данные вашего пола в неверном формате!");
    }
}

abstract class MineException extends Exception {
    public MineException(String msg) {
        super(msg);
    }
}
