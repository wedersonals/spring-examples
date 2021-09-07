package br.com.globallabs.springwebmvc.service;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;
import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        Optional<Jedi> jedi = repository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(Long id, Jedi dto) {
        Optional<Jedi> jediEntity = repository.findById(id);
        if (jediEntity.isPresent()) {
            Jedi jedi = jediEntity.get();
            BeanUtils.copyProperties(dto, jedi, "id");
            return repository.save(jedi);
        } else {
            throw new JediNotFoundException();
        }
    }

    public void delete(Long id) {
        final Jedi jedi = findById(id);
        repository.delete(jedi);
    }
}
