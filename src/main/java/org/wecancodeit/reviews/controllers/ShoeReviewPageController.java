package org.wecancodeit.reviews.controllers;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.pojos.Comment;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.repos.ShoeReviewRepository;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ShoeReviewStorage;

import java.util.Optional;

@Controller
public class ShoeReviewPageController {

    private ShoeReviewStorage shoeReviewStorage;
    private CommentStorage commentStorage;
    private HashtagStorage hashtagStorage;
    private ShoeReviewRepository shoeReviewRepo;

    public ShoeReviewPageController(ShoeReviewStorage shoeReviewStorage, CommentStorage commentStorage, HashtagStorage hashtagStorage, ShoeReviewRepository shoeReviewRepo) {
        this.shoeReviewStorage = shoeReviewStorage;
        this.commentStorage = commentStorage;
        this.hashtagStorage = hashtagStorage;
        this.shoeReviewRepo = shoeReviewRepo;
    }

    @RequestMapping("/brands/{id}/{shoeReviewName}")
    public String displayShoeReviewPage(@PathVariable Long id, @PathVariable String shoeReviewName, Model model) {
        ShoeReview shoeReview = shoeReviewStorage.retrieveShoeReviewByName(shoeReviewName);
//        ShoeReview foundShoe = shoeReview.get();
//         Optional<BrandCategory> brandCategory = brandCategoryRepository.findById(id);

        model.addAttribute("shoeReview", shoeReview);
        return "ShoeReviewPage";

    }
}
