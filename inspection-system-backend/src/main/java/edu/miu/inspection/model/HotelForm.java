package edu.miu.inspection.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class HotelForm extends Form {

    private Integer numberOfRoom;

}
