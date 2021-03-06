package de.ls5.wt2.aal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.ls5.wt2.entity.DBTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping(path = "rest")
public class LearningREST {

    @Autowired
    private EntityManager entityManager;

    @GetMapping(path = "reset",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public void reset() {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<DBTodos> query = builder.createQuery(DBTodos.class);
        final Root<DBTodos> from = query.from(DBTodos.class);
        query.select(from);

        final List<DBTodos> result = this.entityManager.createQuery(query).getResultList();
        for (DBTodos res : result) {
            entityManager.remove(res);
        }
    }
}
