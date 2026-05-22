/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinni
 */
public class Tutor {

    private int id;
    private String nome;
    private String telefone;
    private String endereco;

    public Tutor(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void exibirTutor() {
        System.out.println("Tutor: " + nome);
        System.out.println("Telefone: " + telefone);
    }
}
