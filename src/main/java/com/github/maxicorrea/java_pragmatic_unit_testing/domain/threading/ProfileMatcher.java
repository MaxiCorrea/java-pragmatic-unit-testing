package com.github.maxicorrea.java_pragmatic_unit_testing.domain.threading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProfileMatcher {

    private List<Profile> profiles;
    private ExecutorService executorService;

    public ProfileMatcher() {
        profiles = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(8);
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public Map<Profile, Integer> scoreProfiles(Criteria criteria)
            throws InterruptedException, ExecutionException {
        List<Future<Map<Profile, Integer>>> futures = new ArrayList<>();

        for (Profile p : this.profiles) {
            futures.add(executorService.submit(() -> Map.of(p, p.matches(criteria) ? p.score(criteria) : 0)));
        }

        Map<Profile, Integer> scores = new HashMap<>();
        for (Future<Map<Profile, Integer>> future : futures)
            scores.putAll(future.get());

        executorService.shutdown();
        return scores;
    }

}
