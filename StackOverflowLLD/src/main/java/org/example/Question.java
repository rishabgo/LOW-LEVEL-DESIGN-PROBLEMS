package org.example;

import java.util.List;

public class Question {
    private final long id;
    private final String title;
    private final String content;

    //Making counter volatile so it doesn't cache this variable
    private volatile double voteCounter;
    private final List<Answer> answers;
    private final List<Tag> tags;
    private final User user;

    public Question(long id, String title, String content, double voteCounter, List<Answer> answers, List<Tag> tags, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.voteCounter = voteCounter;
        this.answers = answers;
        this.tags = tags;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public double getVoteCounter() {
        return voteCounter;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getUser() {
        return user;
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
}
