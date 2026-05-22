/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinni
 */
public class Main {

    public static void main(String[] args) {

        Tutor tutor1 = new Tutor(
                "Carlos Silva",
                "(21)99999-9999",
                "Campo Grande - RJ"
        );

        Pet pet1 = new Pet(
                "Rex",
                "Cachorro",
                5,
                tutor1
        );

        Profissional prof1 = new Profissional(
                "Mariana",
                "Banho e Tosa"
        );

        Atendimento atendimento1 = new Atendimento(
                "19/05/2026",
                "Banho completo",
                pet1,
                prof1
        );

        tutor1.exibirTutor();
        System.out.println();

        pet1.exibirPet();
        System.out.println();

        prof1.exibirProfissional();
        System.out.println();

        atendimento1.exibirAtendimento();
    }
}
