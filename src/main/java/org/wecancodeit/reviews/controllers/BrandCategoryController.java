package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.pojos.BrandCategory;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.repos.BrandCategoryRepository;
import org.wecancodeit.reviews.storage.BrandCategoryStorage;
import org.wecancodeit.reviews.storage.ShoeReviewStorage;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class BrandCategoryController {

    private BrandCategoryStorage brandCategoryStorage;
    private ShoeReviewStorage shoeReviewStorage;
    private BrandCategoryRepository brandCategoryRepository;

    public BrandCategoryController(BrandCategoryStorage brandCategoryStorage, ShoeReviewStorage shoeReviewStorage, BrandCategoryRepository brandCategoryRepository) {
        this.brandCategoryStorage = brandCategoryStorage;
        this.shoeReviewStorage = shoeReviewStorage;
        this.brandCategoryRepository = brandCategoryRepository;
    }

    @RequestMapping("/brands/{id}")
    public String displayShoeReviewPage(@PathVariable Long id, Model model) {

        Optional<BrandCategory> brandCategory = brandCategoryRepository.findById(id);
        BrandCategory brand = brandCategory.get();
        Collection<ShoeReview> shoeReviewList = brandCategoryStorage.getShoeReviewsStorage(brand.getName());

       model.addAttribute("brandCategory", brand);
        model.addAttribute("shoeReviewList", shoeReviewList);
        return "BrandsPage";
    }
}