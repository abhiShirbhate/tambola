package com.sahaj.tambola.claim;

import java.util.List;

public interface Claim {
    boolean isValid(List<Integer> generatedSeq, int[][] ticket);
}
