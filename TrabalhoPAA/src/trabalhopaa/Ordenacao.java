/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopaa;

/**
 *
 * @author mathe
 */
public class Ordenacao {
     public void BubbleSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < v.length - i; j++) {
                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }

    public void BubbleSortMelhorado(int[] v) {
        boolean ordenado;
        int exp1;
        for (int i = 1; i < v.length; i++) {
            ordenado = true;
            exp1 = v.length - i;
            for (int j = 0; j < exp1; j++) {
                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                    ordenado = false;
                }
            }
            if (ordenado) {
                break;
            }
        }
    }

//------------------------------------------------------------------------------//
    public void QuickSort1(int[] v, int ini, int fim) {
        if (ini < fim) {
            int j = separar1(v, ini, fim);
            QuickSort1(v, ini, j - 1);
            QuickSort1(v, j + 1, fim);
        }
    }

    private int separar1(int[] v, int ini, int fim) {
        int i = ini + 1, f = fim;
        int pivo = v[ini];
        while (i <= f) {
            if (v[i] <= pivo) {
                i++;
            } else if (v[f] > pivo) {
                f--;
            } else if (i <= f) {
                trocar(v, i, f);
                i++;
                f--;
            }
        }
        trocar(v, ini, f);
        return f;
    }
//------------------------------------------------------------------------------//

    public void QuickSort2(int[] v, int ini, int fim) {
        if (ini < fim) {
            int j = separar2(v, ini, fim);
            QuickSort2(v, ini, j - 1);
            QuickSort2(v, j, fim);
        }
    }

    private int separar2(int[] v, int ini, int fim) {
        int pivo = v[(ini + fim) / 2];
        int i = ini, f = fim;
        while (i <= f) {
            if (v[i] < pivo) {
                i++;
            } else if (v[f] > pivo) {
                f--;
            } else if (i <= f) {
                trocar(v, i, f);
                i++;
                f--;
            }
        }
        return i;
    }

    private void trocar(int[] v, int i, int f) {
        int aux;
        aux = v[i];
        v[i] = v[f];
        v[f] = aux;
    }
//------------------------------------------------------------------------------//

    public void InsertionSort(int[] v) {
        int i, j, chave;
        for (i = 1; i < v.length; i++) {
            chave = v[i];
            for (j = i - 1; (j >= 0) && (v[j] > chave); j--) {
                v[j + 1] = v[j];
            }
            v[j + 1] = chave;
        }
    }
//------------------------------------------------------------------------------//

    public void ShellSort(int[] v) {
        int n = v.length, salto, i, j;
        for (salto = n / 2; salto > 0; salto /= 2) {
            for (i = salto; i < n; i++) {
                int aux = v[i];
                for (j = i; j >= salto && aux < v[j - salto]; j -= salto) {
                    v[j] = v[j - salto];
                }
                v[j] = aux;
            }
        }
    }
//------------------------------------------------------------------------------//

    public void SelectionSort(int[] v) {
        for (int fixo = 0; fixo < v.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < v.length; i++) {
                if (v[i] < v[menor]) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                int t = v[fixo];
                v[fixo] = v[menor];
                v[menor] = t;
            }
        }
    }
//------------------------------------------------------------------------------//

    public void HeapSort(int[] v) {
        int n = v.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(v, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = v[0];
            v[0] = v[i];
            v[i] = temp;
            heapify(v, i, 0);
        }
    }

    public void heapify(int[] v, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && v[l] > v[largest]) {
            largest = l;
        }
        if (r < n && v[r] > v[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = v[i];
            v[i] = v[largest];
            v[largest] = swap;
            heapify(v, n, largest);
        }
    }
//------------------------------------------------------------------------------//

    public void merge(int[] v, int ini, int meio, int fim) {
        int n1 = meio - ini + 1;
        int n2 = fim - meio;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = v[ini + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = v[meio + 1 + j];
        }
        int i = 0, j = 0, k = 1;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                v[k] = L[i];
                i++;
            } else {
                v[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            v[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            v[k] = R[j];
            j++;
            k++;
        }
    }

    public void MergeSort(int[] v, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            MergeSort(v, ini, meio);
            MergeSort(v, meio + 1, fim);
            merge(v, ini, meio, fim);
        }
    }
}
