package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.CassaRepository;
import com.gazfood.gazfoodspringboot.entity.Cassa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CassaServiceImpl implements CassaService {

    @Autowired
    private CassaRepository cassaRepository;

    @Override
    public List<Cassa> getAllCasses() {
        List<Cassa> getAllCasses = cassaRepository.findAll();
        return getAllCasses;
    }

    @Override
    public List<Cassa> getAllCassesOrder() {
        List<Cassa> getAllCasses = cassaRepository.findAllByOrderByCassaName();
        return getAllCasses;
    }


    @Override
    public void saveCassa(Cassa cassa) {
        cassaRepository.save(cassa);
    }

    @Override
    public Cassa getCassa(int id) {
        Cassa cassa = null;
        Optional<Cassa> optional = cassaRepository.findById(id);
        if (optional.isPresent()) {
            cassa = optional.get();
        }
        return cassa;
    }

    @Override
    public void deleteCassa(int id) {
        cassaRepository.deleteById(id);
    }

    @Override
    public long getCountCasses() {
        return cassaRepository.count();
    }

    @Override
    public void updateOnlineData(String str) {
        //1.распарсить входящий стринг
        String[] array = str.split("=");
        //2. взять отуда имя компьютера
        String pcName = array[0];
        //3. если такое имя есть, то обновить строчку записав текущее время
        Cassa newCassa = cassaRepository.findCassaByComputerName(pcName);
        if (newCassa != null) {
            System.out.println("Такая касса есть в БД");
            System.out.println(newCassa);
            newCassa.setOnline(LocalDateTime.now());
            System.out.println(newCassa);
            cassaRepository.save(newCassa);
        }
    }
}
