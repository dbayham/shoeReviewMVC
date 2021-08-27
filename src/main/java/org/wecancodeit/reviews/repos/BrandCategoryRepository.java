package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.pojos.BrandCategory;
import org.wecancodeit.reviews.pojos.ShoeReview;

import java.util.Collection;
import java.util.Optional;

public interface BrandCategoryRepository extends CrudRepository<BrandCategory, Long> {

    Optional<BrandCategory> findByName(String name);

}
