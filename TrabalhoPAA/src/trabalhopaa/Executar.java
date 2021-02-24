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
import java.util.concurrent.TimeUnit;

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
                + "12 - Teste com todos os algoritmos de ordenação\n"
                + "0 – Sair\n";
        System.out.println(menu);
        System.out.print("Escolha uma opção: ");
        Scanner sc = new Scanner(System.in);
        op = Integer.parseInt(sc.nextLine());
        return op;
    }

    public void executar() {
        int op;
        Scanner sc;
        int quantidade;
        boolean aux = false;
        do {
            clrscr();
            op = menu();
            switch (op) {
                case 1:
                    clrscr();
                    do {
                        System.out.println("Insira a quantidade de elementos que o vetor deve ter: ");
                        sc = new Scanner(System.in);
                        quantidade = Integer.parseInt(sc.nextLine());
                    } while (quantidade <= 0);
                    vetorDecrescente = GerarDecrescente(quantidade);
                    vetorCrescente = GerarCrescente(quantidade);
                    vetorRandomico = GerarRandom(quantidade);
                    aux = true;
                    break;
                case 2:
                    clrscr();
                    if (aux) {
                        ExibirVetoresNaoOrdenados();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 3:
                    clrscr();
                    if (aux) {
                        System.out.println("-Bubble Sort\n");
                        copiarVetores();
                        TestarBubbleSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 4:
                    clrscr();
                    if (aux) {
                        System.out.println("-Bubble Sort melhorado\n");
                        copiarVetores();
                        TestarBubbleSortMelhorado();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 5:
                    clrscr();
                    if (aux) {
                        System.out.println("-Quick Sort (com pivô sendo o primeiro elemento da lista – partição)\n");
                        copiarVetores();
                        TestarQuickSort1();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 6:
                    clrscr();
                    if (aux) {
                        System.out.println("-Quick Sort (com pivô sendo o elemento central da lista – partição)\n");
                        copiarVetores();
                        TestarQuickSort2();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 7:
                    clrscr();
                    if (aux) {
                        System.out.println("-Insertion Sort\n");
                        copiarVetores();
                        TestarInsertionSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 8:
                    clrscr();
                    if (aux) {
                        System.out.println("-Shell Sort\n");
                        copiarVetores();
                        TestarShellSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 9:
                    clrscr();
                    if (aux) {
                        System.out.println("-Selection Sort\n");
                        copiarVetores();
                        TestarSelectionSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 10:
                    clrscr();
                    if (aux) {
                        System.out.println("-Heap Sort\n");
                        copiarVetores();
                        TestarHeapSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 11:
                    clrscr();
                    if (aux) {
                        System.out.println("-Merge Sort\n");
                        copiarVetores();
                        TestarMergeSort();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
                    break;
                case 12:
                    clrscr();
                    if (aux) {
                        TestarTodos();
                    } else {
                        System.out.println("Os Vetores ainda não foram criados");
                    }
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

        tempoInicial = System.nanoTime();
        ordenador.BubbleSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.BubbleSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.BubbleSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarBubbleSortMelhorado() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.BubbleSortMelhorado(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.BubbleSortMelhorado(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.BubbleSortMelhorado(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarQuickSort1() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.QuickSort1(vetorCopiaCrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.QuickSort1(vetorCopiaDecrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.QuickSort1(vetorCopiaRandomico, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarQuickSort2() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.QuickSort2(vetorCopiaCrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.QuickSort2(vetorCopiaDecrescente, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.QuickSort2(vetorCopiaRandomico, 0, (vetorCopiaRandomico.length) - 1);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarInsertionSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.InsertionSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.InsertionSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.InsertionSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarShellSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.ShellSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.ShellSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.ShellSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarSelectionSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.SelectionSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.SelectionSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.SelectionSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarHeapSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;

        tempoInicial = System.nanoTime();
        ordenador.HeapSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = tempoFinal = 0;

        tempoInicial = System.nanoTime();
        ordenador.HeapSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = tempoFinal = 0;

        tempoInicial = System.nanoTime();
        ordenador.HeapSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarMergeSort() {
        long tempoFinal, tempoInicial;

        long tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico;
        tempoInicial = System.nanoTime();
        ordenador.MergeSort(vetorCopiaCrescente);
        tempoFinal = System.nanoTime();
        tempoVetorCrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.MergeSort(vetorCopiaDecrescente);
        tempoFinal = System.nanoTime();
        tempoVetorDecrescente = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        tempoInicial = System.nanoTime();
        ordenador.MergeSort(vetorCopiaRandomico);
        tempoFinal = System.nanoTime();
        tempoVetorRandomico = TimeUnit.MILLISECONDS.convert(tempoFinal - tempoInicial, TimeUnit.NANOSECONDS);

        Exibir(tempoVetorCrescente, tempoVetorDecrescente, tempoVetorRandomico);
    }

    private void TestarTodos() {
        System.out.println("\n-Bubble Sort\n");
        copiarVetores();
        TestarBubbleSort();
        
        System.out.println("\n-Bubble Sort melhorado\n");
        copiarVetores();
        TestarBubbleSortMelhorado();
        
        System.out.println("\n-Quick Sort (com pivô sendo o primeiro elemento da lista – partição)\n");
        copiarVetores();
        TestarQuickSort1();
        
        System.out.println("\n-Quick Sort (com pivô sendo o elemento central da lista – partição)\n");
        copiarVetores();
        TestarQuickSort2();
        
        System.out.println("\n-Insertion Sort\n");
        copiarVetores();
        TestarInsertionSort();
        
        System.out.println("\n-Shell Sort\n");
        copiarVetores();
        TestarShellSort();
        
        System.out.println("\n-Selection Sort\n");
        copiarVetores();
        TestarSelectionSort();
        
        System.out.println("\n-Heap Sort\n");
        copiarVetores();
        TestarHeapSort();
        
        System.out.println("\n-Merge Sort\n");
        copiarVetores();
        TestarMergeSort();
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
        int cont = n - 1;
        for (int i = 0; i < n; i++) {
            v[i] = cont;
            cont--;
        }
        return v;
    }

    private void ExibirVetoresNaoOrdenados() {
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

    private void ExibirVetoresOrdenados() {
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

        //ExibirVetoresOrdenados();
        System.out.println("Crescente: " + tempoVetorCrescente + " ms");

        System.out.println("Decrescente: " + tempoVetorDecrescente + " ms");

        System.out.println("Aleatório: " + tempoVetorRandomico + " ms\n");

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
