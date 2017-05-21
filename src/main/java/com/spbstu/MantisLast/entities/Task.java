package com.spbstu.MantisLast.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by anna on 02.05.17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    String category;
    String reproducibility;
    String influence;
    String priority;
    String platform;
    String OS;
    String OSVersion;
    String status;
    String originator;
    String responsible;
    String resolution;
    String summary;
    String description;
    String reproduceSteps;
    String additionalInfo;
}