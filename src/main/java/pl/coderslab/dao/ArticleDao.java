package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> findFiveArticles(){
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        return query.setMaxResults(5).getResultList();
    }
}
