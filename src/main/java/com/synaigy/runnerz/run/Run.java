package com.synaigy.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
      Integer id,
      @NotEmpty
      String title,
      LocalDateTime startedOn,
      LocalDateTime completeOn,
      @Positive
      Integer miles,
      Location location
) {
   public Run {

      if (!completeOn.isAfter(startedOn)) {
         throw new IllegalArgumentException("CompletedOn must be after StartedOn");
      }
   }
}
