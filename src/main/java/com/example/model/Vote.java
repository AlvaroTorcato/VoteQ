package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean vote;


    private int reviewId;

    private int userId;

    public Vote(boolean vote, int reviewId, int userId) {
        this.vote = vote;
        this.reviewId = reviewId;
        this.userId = userId;
    }

    public Vote() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", vote=" + vote +
                ", reviewId=" + reviewId +
                ", userId=" + userId +
                '}';
    }
}
