package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public List<Author> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    public Author findById(Long id){
        return entityManager.find(Author.class, id);
    }
}

