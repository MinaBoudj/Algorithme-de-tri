public class TrieFusion{
    
    public static void tri_Fusion(int[] T){
        tri_Fusion_rec(T, 1, T.length);
    }

    public static void tri_Fusion_rec(int[] T, int debut, int fin){
        if(debut < fin){
            int m = (debut+fin)/2;
            tri_Fusion_rec((T), debut, m);
            tri_Fusion_rec(T, m+1, fin);
            fusion(T, debut, m, fin);
        }
    }

    public static void fusion(int[] T, int debut, int milieu, int fin){
        int[] aux = new int[T.length] ;
        for(int i=debut; i<fin; i++){
            aux[i] = T[i];  //copie de T ands aux
        }
        int i = debut; //parcour de T[debut::fin]
        int j = debut;  //parcour de T[debut::milieu]
        int k = milieu+1;    //parcour de T[milieu++1::fin]
        while(i<=fin){
            if( k>fin || (j<=milieu && aux[j]<aux[k])){
                T[i] = aux[j];
                j++;
            }else{
                T[i] = aux[k];
                k++;
            }
            i++;
        }

    }
    // Fonction pour afficher un tableau
    public static void afficherTableau(int[] S) {
        for (int i : S) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] S = {12, 11, 13, 5, 6, 7};
        System.out.println("Tableau non trié : ");
        afficherTableau(S);

        tri_Fusion(S);

        System.out.println("Tableau trié : ");
        afficherTableau(S);
    }
}