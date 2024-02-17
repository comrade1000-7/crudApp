package com.geetest.controllers.apiControllers;

import com.geetest.entities.SpaceShip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class SpaceshipController {
    @GetMapping("/spaceships")
    public ModelAndView spaceships(Map<String, Object> model){
        List<SpaceShip> spaceShips = List.of(
                new SpaceShip("Falcon", 10, 90.9d),
                new SpaceShip("Blackbird", 40, 70.4d),
                new SpaceShip("Austridge", 70, 85.3d),
                new SpaceShip("Flamingo", 88, 100.0d),
                new SpaceShip("Eagle", 1000, 50.9d)
        );
        model.put("spaceships", spaceShips);
        model.put("title", "<<Spaceships>>");
        return new ModelAndView("spaceships", model);
    }


}
