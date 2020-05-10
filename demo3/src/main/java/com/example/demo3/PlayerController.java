package com.example.demo3;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final List<Players> players = new ArrayList<>();

    public PlayerController() {
        players.add(new Players("ana", 3));
        players.add(new Players("mere", 3));
    }
    private Players findByName(String name) {
        List<Players> result = players.stream()
                .filter(item -> item.name.equals(name))
                .collect(Collectors.toList());
        return (Players) result;
    }

    @GetMapping
    public List<Players> getPlayers() {
        return players;
    }


    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String> createProduct(@RequestBody Players player) {
        players.add(player);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name) {
        Players players = findByName(name);
        if (players == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        players.setName(name);
        return new ResponseEntity<>("Player updated successsfully", HttpStatus.OK);
    }


}

