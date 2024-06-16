package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class StackOverflow {
    private final Map<Long, User> usersMap = new ConcurrentHashMap<>();
    private final Map<Long, Question> questionsMap = new ConcurrentHashMap<>();

    private static StackOverflow instance = null;

    private StackOverflow() {
    }

    public static StackOverflow getInstance() {
        if (instance == null) {
            synchronized (StackOverflow.class) {
                if (instance == null)
                    instance = new StackOverflow();
            }
        }
        return instance;
    }

    public void registerUser(User user) {
        usersMap.put(user.getId(), user);
    }

    public void postQuestion(Question question) {
        questionsMap.put(question.getId(), question);
    }

    public void postAnswer(Answer answer) {
        Question question = answer.getQuestion();
        question.getAnswers().add(answer);
    }

    public void upVoteQuestion(Question question) {
        System.out.println("Up voting Question id: " + question.getId());
        question.upVote();
    }

    public void downVoteQuestion(Question question) {
        question.downVote();
    }

    public void upVoteAnswer(Answer answer) {
        System.out.println("Up voting answer id: " + answer.getId());
        answer.upVote();

    }

    public void downVoteAnswer(Answer answer) {
        System.out.println("Down voting answer id: " + answer.getId());
        answer.downVote();
    }

    public List<Question> getQuestionsByTag(String tagName) {
        List<Question> results = new ArrayList<>();
        for (Question question : questionsMap.values()) {
            List<Tag> tags = question.getTags();
            if (tags.stream().anyMatch(tag -> tag.getName().equalsIgnoreCase(tagName))) {
                results.add(question);
            }
        }
        return results;
    }

    public List<Question> searchQuestions(String query) {
        return questionsMap.values().stream()
                .filter(question -> (question.getTitle().contains(query) || question.getContent().contains(query)))
                .toList();
    }

    public List<Question> getQuestionsByUser(User user) {
        return questionsMap.values().stream()
                .filter(question -> question.getUser().equals(user))
                .toList();
    }

    public void addComment(Comment comment) {
        Answer answer = comment.getAnswer();
        answer.getComments().add(comment);
    }
}
