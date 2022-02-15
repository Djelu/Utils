package com.fantasy.Utils.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dates")
@NoArgsConstructor
@Getter@Setter
public class CountersDateEntity implements ICountersEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int month;
}