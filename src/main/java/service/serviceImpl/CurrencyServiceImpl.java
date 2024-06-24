package service.serviceImpl;

import dao.CurrencyDao;
import dao.daoImpl.CurrencyDaoImpl;
import entity.Currency;
// import exception.ShowException;
import org.hibernate.HibernateError;
import service.CurrencyService;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    CurrencyDao currencyDao = new CurrencyDaoImpl();

    public CurrencyServiceImpl() {}

    @Override
    public boolean addCurrency(Currency currency) {
        boolean isAdded = false;
        try {
            if (currencyDao.addCurrency(currency))
                isAdded = true;
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCurrency(Currency currency) {
        boolean isUpdated = false;
        try {
            if (currencyDao.updateCurrency(currency))
                isUpdated = true;
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCurrency(int id) {
        boolean isDeleted = false;
        try {
            if (currencyDao.deleteCurrency(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Currency> showCurrencies() {
        List<Currency> currency = null;
        try {
            currency = currencyDao.showCurrencies();
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return currency;
    }

    @Override
    public Currency findCurrencyById(int id) {
        Currency currency = null;
        try {
            currency = currencyDao.findCurrencyById(id);
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return currency;
    }

    @Override
    public Currency findCurrencyBySymbol(String symbol) {
        Currency currency = null;
        try {
            currency = currencyDao.findCurrencyBySymbol(symbol);
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return currency;
    }
}
