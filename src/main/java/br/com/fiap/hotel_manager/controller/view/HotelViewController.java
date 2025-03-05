package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.entity.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelViewController {

    @GetMapping("/new")
    public String newHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotel-form";
    }


}
