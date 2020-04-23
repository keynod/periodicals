package ua.periodicals.service;

import ua.periodicals.dao.AbstractPeriodicalDao;
import ua.periodicals.dao.EntityTransaction;
import ua.periodicals.dao.impl.PeriodicalDao;
import ua.periodicals.exception.DaoException;
import ua.periodicals.model.Periodical;

import java.util.ArrayList;
import java.util.List;

public class PeriodicalLogic {

    public static List<Periodical> findAll() {

        List<Periodical> periodicals = new ArrayList<>();

        AbstractPeriodicalDao periodicalDao = new PeriodicalDao();
        EntityTransaction transaction = new EntityTransaction();

        try {
            transaction.begin(periodicalDao);
            periodicals = periodicalDao.findAll();
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.end();
        }

        return periodicals;

    }
}