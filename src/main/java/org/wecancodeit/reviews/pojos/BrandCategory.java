package org.wecancodeit.reviews.pojos;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class BrandCategory {
    @Id
    @GeneratedValue

    private long id;
    private String name;
    private String description;
    private String imageUrl;

    @OneToMany(mappedBy = "brandCategory")
    private Collection<ShoeReview> shoeReviews;

    protected BrandCategory(){
    }

    //constructor
    public BrandCategory(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.shoeReviews = new ArrayList<>();
    }


    //getters


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Collection<ShoeReview> getShoeReviews() {
        return shoeReviews;
    }

    public void addToShoeReviews(ShoeReview shoeReview) {
        shoeReviews.add(shoeReview);
    }

    @Override
    public String toString() {
        return "BrandCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description= '" + description + '\'' +
                ", shoeReviews=" + shoeReviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandCategory brandCategory = (BrandCategory) o;

        if (id != brandCategory.id) return false;
        if (name != null ? !name.equals(brandCategory.name) : brandCategory.name != null) return false;
        return imageUrl != null ? imageUrl.equals(brandCategory.imageUrl) : brandCategory.imageUrl == null;
    }
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}







