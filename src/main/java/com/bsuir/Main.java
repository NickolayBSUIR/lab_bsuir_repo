package com.bsuir;
import service.CurrencyService;
import service.serviceImpl.CurrencyServiceImpl;

import javax.servlet.http.HttpSession;

import java.util.*;
import entity.Currency;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static CurrencyService service = new CurrencyServiceImpl();    
    public static void main(String[] args) {
        String choice = "0";
        while (true) {
            System.out.print("Меню пользователя\n" +
            "1. Загрузить из файла данные о криптовалютах.\n" +
            "2. Просмотреть все данные\n" +
            "3. Найти криптовалюту по символьному идентификатору\n" +
            "4. Редактировать криптовалюту\n" +
            "5. Удалить криптовалюту по тому же идентификатору\n"+
            "6. Выход\n" +
            "Выбор: ");
            choice = in.nextLine();
            try {
                switch (choice) {
                    case "1":
                        loadCrypto();
                        break;
                    case "2":
                        showCrypto();
                        break;
                    case "3":
                        findCrypto();
                        break;
                    case "4":
                        editCrypto();
                        break;
                    case "5":
                        deleteCrypto();
                        break;
                    case "6":
                        System.out.print("Ende.");
                        System.exit(0);
                    default:
                        System.out.println("Проверьте корректность ввода!");
                        choice = "0";
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Ошибка!");
            }
        }
    }

    public static void loadCrypto() {
        try {
            Scanner reader = new Scanner(new File("./mah.txt"));
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] splitted = data.split(" ");
                service.addCurrency(new Currency(Double.parseDouble(splitted[1]),String.join(" ",Arrays.asList(splitted).subList(2,splitted.length)),splitted[0]));
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("При чтении файла произошла ошибка!");
        }
    }
    
    public static void showCrypto() {
        System.out.format("%10s%20s%15s", "Символ |", "Название |", "Курс |\n");
        Iterator<Currency> iterator = service.showCurrencies().iterator();
        while(iterator.hasNext()) {
            Currency cur = iterator.next();
            System.out.format("%10s%20s%15s", cur.getSymbol(),cur.getName(),cur.getValue());
            System.out.println("\n");
        }
    }

    public static void findCrypto() {
        System.out.print("Введите символьный идентификатор: ");
        String symbol = in.nextLine();
        Currency cur = service.findCurrencyBySymbol(symbol);
        System.out.println(cur);
    }

    public static void deleteCrypto() {
        System.out.print("Введите символьный идентификатор: ");
        String symbol = in.nextLine();
        Currency cur = service.findCurrencyBySymbol(symbol);
        service.deleteCurrency(cur.getId());
        System.out.println("Криптовалюта " + cur.getName() + " удалена");
    }

    public static void editCrypto() {
        System.out.print("Введите символьный идентификатор криптовалюты для изменения: ");
        Currency cur = service.findCurrencyBySymbol(in.nextLine());

        System.out.print("Введите новое название криптовалюты: ");
        cur.setName(in.nextLine());
        System.out.print("Введите новый курс криптовалюты: ");
        cur.setValue(Double.parseDouble(in.nextLine()));
        
        service.updateCurrency(cur);
        System.out.println("Криптовалюта " + cur.getSymbol() + " отредактирована");
    }
}

