package org.wecancodeit.reviews.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String hashtag;

    @ManyToMany
    private Collection<ShoeReview> shoeReviews;


    public void setShoeReviews(Collection<ShoeReview> shoeReviews) {
        this.shoeReviews = shoeReviews;
    }

    public Hashtag(String name) {
        this.name = name;
        this.shoeReviews = new ArrayList<>();
        this.hashtag = "#";
    }

    protected Hashtag() {}

    public long getId() {
        return id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getName() {
        return name;
    }

    public Collection<ShoeReview> getShoeReviews() {
        return shoeReviews;
    }

    public void addShoeReview(ShoeReview shoeReview) {shoeReviews.add(shoeReview);}
}