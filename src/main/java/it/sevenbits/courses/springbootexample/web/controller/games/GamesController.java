package it.sevenbits.courses.springbootexample.web.controller.games;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Controller
@RequestMapping("/games")
public class GamesController {
    private final IGamesService gamesService;

    /**
     *
     * @param gamesService gamesService
     */
    public GamesController(final IGamesService gamesService) {
        this.gamesService = gamesService;
    }

    /**
     *
     * @return return
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Game>> getAllGames() {
        try {
            List<Game> ans = gamesService.getAll();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id id
     * @return return
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Game> getGame(@PathVariable("id") final String id) {
        try {
            Game ans = gamesService.findById(UUID.fromString(id));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
