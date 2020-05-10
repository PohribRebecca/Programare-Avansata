package com.example.demo3;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/games")
public class GamesController {
    private final List<Game> games = new ArrayList<>();

    public GamesController() {
        games.add(new Game("2.21.1111", "dada","3"));
        games.add(new Game("2.21.1111", "dada","3"));
    }
    private Game findByData(String date) {
        List<Game> result = games.stream()
                .filter(item -> item.data.equals(date))
                .collect(Collectors.toList());
        return (Game) result;
    }

    @GetMapping
    public List<Game> getGames() {
        return games;
    }
}
