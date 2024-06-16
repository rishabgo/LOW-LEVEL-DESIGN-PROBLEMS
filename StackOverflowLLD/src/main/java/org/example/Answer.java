package org.example;

import java.util.List;

public class Answer {
    private final long id;
    private final String content;
    private final User user;
    private final Question question;
    private double voteCounter;
    private boolean canBeChecked;
    private final List<Comment> comments;


    public Answer(long id, String content, User user, Question question, double voteCounter, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.question = question;
        this.voteCounter = voteCounter;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public double getVoteCounter() {
        return voteCounter;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void upVote() {
        synchronized (this) {
            this.voteCounter++;
        }
    }

    public void downVote() {
        synchronized (this) {
            this.voteCounter--;
        }
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", question=" + question +
                ", voteCounter=" + voteCounter +
                ", canBeChecked=" + canBeChecked +
                ", comments=" + comments +
                '}';
    }
}
