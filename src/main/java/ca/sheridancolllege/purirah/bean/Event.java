package ca.sheridancolllege.purirah.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Event {

    private int id;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String location;
    private String participantName;
    private String email;
    private String phone;

}