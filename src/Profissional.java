/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinni
 */
public class Profissional {

    private int id;
    private String nome;
    private String especialidade;

    public Profissional(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void exibirProfissional() {
        System.out.println("Profissional: " + nome);
        System.out.println("Especialidade: " + especialidade);
    }

 
}
