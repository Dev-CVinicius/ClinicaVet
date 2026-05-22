/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinni
 */
public class Atendimento {

    private int id;
    private String data;
    private String descricao;
    private Pet pet;
    private Profissional profissional;

    public Atendimento(String data, String descricao, Pet pet, Profissional profissional) {
        this.data = data;
        this.descricao = descricao;
        this.pet = pet;
        this.profissional = profissional;
    }

    public void exibirAtendimento() {
        System.out.println("Data: " + data);
        System.out.println("Descrição: " + descricao);
    }
}