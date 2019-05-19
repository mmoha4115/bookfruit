package com.mohamed.bookfruit.models.data;

import com.mohamed.bookfruit.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * Created by Mohamed Mohamed
 */

@Repository
@Transactional
public interface CommentDao extends CrudRepository<Comment,Integer> {
}
