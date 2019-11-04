package persistance;

import daos.UsersDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.models.Users;

/**
 *
 * @author mitta
 */
public class UsersDaoImpl implements UsersDao{

    @Override
    public Users get(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List users = null;
        try{
            tx = session.beginTransaction();
            String sql = "SELECT * FROM USERS WHERE username = :username AND password = :password";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            users = query.list();
            tx.commit();
        }catch (HibernateException e) {
            if(tx!=null) tx.rollback();
        }finally{
            session.close();
            if(users.isEmpty()){
                return null;
            }else {
                return (Users) users.get(0);
            }
        }
    }

    @Override
    public Integer create(Users user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;
        
        try{
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return userID;
    }
}