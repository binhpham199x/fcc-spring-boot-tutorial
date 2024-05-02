package com.synaigy.runnerz.run;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
   private final RunRepository runRepository;

   private static final Logger log = LoggerFactory.getLogger(RunController.class);


   public RunController(RunRepository runRepository) {
      this.runRepository = runRepository;
   }

   @GetMapping("")
   List<Run> findAll() {
      log.info("repo: {}",runRepository.toString());
      return runRepository.findAll();
   }

   @GetMapping("/{id}")
   Run findById(@PathVariable Integer id) {
      Optional<Run> run = runRepository.findById(id);

      if (run.isEmpty()) {
         throw new RunNotFoundException();
      }

      return run.get();
   }

   //   Post
   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping("")
   void create(@Valid @RequestBody Run run) {
      runRepository.save(run);
   }


   //   Put
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @PutMapping("/{id}")
   void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
      runRepository.save(run);
   }

   //   Delete
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @DeleteMapping("/{id}")
   void delete(@PathVariable Integer id) {
      runRepository.delete(runRepository.findById(id).get());
   }

   @GetMapping("/locations/{location}")
   List<Run> findByLocation(@PathVariable String location){
      log.info("find locations: {}", runRepository.toString());
      return runRepository.findAllByLocation(location);
   }
}
