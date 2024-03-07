package com.example.secondRest;

import jakarta.persistence.*;

@Entity
@Table(name="heros_list")
public class HeroEntity {
@Id

@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int SNO;

    private String Name;

    private int Film_List;

    private int Flops;

    private int Hits;

    public int getSNO() {
        return SNO;
    }

    public void setSNO(int SNO) {
        this.SNO = SNO;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getFilm_List() {
        return Film_List;
    }

    public void setFilm_List(int film_List) {
        Film_List = film_List;
    }

    public int getFlops() {
        return Flops;
    }

    public void setFlops(int flops) {
        Flops = flops;
    }

    public int getHits() {
        return Hits;
    }

    public void setHits(int hits) {
        Hits = hits;
    }
}
