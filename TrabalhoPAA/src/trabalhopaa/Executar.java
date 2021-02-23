/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopaa;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mathe
 */
public class Executar {

    private Ordenacao ordenador = new Ordenacao();

    private int[] vetorDecrescente = null;
    private int[] vetorCrescente = null;
    private int[] vetorRandomico = null;
    private int[] vetorCopiaDecrescente = null;
    private int[] vetorCopiaCrescente = null;
    private int[] vetorCopiaRandomico = null;

    private int menu() {
        int op;
        String menu = "MENU DE OPÇÕES\n"
                + "1 - Criar Vetores\n"
                + "2 - Exibir Vetores Não Ordenados\n"
                + "3 – Bubble Sort\n"
                + "4 – Bubble Sort melhorado\n"
                + "5 – Quick Sort(com pivô sendo o primeiro elemento da lista – partição)\n"
                + "6 – Quick Sort (com pivô sendo o elemento central da lista – partição)\n"
                + "7 – Insertion Sort\n"
                + "8 – Shell Sort\n"
                + "9 – Selection Sort\n"
                + "10 – Heap Sort\n"
                + "11 - Merge Sort\n"
                + "0 – Sair\n";
        System.out.println(menu);
        System.out.print("Digite Opção:");
        Scanner sc = new Scanner(System.in);
        op = Integer.parseInt(sc.nextLine());
        return op;
    }

    public void executar() {
        int op;
        Scanner sc;
        int quantidade;

        do {
            clrscr();
            op = menu();
            switch (op) {
                case 1:
                    clrscr();
                    do {
                        System.out.println("Insira a quantidade de elementos que o vetor deve ter(a quantidade deverá ser entre 1000 e 25000): ");
                        sc = new Scanner(System.in);
                        quantidade = Integer.parseInt(sc.nextLine());
                    } while (quantidade < 10 || quantidade > 25000);
                    vetorDecrescente = GerarDecrescente(quantidade);
                    vetorCrescente = GerarCrescente(quantidade);
                    vetorRandomico = GerarRandom(quantidade);
                    break;
                case 2:
                    clrscr();
                    ExibirVetoresNaoOrdenados();
                    break;
                case 3:
                    clrscr();
                    copiarVetores();
                    TestarBubbleSort();
                    break;
                case 4:
                    clrscr();
                    copiarVetores();
                    TestarBubbleSortMelhorado();
                    break;
                case 5:
                    clrscr();
                    copiarVetores();
                    TestarQuickSort1();
                    break;
                case 6:
                    clrscr();
                    copiarVetores();
                    TestarQuickSort2();
                    break;
                case 7:
                    clrscr();
                    copiarVetores();
                    TestarInsertionSort();
                    break;
                case 8:
                    clrscr();
                    copiarVetores();
                    TestarShellSort();
                    break;
                case 9:
                    clrscr();
                    copiarVetores();
                    TestarSelectionSort();
                    break;
                case 10:
                    clrscr();
                    copiarVetores();
                    TestarHeapSort();
                    break;
                case 11:
                    clrscr();
                    copiarVetores();
                    TestarMergeSort();
                    break;
            }
        } while (op != 0);
    }

    private void copiarVetores() {
        vetorCopiaDecrescente = Arrays.copyOf(vetorDecrescente, vetorDecrescente.length);
        vetorCopiaCrescente = Arrays.copyOf(vetorCrescente, vetorCrescente.length);
        vetorCopiaRandomico = Arrays.copyOf(vetorRandomico, vetorRandomico.length);
    }

    private void TestarBubbleSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;

        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSort(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSort(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSort(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);

    }

    private void TestarBubbleSortMelhorado() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSortMelhorado(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSortMelhorado(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.BubbleSortMelhorado(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarQuickSort1() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort1(vetorCopiaCrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort1(vetorCopiaDecrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort1(vetorCopiaRandomico, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarQuickSort2() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort2(vetorCopiaCrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort2(vetorCopiaDecrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.QuickSort2(vetorCopiaRandomico, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarInsertionSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.InsertionSort(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.InsertionSort(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.InsertionSort(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarShellSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.ShellSort(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.ShellSort(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.ShellSort(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarSelectionSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.SelectionSort(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.SelectionSort(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.SelectionSort(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarHeapSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.HeapSort(vetorCopiaCrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.HeapSort(vetorCopiaDecrescente);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.HeapSort(vetorCopiaRandomico);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarMergeSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.currentTimeMillis();
        ordenador.MergeSort(vetorCopiaCrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorCrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.MergeSort(vetorCopiaDecrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorDecrescente = tempoFinal - tempoInicial;

        tempoInicial = System.currentTimeMillis();
        ordenador.MergeSort(vetorCopiaRandomico, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.currentTimeMillis();
        tempoVetorRandomico = tempoFinal - tempoInicial;

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private int[] GerarRandom(int n) {
        int[] v = new int[n];
        Random Gerador = new Random();
        for (int i = 0; i < n; i++) {
            v[i] = Gerador.nextInt(n);
        }
        return v;
    }

    private int[] GerarCrescente(int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = i;
        }
        return v;
    }

    private int[] GerarDecrescente(int n) {
        int[] v = new int[n];
        int cont = n;
        for (int i = 0; i < n; i++) {
            v[i] = cont;
            cont--;
        }
        return v;
    }
    
    private void ExibirVetoresNaoOrdenados(){
        int i;
        
        System.out.println("\n\nVetor iniciado em ordem Crescente: ");
        for (i = 0; i < vetorCrescente.length; i++) {
            System.out.println(vetorCrescente[i]);
        }
        
        System.out.println("\n\nVetor iniciado em ordem Decrescente: ");
        for (i = 0; i < vetorDecrescente.length; i++) {
            System.out.println(vetorDecrescente[i]);
        }
        
        System.out.println("\n\nVetor iniciado em ordem aleatória: ");
        for (i = 0; i < vetorRandomico.length; i++) {
            System.out.println(vetorRandomico[i]);
        }
    }
    
    private void ExibirVetoresOrdenados(){
        int i;
        
        System.out.println("\n\nVetor iniciado em ordem Crescente: ");
        for (i = 0; i < vetorCopiaCrescente.length; i++) {
            System.out.println(vetorCopiaCrescente[i]);
        }
        
        System.out.println("\n\nVetor iniciado em ordem Decrescente: ");
        for (i = 0; i < vetorCopiaDecrescente.length; i++) {
            System.out.println(vetorCopiaDecrescente[i]);
        }
        
        System.out.println("\n\nVetor iniciado em ordem aleatória: ");
        for (i = 0; i < vetorCopiaRandomico.length; i++) {
            System.out.println(vetorCopiaRandomico[i]);
        }
    }

    private void Exibir(long tempoVetorCrescente, long tempoVetorDecrescente, long tempoVetorRandomico) {
        int i;
        
        
        ExibirVetoresOrdenados();
        
        System.out.println("\nVetor que foi iniciado em ordem crescente foi ordenado em = " + tempoVetorCrescente + " ms");

        System.out.println("\nVetor que foi iniciado em ordem decrescente foi ordenado em = " + tempoVetorDecrescente + " ms");

        System.out.println("\nVetor que foi iniciado em ordem aleatória foi ordenado em = " + tempoVetorRandomico + " ms");

    }

    private static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }
}
