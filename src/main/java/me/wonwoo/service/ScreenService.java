package me.wonwoo.service;

import me.wonwoo.domain.*;
import me.wonwoo.exception.IdNotFoundException;
import me.wonwoo.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {

    @Autowired
    private ScreenRepository screenRepository;

    //조금 수정하기 소스가 맘에 안듦!
    @Transactional(readOnly = true)
    public Screen findOne(Long id) {
        Screen screen = screenRepository.findOne(id);
        if(screen == null){
            throw new IdNotFoundException(id);
        }
        Movie movie = screen.getMovie();
        List<DisCountRule> disCountRules = movie.getDisCount().getDisCountRules();
        Optional<DisCount> disCountOptional = findDisCount(screen, disCountRules);

        if (disCountOptional.isPresent()) {
            DisCount dc = disCountOptional.get();
            if (dc.getDisCountType() == DisCountType.AMOUNT) {
                screen.setDisCount(movie.getPrice().subtract(dc.getPrice()));
            } else {
                BigDecimal divide = dc.getPrice().divide(new BigDecimal(100));
                BigDecimal multiply = movie.getPrice().multiply(divide);
                screen.setDisCount(movie.getPrice().subtract(multiply));
            }
        }else{
            screen.setDisCount(movie.getPrice());
        }

        return screen;
    }

    private Optional<DisCount> findDisCount(Screen screen, List<DisCountRule> disCountRules) {
        return disCountRules.stream()
                    .filter(role -> role.getSeq() == screen.getSeq())
                    .map(i -> i.getDisCount()).findFirst();
    }

}
