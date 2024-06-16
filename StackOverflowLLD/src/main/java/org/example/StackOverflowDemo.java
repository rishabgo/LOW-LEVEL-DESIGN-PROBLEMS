package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {

    public static void main(String[] args) {
        StackOverflow instance = StackOverflow.getInstance();

        // Register users
        User user1 = new User(1, "john", "john01", "password123", "john@example.com");
        User user2 = new User(2, "jane", "jane02", "password456", "jane@example.com");
        User user3 = new User(3, "joe", "joe03", "password789", "joe@example.com");
        instance.registerUser(user1);
        instance.registerUser(user2);

        Question question1 = new Question(1L, "Ways to Learn Java", "I am new to programming and want to learn Java. Can you share some tips on learning java?", 0,
                new ArrayList<>(), Arrays.asList(new Tag(1, "java"), new Tag(2, "programming")), user1);
       /* Question question2 = new Question(2L, "Ways to Learn Python", "1. Purchase Udemy Course 2.Read Head First Python Book", 0,
                new ArrayList<>(),  Arrays.asList(new Tag(1, "java"), new Tag(2, "programming")), user1);*/
        Answer answer1 = new Answer(1, "Watch youtube tutorial", user2, question1, 0, new ArrayList<>());
        Answer answer2 = new Answer(2, "Read Head First Java Book", user3, question1, 0, new ArrayList<>());

        //post question
        instance.postQuestion(question1);

        //post answers
        instance.postAnswer(answer1);
        instance.postAnswer(answer2);

        //upvote a question
        instance.upVoteQuestion(question1);

        //down vote an answer
        instance.downVoteAnswer(answer1);

        //upvote an answer
        instance.upVoteAnswer(answer2);

        //add comment
        Comment comment1 = new Comment(1, user2, "Watch Youtube video by Java Brains", LocalDateTime.now(), answer1);
        instance.addComment(comment1);

        List<Question> userQuestions = instance.getQuestionsByUser(user1);
        for (Question question : userQuestions) {
            System.out.println(question);
        }

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            instance.upVoteAnswer(answer2);
            System.out.println(answer2);
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance.downVoteAnswer(answer2);
            System.out.println(answer2);

        });

        thread1.start();
        thread2.start();
    }
}
