package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.ShoeNotFoundException;
import org.wecancodeit.reviews.pojos.BrandCategory;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.repos.BrandCategoryRepository;

import java.util.Collection;
import java.util.Optional;


@Service
public class BrandCategoryStorage {
    private BrandCategoryRepository brandCategoryRepo;

    public BrandCategoryStorage(BrandCategoryRepository brandCategoryRepo){
        this.brandCategoryRepo = brandCategoryRepo;
    }

    public void saveBrandCategory(BrandCategory brandCategory){
        brandCategoryRepo.save(brandCategory);
    }

    public Iterable<BrandCategory> getAllBrandCategories() {
        return brandCategoryRepo.findAll();
    }

    public BrandCategory retrieveById(long id) {
        BrandCategory retrieveBrandCategory;
        Optional<BrandCategory> brandCategoryOptional = brandCategoryRepo.findById(id);
        if (!brandCategoryOptional.isEmpty()) {
            retrieveBrandCategory = brandCategoryOptional.get();
        } else {
            retrieveBrandCategory = null;
        }

        return retrieveBrandCategory;
    }
    public BrandCategory retrieveBrandCategoryByName(String name) {
        BrandCategory retrievedBrandCategory;
        Optional<BrandCategory> brandCategoryOptional = brandCategoryRepo.findByName(name);
        if(!brandCategoryOptional.isEmpty()) {
            retrievedBrandCategory = brandCategoryOptional.get();
        }
        else {
            throw new ShoeNotFoundException("Shoe" + name + " does not exist, sorry!");
        }
        return retrievedBrandCategory;
    }

    public Collection<ShoeReview> getShoeReviewsStorage(String name) {
        BrandCategory selectedBrandCategory = brandCategoryRepo.findByName(name).get();
        Collection<ShoeReview> shoeReviews = selectedBrandCategory.getShoeReviews();
        return shoeReviews;

    }
}
