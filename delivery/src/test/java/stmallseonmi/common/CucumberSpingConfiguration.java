package stmallseonmi.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stmallseonmi.DeliveryApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { DeliveryApplication.class })
public class CucumberSpingConfiguration {}
