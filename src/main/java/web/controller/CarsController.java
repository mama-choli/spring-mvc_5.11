package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarsDAO;
import web.model.Car;
import web.service.CarServise;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {


    @Autowired
    public CarsController(CarsDAO carsDAO,CarServise carServise) {
        this.carsDAO = carsDAO;
    }

    private CarsDAO carsDAO;

    @GetMapping()
    public String index(@RequestParam(value = "count", required = false) Integer count, ModelMap model, CarServise carService) {
        List<Car> carList;

        if (count != null && count > 0 && count <= 5) {
            carList = carService.getSomeCars(count);
        } else {
            carList = carsDAO.index();
        }

        model.addAttribute("cars", carList);
        return "cars";
    }


    @GetMapping("cars")
    public String index(Model model) {


            model.addAttribute("cars", carsDAO.index());
            return "cars";
        }

}




