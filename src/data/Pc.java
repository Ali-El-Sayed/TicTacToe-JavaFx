
package data;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;


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
            case HARD:
               return hardLevel(keySet);

        }
        return -1;
    }
    public int easyLevel(Set<Integer> keySet) {
        //System.out.println("in easylevel");

        int randomIndex = new Random().nextInt(9)+1;

        while (true) {
            if (!keySet.contains(randomIndex)) {

                return randomIndex;
            } else {
                randomIndex = new Random().nextInt(9)+1;
            }

        }
    }
    
    
    
    public int hardLevel(Set<Integer> keySet) {
        System.out.println("in hardlevel");
            return findBestMove(keySet);
    }
     
static int findBestMove(Set<Integer> occupiedPositions) {
    int bestMove = 1;
    int bestScore = Integer.MIN_VALUE;
    Set<Integer> clonedSet = new HashSet<>(occupiedPositions);

    for (int i = 1; i <= 9; i++) {
        if (!clonedSet.contains(i)) {
            clonedSet.add(i);
            int score = minimax(clonedSet, 0, false);
            clonedSet.remove(i);

            if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }
    }

    return bestMove;
}




static int minimax(Set<Integer> occupiedPositions, int depth, boolean isMaximizing) {
    if (depth >= 9) {
        // Assuming 9 is the maximum depth for a 3x3 tic-tac-toe board
        return 0; // Evaluate the current state
    }

    if (isMaximizing) {
        int bestScore = Integer.MIN_VALUE;
        for (int i = 1; i <= 9; i++) {
            if (!occupiedPositions.contains(i)) {
                Set<Integer> newPosition = new LinkedHashSet<>(occupiedPositions);
                newPosition.add(i);
                bestScore = Math.max(bestScore, minimax(newPosition, depth + 1, false));
            }
        }
        return bestScore;
    } else {
        int bestScore = Integer.MAX_VALUE;
        for (int i = 1; i <= 9; i++) {
            if (!occupiedPositions.contains(i)) {
                Set<Integer> newPosition = new LinkedHashSet<>(occupiedPositions);
                newPosition.add(i);
                bestScore = Math.min(bestScore, minimax(newPosition, depth + 1, true));
            }
        }
        return bestScore;
    }
}





    public enum Level {
        EASY, MEDIUM, HARD
    };
}


 

 


