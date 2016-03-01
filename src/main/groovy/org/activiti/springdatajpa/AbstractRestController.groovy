package org.activiti.springdatajpa

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import static org.springframework.web.bind.annotation.RequestMethod.*

/**
 * Abstract controller to be inherited by other rest controllers
 *
 * Created by lvargas on 11/23/15.
 */
abstract class AbstractRestController<R extends JpaRepository, T, ID extends Serializable> {
    private Logger logger = LoggerFactory.getLogger(AbstractRestController.class);

    @Autowired R repo;

    @RequestMapping(value = "/{id}")
    T findOne(@PathVariable ID id,
              @AuthenticationPrincipal User user) {
        (T) repo.findOne(id);
    }

    @RequestMapping
    public Iterable<T> findAll(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer size,
                               @AuthenticationPrincipal User user) {
        if(page == null || size == null) return repo.findAll()

        repo.findAll(new PageRequest(page, size))
    }

    @RequestMapping(method = POST)
    T create(@RequestBody T entity,
             @AuthenticationPrincipal User user) {
        repo.save entity
    }


    @RequestMapping(value = "/{id}", method = PUT)
    T update(@PathVariable ID id,
             @RequestBody T json,
             @AuthenticationPrincipal User user) {
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        T entity = (T) repo.findOne(id)
        try {
            BeanUtils.copyProperties(entity, json);
        }
        catch (Exception e) {
            logger.warn("while copying properties", e);
//            throw Throwables.propagate(e);
        }

        logger.debug("merged entity: {}", entity);

        repo.save entity
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    void delete(@PathVariable ID id,
                @AuthenticationPrincipal User user) {
        repo.delete id
    }
}
