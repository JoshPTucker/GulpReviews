package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Gulprestaurant;
import model.Gulpreview;
import model.Gulpuser;


public class RestaurantUtil {
	public static void insert(Gulprestaurant gulprestaurant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(  gulprestaurant);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Gulprestaurant gulprestaurant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge( gulprestaurant);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Gulprestaurant gulprestaurant) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge( gulprestaurant));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static List<Gulprestaurant> gulprestaurants (){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select b from Gulprestaurant b";
        
        List<Gulprestaurant> restaurants = null;
        try{
            TypedQuery<Gulprestaurant> query = em.createQuery(qString,Gulprestaurant.class);
            restaurants = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return restaurants;
    }
    public static Gulprestaurant getRestaurant(int restaurantid ) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Gulprestaurant  u where u.restaurantid = :restaurantid ";
		TypedQuery<Gulprestaurant > q = em.createQuery(qString, Gulprestaurant .class);
		q.setParameter("restaurantid", restaurantid );
		Gulprestaurant  restaurant  = null;
		try {
			restaurant  = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return restaurant ;
	}
}
