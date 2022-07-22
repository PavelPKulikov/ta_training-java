package com.epam.rd.autotasks;

import java.util.List;

public class battle {
    public static void main(String[] args) {
        long map = 0b01000000_01000000_01000000_01000000_00001110_00000001_00000100_00000000L;

        Battleship8x8 battle = new Battleship8x8(map);

        battle.shoot("A1");
        battle.shoot("B7");
        battle.shoot("A5");
        battle.shoot("H4");
        battle.shoot("H1");
        battle.shoot("D3");
        System.out.println(battle.state());


    }
}
