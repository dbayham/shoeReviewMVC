package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.storage.BrandCategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;

@Controller
public class MainPageController {

    private BrandCategoryStorage brandCategoryStorage;
    private HashtagStorage hashtagStorage;

    public MainPageController(BrandCategoryStorage brandCategoryStorage, HashtagStorage hashtagStorage) {
        this.brandCategoryStorage = brandCategoryStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/")
    public String displayMainPage(Model model) {
        model.addAttribute("brandCategories", brandCategoryStorage);
        model.addAttribute("hashtags", hashtagStorage);

        return "index";
    }

    @PostMapping("/add-hashtag")
    public String addHashtag(String hashtag) {
        hashtag = hashtag.replace("#","");
        if(hashtagStorage.retrieveHashtagByName(hashtag) == null) {
            if(hashtag.length() !=0) {
                Hashtag hash = new Hashtag(hashtag);
                hashtagStorage.saveHashtag(hash);
            }
        }

        return "redirect:/#hashtags__name";

    }
}