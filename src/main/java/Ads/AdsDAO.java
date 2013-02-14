package Ads;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kibromk
 * Date: 2/10/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class AdsDAO{
    public static final String SELECT_QUERY = "from AdsEntity order by userId DESC";

    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new Ad:
    @Transactional
    public void persist(AdsEntity ads) {
        em.persist(ads);
    }

    // Retrieves all the Ads:

    public List<AdsEntity> getAllAds() {

         PersistenceProvider  persistenceProvider = new HibernatePersistence();
         EntityManagerFactory entityManagerFactory = persistenceProvider.
         createEntityManagerFactory("NewPersistenceUnit", new HashMap());
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         List<AdsEntity> users = entityManager.createQuery(SELECT_QUERY,AdsEntity.class).getResultList();

        return users;

 }
}
