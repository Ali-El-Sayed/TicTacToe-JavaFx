/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author p&p
 */
public class Player implements Playable{
    Playable play;
    Player(Playable playable){
       play=playable;
    }

    @Override
    public int play(Set<Integer> keySet) {
        return 0;
    }




    
    
}
