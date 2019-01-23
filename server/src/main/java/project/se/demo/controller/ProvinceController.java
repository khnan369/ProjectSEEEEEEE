package project.se.demo.controller;

import org.springframework.web.bind.annotation.*;
import project.se.demo.entity.Province;
import project.se.demo.repository.ProvinceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProvinceController {
    @Autowired private final ProvinceRepository provinceRepository;

    ProvinceController(ProvinceRepository provinceRepository) {

        this.provinceRepository = provinceRepository;
    }
    @GetMapping("/Provinces")
    public Collection<Province> provinces() {
        return provinceRepository.findAll().stream()
                .collect(Collectors.toList());
    }

}
