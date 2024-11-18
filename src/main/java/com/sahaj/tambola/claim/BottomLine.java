package com.sahaj.tambola.claim;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BottomLine implements Claim {
    @Override
    public boolean isValid(List<Integer> generatedSeq, int[][] ticket) {
        Set<Integer> generated = new HashSet<>(generatedSeq);
        for (int i = 0; i < 5; i++) {
            if(!generated.contains(ticket[2][i]))
                return false;
        }
        Integer lastAnnouncedNum = generatedSeq.get(generatedSeq.size() - 1);
        List<Integer> matchingSeq = Arrays.stream(ticket[2]).boxed().collect(Collectors.toList());
        return matchingSeq.contains(lastAnnouncedNum);
    }
}
