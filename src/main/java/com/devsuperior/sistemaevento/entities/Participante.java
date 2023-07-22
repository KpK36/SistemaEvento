package com.devsuperior.sistemaevento.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
    joinColumns = @JoinColumn (name = "participante_id"),
    inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    List<Atividade> atividades = new ArrayList<>();

    public Participante() {
    }

    public Participante(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }
}
