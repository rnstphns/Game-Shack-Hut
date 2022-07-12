package edu.miu.cs425.gameshackhutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String eventName;

    private LocalDate date;

    private Integer capacity;
}
