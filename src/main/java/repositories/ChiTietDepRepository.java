package repositories;

import java.util.List;
import javax.persistence.Query;
import models.ChiTietDep;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilities.HibernateUtil;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class ChiTietDepRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction transaction = session.getTransaction();

    public List<ChiTietDep> getAll() {
        return session.createCriteria(ChiTietDep.class).list();
    }

    public static void main(String[] args) {
        ChiTietDepRepository ctdr = new ChiTietDepRepository();
        System.out.println(ctdr.getAll().size());
    }

    public boolean save(ChiTietDep ctd) {
        try {
            transaction.begin();
            session.delete(ctd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(ChiTietDep ctd) {
        try {
            transaction.begin();
            session.delete(ctd);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<ChiTietDep> findByName(String ten) {
        Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.dep.ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        List<ChiTietDep> list = query.getResultList();
        return list;
    }

    public ChiTietDep getObjById(int id) {
        ChiTietDep ctd = null;
        try {
            Query query = session.createQuery("SELECT c FROM ChiTietDep c WHERE c.id = :id");
            query.setParameter("id", id);
            ctd = (ChiTietDep) query.getSingleResult();
        } catch (Exception e) {
        }
        return ctd;
    }
}