/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.WaterJug;

import core.IAction;
import core.State;

import java.util.ArrayList;
import java.util.Collection;


public class ThreeTwo implements IAction {


    Collection<State> newStates = new ArrayList<>();

    @Override
    public Collection<State> apply(State s) {
        WaterState wt = (WaterState) s;
        int dif = wt.jugsSizes[1] - wt.jugs[1];

        if (dif > 0 && wt.jugs[2] > 0) {
            WaterState newState = new WaterState();

            for (int i = 0; i < 3; i++) {
                newState.jugs[i] = wt.jugs[i];
            }
            newState.jugsSizes = wt.jugsSizes;

            if (dif >= wt.jugs[2]) {

                newState.jugs[1] = wt.jugs[1] + wt.jugs[2];
                newState.jugs[2] = 0;
            } else {
                newState.jugs[2] = wt.jugs[2] - dif;
                newState.jugs[1] = wt.jugs[1] + dif;
            }
            newStates.add(newState);
        }
        return newStates;
    }


    @Override
    public String getName() {
        return "Third Jug In The Second";
    }
}
