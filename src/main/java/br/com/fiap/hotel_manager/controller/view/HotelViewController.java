package br.com.fiap.hotel_manager.controller.view;

import br.com.fiap.hotel_manager.controller.dto.HotelDTO;
import br.com.fiap.hotel_manager.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelViewController {

    private final HotelService hotelService;

    public HotelViewController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/new")
    public String newHotel(Model model) {
        model.addAttribute("hotel", new HotelDTO());
        return "hotel/hotel-form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("hotel") HotelDTO hotelDTO) {
        hotelService.saveHotel(hotelDTO);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public String editHotel(@PathVariable Long id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        return "hotel/hotel-edit";
    }
    @PostMapping("/{id}/edit")
    public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") HotelDTO hotelDTO, Model model) {
        hotelService.saveHotel(hotelDTO);
        return "redirect:/home";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hotel", hotelService.getHotelById(id));
        return "hotel/hotel-details";
    }


}
