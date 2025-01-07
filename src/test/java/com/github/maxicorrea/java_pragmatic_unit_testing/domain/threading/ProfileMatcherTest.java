package com.github.maxicorrea.java_pragmatic_unit_testing.domain.threading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProfileMatcherTest {

    ProfileMatcher matcher = new ProfileMatcher();

    @Test
    void returnScoreForAllProfiles() throws InterruptedException, ExecutionException {
        var questions = createQuestions(50);
        int profileCount = 500;
        int half = profileCount / 2;
        IntStream.range(0, half).forEach(
                id -> matcher.addProfile(createProfile(questions, id, i -> nonMatchingAnswer(questions.get(i)))));
        IntStream.range(half, profileCount)
                .forEach(id -> matcher.addProfile(createProfile(questions, id, i -> matchingAnswer(questions.get(i)))));
        var criteria = createCriteria(questions);
        var results = matcher.scoreProfiles(criteria);
        assertEquals(half, results.values().stream().filter(score -> score == 0).count());
        assertEquals(half, results.values().stream().filter(score -> score > 0).count());
    }

    private Profile createProfile(
            List<BooleanQuestion> questions,
            int id,
            Function<Integer, Answer> answerFunction) {
        Profile profile = new Profile(String.valueOf(id));
        IntStream.range(0, questions.size()).forEach(i -> profile.add(answerFunction.apply(i)));
        return profile;
    }

    private Criteria createCriteria(List<BooleanQuestion> questions) {
        var questionCount = questions.size();
        var criteria = new Criteria();
        IntStream.range(0, 5)
                .forEach(i -> criteria.add(new Criterion(matchingAnswer(questions.get(i)), Weight.REQUIRED)));
        IntStream.range(5, questionCount)
                .forEach(i -> criteria.add(new Criterion(matchingAnswer(questions.get(i)), Weight.WOULD_PREFER)));
        return criteria;
    }

    private List<BooleanQuestion> createQuestions(int questionCount) {
        return IntStream.range(0, questionCount)
                .mapToObj(i -> new BooleanQuestion("question " + i))
                .toList();
    }

    private Answer matchingAnswer(Question question) {
        return new Answer(question, Boolean.TRUE);
    }

    private Answer nonMatchingAnswer(Question question) {
        return new Answer(question, Boolean.FALSE);
    }

}
