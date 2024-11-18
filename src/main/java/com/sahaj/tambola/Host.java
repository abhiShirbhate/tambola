package com.sahaj.tambola;


import com.sahaj.tambola.claim.Claim;

import java.util.ArrayList;
import java.util.List;

public class Host {
    List<Integer> generatedSeq = new ArrayList<>();

    public boolean validate(int[][] ticket, Claim claim){
        return claim.isValid(generatedSeq, ticket);
    }
    
}
