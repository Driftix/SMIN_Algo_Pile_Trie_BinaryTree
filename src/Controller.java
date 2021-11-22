import java.util.ArrayList;


public class Controller {
    public static void main(String [] args){
        Pile pile = new Pile();
        pile.empiler("test1");
        pile.empiler("test2");
        pile.empiler("test3");
        pile.empiler("test4");
        System.out.println(pile.depiler());
        System.out.println(pile.toString());
        System.out.println("-----------------");
        BinaryTree binaryTree = new BinaryTree(1,new BinaryTree(2,new BinaryTree(3,null,null),null),new BinaryTree(4,new BinaryTree(5,null,null),new BinaryTree(6,new BinaryTree(7,null,null),null)));
        System.out.println(binaryTree.estFeuille());
        System.out.println(binaryTree.nombreDeNoeuds(binaryTree));
        binaryTree.parcourPreordre(binaryTree);
        System.out.println("calcul total : " + binaryTree.sommeV2(binaryTree));
        System.out.println("-----------------");



        Trie trie = new Trie();
        //trie.bulle();
        //System.out.println(trie.toString()) ;

        trie  = new Trie();
        trie.insertion();
        //System.out.println(trie.toString());

        trie  = new Trie();
        //trie.selection();
        //System.out.println(trie.toString());

        trie = new Trie();
        trie.fusion();
        //System.out.println(trie.toString());
    }
}
