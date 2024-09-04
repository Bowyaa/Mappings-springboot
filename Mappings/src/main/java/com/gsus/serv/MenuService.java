package com.gsus.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsus.entity.Menu;
import com.gsus.repo.MenuRepository;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }
}