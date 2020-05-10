package com.example.demo3;
import javax.persistence.*;


@Entity
@Table(name="players")
 class Players {
    private @Id  @GeneratedValue
    int id;
    @Column
    String name;
    @Column
    int gamePlayed;
    Players(){}
     Players(String name, int gamePlayed) {
        this.name = name;
        this.gamePlayed = gamePlayed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }
}
