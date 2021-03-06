package br.com.globallabs.springwebmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jedi")
public class Jedi {

    @Id
    @Column(name = "id_jedi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Nome não pode estar em branco")
    @Column(name = "last_name")
    private String lastName;

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
