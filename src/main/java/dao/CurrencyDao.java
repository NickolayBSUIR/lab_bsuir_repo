package dao;

import entity.Currency;

import java.util.List;

public interface CurrencyDao {
    boolean addCurrency(Currency person);
    boolean updateCurrency(Currency person);
    boolean deleteCurrency(int id);
    List<Currency> showCurrencies();
    Currency findCurrencyById(int id);
    Currency findCurrencyBySymbol(String symbol);
}
