import java.util.ArrayList;

public class BinaryTree {
    private int value;
    private BinaryTree filsgauche;
    private BinaryTree filsdroit;

    public BinaryTree(int value, BinaryTree filsgauche, BinaryTree filsdroit){
        this.value = value;
        this.filsgauche = filsgauche;
        this.filsdroit = filsdroit;
    }
    //Marche pas
    public boolean estFeuille(){
        return filsgauche == null && filsdroit == null;
    }

    public int nombreDeNoeuds(BinaryTree tree){
     if(tree == null){
         return 0;
     }
     return 1 + nombreDeNoeuds(tree.filsgauche) + nombreDeNoeuds(tree.filsdroit);
    }

    public void parcourPreordre(BinaryTree tree){
        if(tree == null){

        }else{
            System.out.print(tree.getValue() + " ");
            parcourPreordre(tree.filsgauche);
            parcourPreordre(tree.filsdroit);
        }
    }

    public int somme(BinaryTree tree, int count){

        if(tree == null){
        }else{
            count += tree.getValue();
            somme(tree.filsgauche, tree.getValue());
            somme(tree.filsdroit, tree.getValue());
        }
        return count;
    }

    public int sommeV2(BinaryTree tree){
        if(tree==null){
            return 0;
        }else{
            return tree.getValue() + sommeV2(tree.filsgauche) + sommeV2(tree.filsdroit);
        }
    }


    public int getValue(){
        return this.value;
    }
}
