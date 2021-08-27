package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.pojos.ShoeReview;

import java.util.Optional;

public interface ShoeReviewRepository extends CrudRepository<ShoeReview, Long> {
    Optional<ShoeReview> findByName(String name);
}
