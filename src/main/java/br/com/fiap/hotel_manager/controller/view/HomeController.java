package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class HomeController {
    private HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<HotelDTO> hotelDTOS = hotelService.getAllHotels();
        model.addAttribute("hotels", hotelDTOS);
        return "home/index";
    }

}
