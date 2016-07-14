package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Gulprestaurant;
import model.Gulpreview;

public class ReviewUtil {
	 public static void insert(Gulpreview gulpreview) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.persist( gulpreview);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }

	    public static void update(Gulpreview gulpreview) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.merge(gulpreview);
	            trans.commit();
	        } catch (Exception e) {
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }

	    public static void delete(Gulpreview gulpreview) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction trans = em.getTransaction();
	        try {
	            trans.begin();
	            em.remove(em.merge( gulpreview));
	            trans.commit();
	        } catch (Exception e) {
	            System.out.println(e);
	            trans.rollback();
	        } finally {
	            em.close();
	        }
	    }
	    public static List<Gulpreview> gulpreviews (){
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        String qString = "select b from Gulpreview b";
	        
	        List<Gulpreview> reviews = null;
	        try{
	            TypedQuery<Gulpreview> query = em.createQuery(qString,Gulpreview.class);
	            reviews = query.getResultList();

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return reviews;
	    }
	    
	    public static List<Gulpreview> usersReviews(long userid)
	    {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        List<Gulpreview> userposts = null;
	        String qString = "select b from Gulpreview b where b.gulpuser.userid = :userid";
	        
	        try{
	            TypedQuery<Gulpreview> query = em.createQuery(qString,Gulpreview.class);
	            query.setParameter("userid", userid);
	            userposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return userposts;    
	    }
	    public static List<Gulpreview> restaurantReviews(long restaurantid)
	    {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        List<Gulpreview> reviews = null;
	        String qString = "select b from Gulpreview b where b.gulprestaurant.restaurantid = :restaurantid";
	        
	        try{
	            TypedQuery<Gulpreview> query = em.createQuery(qString,Gulpreview.class);
	            query.setParameter("restaurantid", restaurantid);
	            reviews = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return reviews;    
	    }
	  
}
