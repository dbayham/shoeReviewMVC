package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.pojos.BrandCategory;
import org.wecancodeit.reviews.pojos.Comment;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.ShoeReview;
import org.wecancodeit.reviews.repos.BrandCategoryRepository;
import org.wecancodeit.reviews.repos.CommentRepository;
import org.wecancodeit.reviews.repos.HashtagRepository;
import org.wecancodeit.reviews.repos.ShoeReviewRepository;
import org.wecancodeit.reviews.storage.BrandCategoryStorage;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private ShoeReviewRepository shoeReviewRepo;
    @Autowired
    private BrandCategoryRepository brandCategoryRepo;
    @Autowired
    private HashtagRepository hashtagRepo;
    @Autowired
    private CommentRepository commentRepo;


    public Populator(ShoeReviewRepository shoeReviewRepo, BrandCategoryRepository brandCategoryRepo, HashtagRepository hashtagRepo,
                     CommentRepository commentRepo){
        this.shoeReviewRepo = shoeReviewRepo;
        this.brandCategoryRepo = brandCategoryRepo;
        this.hashtagRepo = hashtagRepo;
        this.commentRepo = commentRepo;
    }


    @Override
    public void run(String... args) throws Exception {
        BrandCategory nike = new BrandCategory("Nike","Just Do It", "images/Nike Air Force 1s.jpeg");
        BrandCategory adidas= new BrandCategory("Adidas","Impossible Is Nothing","images/adidasShellToes.jpg");


        ShoeReview runningNike = new ShoeReview("Zoom Pegasus 38",
                "/images/nikeshoes/air-max-97-mens-shoe-SD3ZmW.jpeg",
                "Your workhorse with wings returns", nike);


        ShoeReview runningAdidas = new ShoeReview("Ultraboost 5.0 DNA", "/images/adidasShoes/adidasUltraboost_5.0_DNA_Shoes_Orange_G54961_01_standard.jpg",
                "Every run is a fresh start, but that doesn't mean you start from zero.", adidas);

        ShoeReview lifestyleNike = new ShoeReview("Nikw Blazer Mid '77 Vintage",
                "/images/nikeshoes/blazer-mid-77-vintage-mens-shoe-nw30B2.jpg",
                "Praised by the streets for keeping it simple yet comfortable", nike);

        ShoeReview lifestyleAdidas = new ShoeReview("ZX 1K Boost",
                "/images/adidasShoes/adidasZX_1K_Boost_Shoes_Blue_H68720_01_standard.jpg",
                "ZX-A lightweight ripstop upper accented with synthetic suede keeps the look casual", adidas);

        ShoeReview budgetNike = new ShoeReview("Challenger OG",
                "/images/nikeshoes/challenger-og-mens-shoe-wrhSPb.jpg",
                "Nearly a 1-to-1 remake of the OG running shoe that offered runners a distinct look in the '70r",nike);

        ShoeReview budgetAdidas = new ShoeReview("Lite Racer Adapt 4.0",
                "/images/adidasShoes/adidLite_Racer_Adapt_4.0_Shoes_Red_H04806_01_standard.jpg",
                "Casual style that's easy to get on and off.", adidas);

        ShoeReview endorsementNike = new ShoeReview("Jordan 6 Rings",
                "/images/nikeshoes/jordan-6-rings-mens-shoe-2VAD3Y.jpg",
                "Celebrate the legendary career of \"His Airness\" with the Jordan 6 Rings. ", nike);

        ShoeReview endorsementAdidas = new ShoeReview("Yeezy Boost 250 VP",
                "/images/adidasShoes/adidasYEEZY_BOOST_350_V2_MONO_CINDER_GX3791_GX3791_04_standard.jpg",
                "Yeezy", adidas);


        brandCategoryRepo.save(nike);
        brandCategoryRepo.save(adidas);

        shoeReviewRepo.save(budgetNike);
        shoeReviewRepo.save(budgetAdidas);

        shoeReviewRepo.save(runningNike);
        shoeReviewRepo.save(runningAdidas);

        shoeReviewRepo.save(lifestyleNike);
        shoeReviewRepo.save(lifestyleAdidas);

        shoeReviewRepo.save(endorsementNike);
        shoeReviewRepo.save(endorsementAdidas);


        Hashtag running = new Hashtag("running");
        running.addShoeReview(runningNike);
        running.addShoeReview(runningAdidas);
        running.addShoeReview(lifestyleNike);
        running.addShoeReview(lifestyleAdidas);

        Hashtag lifestyle = new Hashtag("lifestyle");
        lifestyle.addShoeReview(lifestyleNike);
        lifestyle.addShoeReview(lifestyleAdidas);

        Hashtag budget = new Hashtag("budget");
        budget.addShoeReview(budgetNike);
        budget.addShoeReview(budgetAdidas);
        budget.addShoeReview(lifestyleNike);
        budget.addShoeReview(lifestyleAdidas);

        Hashtag endorsement = new Hashtag("endorsement");
        endorsement.addShoeReview(endorsementNike);
        endorsement.addShoeReview(endorsementAdidas);

        hashtagRepo.save(running);
        hashtagRepo.save(lifestyle);
        hashtagRepo.save(budget);
        hashtagRepo.save(endorsement);

        Comment runningNikeComment = new Comment("Benny 'The Jet' Rodriguez", "These shoes don't compare to my PF Flyers", runningNike);
        commentRepo.save(runningNikeComment);

        Comment lifestyleAdidasComment = new Comment("Michael Smith", "I absolutely love these shoes", lifestyleAdidas);
        commentRepo.save(lifestyleAdidasComment);
    }
}
