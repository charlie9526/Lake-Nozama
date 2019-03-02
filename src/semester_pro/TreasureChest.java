
package semester_pro;


class TreasureChest {                                                           //this is the treasurer chest class

    private boolean isTaken;
    private Warrior winner;

    public static void setChest(Lake x) {                                       // from this method we can put the treasurer chest in the lake
        x.addObject(new TreasureChest(), 5, 5, 0);
    }

    public boolean getIsTaken() {                                               //when warrior get the treasurer chest this boolean variable become true
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {                                   //from this method warrior can get the chest
        this.isTaken = isTaken;
    }


    public Warrior getWinner() {
        return winner;
    }

    public void setWinner(Warrior winner) {                                     //afetr the chest is taken then a winner is set and all threads are stopped.
        this.winner = winner;
        System.out.println("my dear " + winner.name+ " won...yeeeeahs");
        

    }
}