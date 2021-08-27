package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviews.pojos.Comment;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.ShoeReviewStorage;

@Controller
public class CommentController {
    private CommentStorage commentStorage;
    private ShoeReviewStorage shoeReviewStorage;

    public CommentController(CommentStorage commentStorage, ShoeReviewStorage shoeReviewStorage) {
        this.commentStorage = commentStorage;
        this.shoeReviewStorage = shoeReviewStorage;
    }

    @PostMapping("/comments/add/{shoeReviewName}")
    public String createNewComment(@PathVariable String shoeReviewName, String comment, String name) {
        ShoeReview shoeToGiveComment = shoeReviewStorage.retrieveShoeReviewByName(shoeReviewName);
        Comment createdComment = new Comment(name, comment, shoeToGiveComment);


        commentStorage.saveComment(createdComment);

        return "redirect:/brands/" + shoeToGiveComment.getBrandCategory().getId() + "/" + shoeReviewName;
    }
}
