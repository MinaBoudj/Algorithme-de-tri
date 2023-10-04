public class RechercheDichotomie {

    //entrée: Tableau(entien) tab, entien element
    //pré: tab est trié en ordre croissant
    //sortie: indice de elm dans tab si elm est présent, 0 sinon
    public static int dichotomie(int[] tab, int elm){
        return dichotomie_rec(tab, elm, 0, tab.length);
    }

    //entrée: Tableau(entier) tab, entien elm, entier debut, entier fin
    //pré: tab est trié en ordre croissant
    //sortie: indice de elm dans tab[debut:fin] si elm est présent, -1 sinon
    //var: entier milieu, entier res
    public static int dichotomie_rec(int[] tab, int elem, int debut, int fin){
        int milieu;
        int res = -1;
        if(debut < fin){
            milieu = (debut+fin)/2;
            if(tab[milieu] == elem){
                res = milieu;
            }else if(elem < tab[milieu]){    //l'element se trouve à gauche
                res = dichotomie_rec(tab, elem, debut, milieu);
            }else{ //l'elelement se trouve à gauche
                res = dichotomie_rec(tab, elem, milieu+1, fin);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] S = {5, 6, 7, 8, 10, 18}; //tableau trié 

        System.out.print("La valeur 4 se trouve à la position : "+dichotomie(S, 4)+"\n");
        System.out.print("La valeur 7 se trouve à la position : "+dichotomie(S, 7)+"\n");
        System.out.print("La valeur 5 se trouve à la position : "+dichotomie(S, 5)+"\n");
        System.out.print("La valeur 18 se trouve à la position : "+dichotomie(S, 18)+"\n");
    }
}
