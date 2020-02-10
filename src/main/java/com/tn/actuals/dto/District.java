package com.tn.actuals.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "district")
@Access(AccessType.FIELD)

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findByDistrictCode",
                query = "SELECT * from district where district_code = ?1",
                resultClass= District.class
        ),
        @NamedNativeQuery(
                name = "findAll",
                query = "SELECT * from district",
                resultClass= District.class
        )
})
public class District implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "district_name")
    String districtName;

    @Column(name = "district_code")
    int districtCode;

}