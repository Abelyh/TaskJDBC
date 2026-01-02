package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    private long existByEmail(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Long> query = currentSession.createQuery("SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class);
        query.setParameter("email", user.getEmail());
        return query.uniqueResult();
    }

    @Override
    public void add(User user) {
        if (existByEmail(user) == 0) {
            sessionFactory.getCurrentSession().save(user);
        } else {
            System.out.println("A user with this email address already exists.");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> getUser(Car car) {
        Session currentSession = sessionFactory.getCurrentSession();
        TypedQuery<User> query = currentSession.createQuery("FROM User u WHERE u.car.model = :model AND u.car.series = :series", User.class);
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());
        return query.getResultList();
    }

}
