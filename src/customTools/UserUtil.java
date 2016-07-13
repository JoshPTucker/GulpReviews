package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Gulpreview;
import model.Gulpuser;

public class UserUtil {
	public static void insert(Gulpuser gulpuser) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(gulpuser);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Gulpuser gulpuser) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge( gulpuser);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Gulpuser gulpuser) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(gulpuser));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static Gulpuser getUserByEmail(String useremail) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Gulpuser u " + "where u.useremail= :useremail";
		TypedQuery<Gulpuser> q = em.createQuery(qString, Gulpuser.class);
		q.setParameter("useremail", useremail);
		Gulpuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;
	}

	public static boolean isValidUser(Gulpuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.userid) from Gulpuser b" + " where b.useremail= :useremail "
				+ "and b.userpassword = :userpass";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		try {
			q.setParameter("useremail", user.getUseremail());
			q.setParameter("userpass", user.getUserpassword());
		} catch (Exception e) {
			result = false;
		}
		try {
			long userId = q.getSingleResult();
			if (userId > 0) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	public static List<Gulpuser> gulpusers (){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gulpuser b";
        
        List<Gulpuser> users = null;
        try{
            TypedQuery<Gulpuser> query = em.createQuery(qString,Gulpuser.class);
            users = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return users;
    }
}
