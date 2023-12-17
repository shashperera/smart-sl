package com.esad.smartsl.strategy.fare;

import com.esad.smartsl.factory.FareCalculationStrategyFactory;
import com.esad.smartsl.strategy.FareCalculationStrategy;

/**
 * @author Lahiru Ramesh 2021-10-29
 */
public class FareCalculator implements FareCalculationStrategy {

    FareCalculationStrategyFactory fareCalculationStrategyFactory;
    FareCalculationStrategy fareCalculationStrategy;

    public FareCalculator() {
        fareCalculationStrategyFactory = new FareCalculationStrategyFactory();
    }

    public FareCalculationStrategy setFareStrategy(int vehicleType) {
       fareCalculationStrategy =  fareCalculationStrategyFactory.getStrategy(vehicleType);
       return fareCalculationStrategy;
    }

    @Override
    public double calculate(double distance) {
        return fareCalculationStrategy.calculate(distance);
    }
}
