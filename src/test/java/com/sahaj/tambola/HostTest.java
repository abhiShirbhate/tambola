package com.sahaj.tambola;

import com.sahaj.tambola.claim.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HostTest {

    @Test
    public void validateValidTopLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(1, 2, 3, 4, 5);
        assertTrue(host.validate(player1.ticket, new TopLine()));
    }

    @Test
    public void validateShouldRejectInvalidTopLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(1, 2, 3, 4, 7);
        assertFalse(host.validate(player1.ticket, new TopLine()));
    }

    @Test
    public void validateShouldAcceptValidMiddleLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(11, 1, 22, 33, 44, 55);
        assertTrue(host.validate(player1.ticket, new MiddleLine()));
    }

    @Test
    public void validateShouldRejectInvalidMiddleLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(1, 2, 3, 4, 7);
        assertFalse(host.validate(player1.ticket, new MiddleLine()));
    }

    @Test
    public void validateShouldAcceptValidBottomLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(21, 22, 33, 23, 24, 25);
        assertTrue(host.validate(player1.ticket, new BottomLine()));
    }

    @Test
    public void validateShouldRejectInvalidBottomLineClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(21, 22, 23, 24, 55, 66);
        assertFalse(host.validate(player1.ticket, new BottomLine()));
    }

    @Test
    public void validateShouldAcceptValidEarlyFiveClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(1, 2, 3, 4, 5);
        assertTrue(host.validate(player1.ticket, new EarlyFive()));
    }

    @Test
    public void validateShouldRejectEarlyFiveClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(21, 22, 23, 24, 55, 66);
        assertFalse(host.validate(player1.ticket, new EarlyFive()));
    }

    @Test
    public void validateShouldAcceptValidFullHouseClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(11, 22, 33, 44, 1, 2, 3, 4, 55, 5, 21, 22, 23, 24, 25);
        assertTrue(host.validate(player1.ticket, new FullHouse()));
    }

    @Test
    public void validateShouldRejectInvalidFullHouseClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(21, 22, 23, 24, 55, 66);
        assertFalse(host.validate(player1.ticket, new FullHouse()));
    } @Test

    public void validateShouldRejectValidFullHouseLateClaim() {
        Host host = new Host();
        int[][] ticket1 = {{1, 2, 3, 4, 5}, {11, 22, 33, 44, 55}, {21, 22, 23, 24, 25}};
        Player player1 = new Player("Player1", ticket1);
        host.generatedSeq = List.of(11, 22, 33, 44, 1, 2, 3, 4, 55, 5, 21, 22, 23, 24, 25, 66);
        assertFalse(host.validate(player1.ticket, new FullHouse()));
    }


}