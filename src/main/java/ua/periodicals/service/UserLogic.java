package ua.periodicals.service;

import ua.periodicals.dao.AbstractUserDao;
import ua.periodicals.dao.EntityTransaction;
import ua.periodicals.dao.impl.UserDao;
import ua.periodicals.exception.DaoException;
import ua.periodicals.exception.LogicException;
import ua.periodicals.model.User;


public class UserLogic {

    public static User findByEmailAndPwdHash(String email, String pwdHash) {

        User user = null;

        AbstractUserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();

        try {
            transaction.begin(userDao);
            user = userDao.findByEmailAndPassword(email, pwdHash);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            throw new LogicException(e);
        } finally {

            try {
                transaction.end();
            } catch (DaoException e) {
                throw new LogicException(e);
            }
        }

        return user;

    }


    public static boolean create(User user) {

        boolean isCreated = false;

        AbstractUserDao userDao = new UserDao();
        EntityTransaction transaction = new EntityTransaction();

        transaction.begin(userDao);

        try {
            transaction.begin(userDao);
            isCreated = userDao.create(user);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.end();
        }

        return isCreated;

    }


}