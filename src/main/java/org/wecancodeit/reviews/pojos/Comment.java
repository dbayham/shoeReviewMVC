package org.wecancodeit.reviews.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @GeneratedValue
    @Id
    private long id;
    private String trollName;
    private String remark;
    @ManyToOne
    private ShoeReview shoeReview;

    public Comment(String trollName, String remark, ShoeReview shoeReview) {
        this.trollName = trollName;
        this.remark = remark;
        this.shoeReview = shoeReview;
    }
    protected Comment() {
    }

    public void addShoeReview(){

    }

    public long getId() {
        return id;
    }

    public String getTrollName() {
        return trollName;
    }

    public String getRemark() {
        return remark;
    }

    public ShoeReview getShoeReview() {
        return shoeReview;
    }
}

