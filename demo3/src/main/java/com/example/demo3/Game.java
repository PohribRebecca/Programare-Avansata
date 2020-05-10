package com.example.demo3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="games")
public class Game {
    @Id
    private int id;

    @Column
    String data;
    @Column
    String content;
    @Column
    String result;

    public Game(String data, String content, String result) {

        this.data = data;
        this.content = content;
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
