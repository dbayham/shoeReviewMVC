package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.ShoeNotFoundException;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.repos.ShoeReviewRepository;

import java.util.Optional;

@Service
public class ShoeReviewStorage {
    private ShoeReviewRepository shoeReviewRepo;

    public ShoeReviewStorage(ShoeReviewRepository shoeReviewRepo) {
        this.shoeReviewRepo = shoeReviewRepo;
    }

    public void saveShoeReview(ShoeReview shoeReview){
        shoeReviewRepo.save(shoeReview);
    }

    public Iterable<ShoeReview> getAllShoeReviews() {
        return shoeReviewRepo.findAll();
    }
    public ShoeReview retrieveShoeReviewByName(String name) {
        ShoeReview retrievedShoeReview;
        Optional<ShoeReview> shoeReviewOptional = shoeReviewRepo.findByName(name);
        if(!shoeReviewOptional.isEmpty()) {
            retrievedShoeReview = shoeReviewOptional.get();
        }
        else {
            throw new ShoeNotFoundException("Cannot find review with name " + name);
        }

        return retrievedShoeReview;
    }
}

