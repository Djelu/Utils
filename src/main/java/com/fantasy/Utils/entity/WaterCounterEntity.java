package com.fantasy.Utils.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "water_counters")
@NoArgsConstructor
@Getter@Setter
public class WaterCounterEntity implements ICountersEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cold;
    private int hot;

    @OneToOne
    @JoinColumn(name = "date_id")
    private CountersDateEntity countersDateEntity;
}
