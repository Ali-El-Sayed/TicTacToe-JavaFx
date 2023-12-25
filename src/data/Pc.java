/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static java.lang.Math.random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author p&p
 */
public class Pc implements Playable {

    public Level level;
    

    public Pc(Level level) {
        this.level=level;
       
    }

    @Override
    public  int play(Set<Integer> keySet) {
      
        switch (level) {
            case EASY:
                return easyLevel(keySet);
//            case HARD:
//                return hardLevel(keySet);

        }
        return -1;
    }
    public int easyLevel(Set<Integer> keySet) {
        System.out.println("in easylevel");

        int randomIndex = new Random().nextInt(9)+1;

        while (true) {
            if (!keySet.contains(randomIndex)) {

                return randomIndex;
            } else {
                randomIndex = new Random().nextInt(9)+1;
            }

        }
    }
    public enum Level {
        EASY, MEDIUM, HARD
    };
}


  /*  public int hardLevel(Set<Integer> keySet) {
        System.out.println("in hardlevel");
            return findBestMove(keySet);
    }
     
int findBestMove(Set<Integer> keySet) {
    int bestMove = -1;
    int bestScore = Integer.MIN_VALUE;

    for (int i = 1; i <= 9; i++) {
        if (!keySet.contains(i)) {
            int score = minimax(keySet, 0, false);
            keySet.remove(i);

            if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }
    }

    return bestMove;
}
int minimax(Set<Integer> checkedBtns, int depth, boolean isMaximizing) {

    if (isMaximizing) {
        int bestScore = Integer.MIN_VALUE;
        for (int i = 1; i <= 9; i++) {
            if (!checkedBtns.contains(i)) {
                checkedBtns.add(i);
                bestScore = Math.max(bestScore, minimax(checkedBtns, depth + 1, false));
                checkedBtns.remove(i);
            }
        }
        return bestScore;
    } else {
        int bestScore = Integer.MAX_VALUE;
        for (int i = 1; i <= 9; i++) {
            if (!checkedBtns.contains(i)) {
                checkedBtns.add(i);
                bestScore = Math.min(bestScore, minimax(checkedBtns, depth + 1, true));
                checkedBtns.remove(i);
            }
        }
        return bestScore;
    }
}



}
*/

 


