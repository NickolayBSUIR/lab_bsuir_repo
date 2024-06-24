package dao.daoImpl;

import dao.CurrencyDao;
import entity.Currency;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CurrencyDaoImpl implements CurrencyDao {

    @Override
    public boolean addCurrency(Currency currency) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(currency);
            tx.commit();
            session.close();
            isAdded = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCurrency(Currency currency) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(currency);
            tx.commit();
            session.close();
            isUpdated = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCurrency(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Currency currency = session.load(Currency.class, id);
            Transaction tx = session.beginTransaction();
            session.delete(currency);
            tx.commit();
            session.close();
            isDeleted = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<Currency> showCurrencies() {
        List<Currency> people = (List<Currency>)SessionFactoryImpl.getSessionFactory().openSession().createQuery("FROM Currency").list();
        return people;
    }

    @Override
    public Currency findCurrencyById(int id) {
        Currency currency = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Currency> cr = cb.createQuery(Currency.class);
            Root<Currency> root = cr.from(Currency.class);
            cr.select(root).where(cb.equal(root.get("id"), id));
            currency = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return currency;
    }

    @Override
    public Currency findCurrencyBySymbol(String symbol) {
        Currency currency = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Currency> cr = cb.createQuery(Currency.class);
            Root<Currency> root = cr.from(Currency.class);
            cr.select(root).where(cb.equal(root.get("symbol"), symbol));
            currency = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return currency;
    }
}
