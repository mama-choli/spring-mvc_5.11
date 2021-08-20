package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServise {

    private static ArrayList<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("LADA", "RED", 20));
        cars.add(new Car("LADA", "WHITE", 3));
        cars.add(new Car("LADA", "BLACK", 4));
        cars.add(new Car("NIVA 4X4", "RED", 15));
        cars.add(new Car("NIVA 4X4", "WHITE", 1));
    }

    public List<Car> getSomeCars(Integer count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}





