package com.fantasy.Utils.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "light_counters")
@NoArgsConstructor
@Getter@Setter
public class LightCounterEntity implements ICountersEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int day;
    private int night;

    @OneToOne
    @JoinColumn(name = "date_id")
    private CountersDateEntity countersDateEntity;
}
