package com.company;


public class Main {

    public static void main(String[] args) {
	    int[] tab = {4, 7, 3, 9, 1, 2, 5};

	    //display(extract(tab, 0, tab.length/2));
	    display(mergeSort(tab));
    }

    public static int[] mergeSort(int[] tab) {
        // Si notre tableau est vide on ne possède qu'un élément
        if (tab.length <= 1) {
            // On le retourne
            return tab;
        } else {
            // On récupère la partie gauche du tableau;
            int[] left = extract(tab, 0, tab.length/2);
            // On appelle mergeSort sur la partie gauche
            int[] mergeLeft = mergeSort(left);
            // int[] mergeLeft = mergeSort(extract(tab, 0, tab.length/2)); // Appel en une ligne
            // On récupère la partie droite du tableau
            int[] right = extract(tab, tab.length/2, tab.length);
            // On appelle mergeSorte sur la partie droite
            int[] mergeRight = mergeSort(right);
            // On fusionne les 2 resultats de mergeSort
            int[] merge = merge(mergeLeft, mergeRight);
            // On retourne le résultat de la fusion
            return merge;
        }
    }

    public static int[] extract(int[] tab, int start, int end) {
        int[] res = new int[end - start];

        for (int i = start; i < end; i++) {
            res[i - start] = tab[i];
        }

        return res;
    }

    /*public static void main(String[] args) {
	    int[] t1 = {3, 4, 7};
	    int[] t2 = {1, 2, 5, 9};

        display(merge(t1, t2));
    }*/

    public static int[] merge(int[] t1, int[] t2) {
        if (t1.length == 0) {
            return t2;
        }

        if (t2.length == 0) {
            return t1;
        }

        if (t1[0] <= t2[0]) {
            int[] res;
            int[] tmp;

            // ici on a la fusion de la partie droite de t1 et de t2
            tmp = merge(right(t1), t2);

            // ici on a la fusion de t1[0] et de la fusion de la partie droite de t1 et de t2
            res = merge(t1[0], tmp);

            return res;
            //return merge(t1[0], merge(right(t1), t2));
        } else {
            int[] res;
            int[] tmp;

            // ici on a la fusion de la partie droite de t1 et de t2
            tmp = merge(right(t2), t1);

            // ici on a la fusion de t1[0] et de la fusion de la partie droite de t1 et de t2
            res = merge(t2[0], tmp);

            return res;
            //return merge(t2[0], merge(right(t2), t1));
        }
    }

    public static int[] merge(int val, int[] tab) {
        int[] res = new int[tab.length + 1];

        res[0] = val;
        for (int i = 0; i < tab.length; i++) {
            res[i + 1] = tab[i];
        }

        return res;
    }

    public static int[] right(int[] tab) {
        int[] res = new int[tab.length - 1];

        for (int i = 1; i < tab.length; i++){
            res[i - 1] = tab[i];
        }

        return res;
    }

    public static void display(int[] tab) {
        for (int i = 0; i < tab.length ; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println();
    }
}
