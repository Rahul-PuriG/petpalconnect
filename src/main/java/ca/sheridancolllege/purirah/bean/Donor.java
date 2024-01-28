package ca.sheridancolllege.purirah.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donor {
    private int id;
    private String donorName;
    private double donateAmount;
    private String donorEmail;
    private String donorNumber;
    private String address;
}