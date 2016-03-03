package ch.amag.webtech.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.amag.webtech.hackathon.entities.VehicleList;
import ch.amag.webtech.hackathon.entities.VehicleOverviewList;
import ch.amag.webtech.hackathon.repository.VehicleOverviewRepository;
import ch.amag.webtech.hackathon.repository.VehicleRepository;

@RestController
@RequestMapping("/score")
@ComponentScan(basePackages = { "ch.amag.webtech.hackathon" })
public class ScoreController {
  @Autowired
  VehicleRepository vehicleRepository;
  
  @Autowired
  VehicleOverviewRepository vehicleOverviewRepository;
  
  @RequestMapping(value = {"/{scoreType}/{score}"}, method = RequestMethod.GET)
  public VehicleList getVehiclesByScore(@PathVariable String scoreType, @PathVariable int score) {
    return new VehicleList(vehicleRepository.findByScore(scoreType, score));
  }
  
  @RequestMapping(value = {"/{scoreType}/{lowerScore}/{upperScore}"}, method = RequestMethod.GET)
  public VehicleList getVehiclesByScoreRange(@PathVariable String scoreType, @PathVariable int lowerScore, @PathVariable int upperScore) {
    return new VehicleList(vehicleRepository.findByScoreRange(scoreType, lowerScore, upperScore));
  }
  
  @RequestMapping(value = {"/{scoreType}/{score}/overview"}, method = RequestMethod.GET)
  public VehicleOverviewList getVehicleOverviewByScore(@PathVariable String scoreType, @PathVariable int score) {
    return new VehicleOverviewList(vehicleOverviewRepository.findByScore(scoreType, score));
  }
  
  @RequestMapping(value = {"/{scoreType}/{lowerScore}/{upperScore}/overview"}, method = RequestMethod.GET)
  public VehicleOverviewList getVehicleOverviewByScoreRange(@PathVariable String scoreType, @PathVariable int lowerScore, @PathVariable int upperScore) {
    return new VehicleOverviewList(vehicleOverviewRepository.findByScoreRange(scoreType, lowerScore, upperScore));
  }
}
