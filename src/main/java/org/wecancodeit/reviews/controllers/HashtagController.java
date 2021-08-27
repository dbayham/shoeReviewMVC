package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.storage.*;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private ShoeReviewStorage shoeReviewStorage;

    public HashtagController(HashtagStorage hashtagStorage, ShoeReviewStorage shoeReviewStorage) {
        this.hashtagStorage = hashtagStorage;
        this.shoeReviewStorage = shoeReviewStorage;
    }

    @PostMapping("/hashtags/add/{shoeReviewName}")
    public String createNewHashtag(@PathVariable String shoeReviewName, String hashtag) {
        ShoeReview shoeToGiveHashtag = shoeReviewStorage.retrieveShoeReviewByName(shoeReviewName);
        Hashtag createdHashtag = hashtagStorage.createOrRetrieveHashtag(hashtag);

        if(!createdHashtag.getShoeReviews().contains(shoeToGiveHashtag)) {
            createdHashtag.addShoeReview(shoeToGiveHashtag);
            hashtagStorage.saveHashtag(createdHashtag);
        }

        return "redirect:/brands/" + shoeToGiveHashtag.getBrandCategory().getId() + "/" + shoeReviewName;
    }

    @RequestMapping("/hashtags")
    public String displayAllHashtag(Model model) {

        Iterable<Hashtag> hashtags = hashtagStorage.getAllHashtags();
        model.addAttribute("hashtags", hashtags);


        return "all-hashtags";
    }

    @RequestMapping("/hashtags/{hashtagName}")
    public String displayHashtagReviews(@PathVariable String hashtagName, Model model) {

        Hashtag hashtag = hashtagStorage.retrieveHashtagByName(hashtagName);
        model.addAttribute("hashtag", hashtag);


        return "hashtagPage";
    }
}


