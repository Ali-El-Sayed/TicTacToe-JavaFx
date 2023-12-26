package data;

import java.util.Set;

public class Player implements Playable {

    Playable play;

    Player(Playable playable) {
        play = playable;
    }

    @Override
    public int play(Set<Integer> keySet) {
        return 0;
    }

}
