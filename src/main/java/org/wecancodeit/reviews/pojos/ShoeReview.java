package org.wecancodeit.reviews.pojos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class ShoeReview {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 1000)
    private String imageUrl;
    private String review;

    @ManyToMany(mappedBy = "shoeReviews")
    private Collection<Hashtag> hashtags;
    @ManyToOne
    private BrandCategory brandCategory;
    @OneToMany(mappedBy = "shoeReview")
    private Collection<Comment> comments;

    protected ShoeReview() {
    }

    public ShoeReview(String name, String imageUrl, String review, BrandCategory brandCategory) {
        this.name = name;
        this.review = review;
        this.imageUrl = imageUrl;
        this.hashtags = new ArrayList<>();
        this.brandCategory = brandCategory;
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    public BrandCategory getBrandCategory() {
        return brandCategory;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "ShoeReview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + review + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", brandCategory=" + brandCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoeReview shoeReview = (ShoeReview) o;

        if (id != shoeReview.id) return false;
        if (name != null ? !name.equals(shoeReview.name) : shoeReview.name != null) return false;
        if (review != null ? !review.equals(shoeReview.review) : shoeReview.review != null) return false;
        if (imageUrl != null ? !imageUrl.equals(shoeReview.imageUrl) : shoeReview.imageUrl != null) return false;
        return brandCategory != null ? brandCategory.equals(shoeReview.brandCategory) : shoeReview.brandCategory == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (brandCategory != null ? brandCategory.hashCode() : 0);
        return result;
    }
}

