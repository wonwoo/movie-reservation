package me.wonwoo.web;

import me.wonwoo.domain.Screen;
import me.wonwoo.dto.ScreenDto;
import me.wonwoo.service.ScreenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public ScreenDto.Screen getScreen(@PathVariable Long id){
        Screen screen = screenService.findOne(id);
        ScreenDto.Screen screenDto = modelMapper.map(screen, ScreenDto.Screen.class);
        return screenDto;
    }
}
