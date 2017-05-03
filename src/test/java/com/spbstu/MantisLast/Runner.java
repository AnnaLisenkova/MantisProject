package com.spbstu.MantisLast;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by anna on 02.05.17.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        glue = {"com.spbstu.MantisLast.stepDefs"}
)
public class Runner {
}
