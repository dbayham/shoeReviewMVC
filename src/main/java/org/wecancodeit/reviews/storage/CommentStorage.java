package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.pojos.Comment;
import org.wecancodeit.reviews.repos.CommentRepository;

@Service
public class CommentStorage {
    private CommentRepository commentRepo;

    public CommentStorage(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    public void saveComment(Comment comment) {
        commentRepo.save(comment);
    }

    public Iterable<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}


