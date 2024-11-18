package com.sahaj.tambola.claim;

import java.util.*;
import java.util.stream.Collectors;

public class EarlyFive implements Claim {
    @Override
    public boolean isValid(List<Integer> generatedSeq, int[][] ticket) {
        Set<Integer> generated = new HashSet<>(generatedSeq);
        List<Integer> matchingSeq = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for(int j=0; j<5; j++) {
                if (generated.contains(ticket[i][j]))
                     matchingSeq.add(ticket[i][j]);
            }
        }
        Integer lastAnnouncedNum = generatedSeq.get(generatedSeq.size() - 1);
        return matchingSeq.contains(lastAnnouncedNum) && matchingSeq.size() == 5;
    }
}
