package com.sahaj.tambola.claim;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullHouse implements Claim {
    @Override
    public boolean isValid(List<Integer> generatedSeq, int[][] ticket) {
        boolean isOnTimeClaim = false;
        Integer lastAnnouncedNum = generatedSeq.get(generatedSeq.size() - 1);

        Set<Integer> generated = new HashSet<>(generatedSeq);
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                isOnTimeClaim = isOnTimeClaim || lastAnnouncedNum == ticket[i][j];
                if (!generated.contains(ticket[i][j]))
                    return false;
            }
        }
        return isOnTimeClaim;
    }
}
