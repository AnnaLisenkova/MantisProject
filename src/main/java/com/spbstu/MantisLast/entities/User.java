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
public class User {
    String login;
    String password;
}
