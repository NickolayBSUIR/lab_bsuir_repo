package service;

import entity.Currency;

import java.util.List;

public interface CurrencyService {
    boolean addCurrency(Currency currency);
    boolean updateCurrency(Currency currency);
    boolean deleteCurrency(int id);
    List<Currency> showCurrencies();
    Currency findCurrencyById(int id);
    Currency findCurrencyBySymbol(String symbol);
}
