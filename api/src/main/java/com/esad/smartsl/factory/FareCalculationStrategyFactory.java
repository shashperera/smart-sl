package com.esad.smartsl.factory;

import com.esad.smartsl.strategy.*;

public class FareCalculationStrategyFactory {

    static FareCalculationStrategy fareCalculationStrategy;

    public static FareCalculationStrategy getStrategy(int vehicleType) {
        switch (vehicleType) {
            case 1: fareCalculationStrategy = new NormalBusFareStrategy();
            case 2: fareCalculationStrategy = new SemiLuxuryBusFareStrategy();
            case 3: fareCalculationStrategy = new LuxuryBusFareStrategy();
            default: fareCalculationStrategy = new NoBusFareStrategy();
        }
        return fareCalculationStrategy;
    }
}
