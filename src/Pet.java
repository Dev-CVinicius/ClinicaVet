/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinni
 */
public class Pet {

    private int id;
    private String nome;
    private String especie;
    private int idade;
    private Tutor tutor;

    public Pet(String nome, String especie, int idade, Tutor tutor) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.tutor = tutor;
    }

    public void exibirPet() {
        System.out.println("Pet: " + nome);
        System.out.println("Espécie: " + especie);
        System.out.println("Idade: " + idade);
    }
}