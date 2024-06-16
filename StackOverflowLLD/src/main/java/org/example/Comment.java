package org.example;

import java.time.LocalDateTime;

public class Comment {
    private final int id;
    private final User user;
    private final String content;
    private final LocalDateTime dateTime;
    private final Answer answer;

    public Comment(int id, User user, String content, LocalDateTime dateTime, Answer answer) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.dateTime = dateTime;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", answer=" + answer +
                '}';
    }
}
