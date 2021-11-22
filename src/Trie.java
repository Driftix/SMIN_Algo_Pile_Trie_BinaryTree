import java.util.Random;

public class Trie {
    public int[] tableau;

    public Trie(int [] tableau){
        this.tableau = tableau;
    }
    public Trie(){
        generateTab();
    }

    public void bulle(){
        long startTime = System.nanoTime();
        int taille = tableau.length;
        int tmp = 0;
        for(int i=0; i < taille; i++){
            for(int j=1; j < (taille-i); j++){
                if(tableau[j-1] > tableau[j]){
                    tmp = tableau[j-1];
                    tableau[j-1] = tableau[j];
                    tableau[j] = tmp;
                }
            }
        }
        long stopTime = System.nanoTime();
        System.out.println(((stopTime-startTime)/100000) + "ms");
    }
    public void insertion(){
        long startTime = System.nanoTime();
        int taille = tableau.length;
        for (int i = 1; i < taille; i++){
            int tempval = tableau[i];
            int j = i-1;
            while(j >= 0 && tableau[j] > tempval){
                tableau[j+1] = tableau[j];
                j--;
            }
            tableau[j+1] = tempval;
        }
        long stopTime = System.nanoTime();
        System.out.println(((stopTime-startTime)/100000) + "ms");
    }
    public void selection(){
        long startTime = System.nanoTime();
        for (int i = 0; i < tableau.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < tableau.length; j++){
                if (tableau[j] < tableau[index]){
                    index = j;
                }
            }
            int min = tableau[index];
            tableau[index] = tableau[i];
            tableau[i] = min;
        }
        long stopTime = System.nanoTime();
        System.out.println(((stopTime-startTime)/100000) + "ms");
    }

    public void fusion(){
        long startTime = System.nanoTime();
        triFusion(this.tableau,0,this.tableau.length -1);
        long stopTime = System.nanoTime();
        System.out.println(((stopTime-startTime)/100000) + "ms");
    }
    public static void triFusion(int[] tab, int debut, int fin)
    {
        if (debut < fin)
        {
            int milieu = (debut + fin) / 2;
            triFusion(tab, debut, milieu);
            triFusion(tab, milieu + 1, fin);
            fusionner (tab, debut, milieu, fin);
        }
    }

    public static void fusionner(int[] tab, int debut, int milieu, int fin)
    {
        int[] copie = (int[]) tab.clone();
        // tab.clone est tres gourmand en temps d'execution surtout dans un algo recursif
        // il faudrait passer par un tableau temporaire pour stocker les données triées.
        // puis recopier la partie triée a la fin de la méthode.

        int i1 = debut;      // indice dans la première moitié de copie
        int i2 = milieu + 1; // indice dans la deuxième moitié de copie
        int i = debut;       // indice dans le tableau tab

        while (i1 <= milieu && i2 <= fin)
        {
            //quelle est la plus petite tête de liste?
            if (copie[i1] <= copie[i2])
            {
                tab[i] = copie[i1];
                i1++;
            }
            else
            {
                tab[i] = copie[i2];
                i2++;
            }
            i++;
        }
        if (i <= fin)
        {
            while (i1 <= milieu)  // le reste de la première moitié
            {
                tab[i] = copie[i1];
                i1++;
                i++;
            }
            while (i2 <= fin) // le reste de la deuxième moitié
            {
                tab[i] = copie[i2];
                i2++;
                i++;
            }
        }
    }

    public void generateTab(){
        Random rd = new Random();
        int length = 100000;
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(0,length);
        }
        this.tableau = arr;
    }

    public String toString(){
        String yes = "";
        for(int val : this.tableau){
            yes += " " + val;
        }
        return yes;
    }
}
