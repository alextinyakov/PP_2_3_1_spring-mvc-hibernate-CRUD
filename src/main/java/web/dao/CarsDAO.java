package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDAO {


    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Renault", "Logan", 2010));
        cars.add(new Car("VolksWagen", "Tiguan", 2015));
        cars.add(new Car("Scoda", "Octavia", 2012));
        cars.add(new Car("Lada", "Granta", 2020));
        cars.add(new Car("Tesla", "Model3", 2021));
    }

    // Отображает все машины из списка
//    public List<Car> printAllCars() {
//        return cars;
//    }


    // отображает count машин из списка.
    public List<Car> showCarsByCount(int count) {

        if (count < 5) {
            cars = cars.subList(0, count);
        }
        return cars;
    }
}
