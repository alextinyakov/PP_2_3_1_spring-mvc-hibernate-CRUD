package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarsDAO;

@Controller
@RequestMapping()
public class CarController {

    private CarsDAO carsDAO;

    @Autowired
    public CarController(CarsDAO carsDAO) {
        this.carsDAO = carsDAO;
    }

    // При запросе /cars выводить весь список. При запросе /cars?count=2 должен отобразиться список из 2 машин,
//при /cars?count=3 - из 3, и тд. При count ≥ 5 выводить весь список машин.
    @GetMapping("/cars")
    public String printCarTable(Model model, @RequestParam (defaultValue = "6") int count ) {
        model.addAttribute("cars", carsDAO.showCarsByCount(count));
        return "carsPage";
    }

//    @GetMapping("/allcars")
//    public String printAllCars(Model model) {
//        // Получим все машины из DAO и передадим на отображение в представление
//        model.addAttribute("cars", carsDAO.printAllCars());
//
//        return "allCars";
//    }
//
//    @GetMapping("/{count}")
//    public String showCars(@PathVariable("count") int count, Model model) {
//        // Список из count машин из DAO и передадим его на отображение в представление
//        model.addAttribute("cars", carsDAO.showCarsByCount(count));
//        return "showcars";
//    }

}
