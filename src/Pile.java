import java.util.LinkedList;

public class Pile {
    private LinkedList<String> liste;

    public Pile(){
        liste = new LinkedList<String>();
    }

    public void empiler(String chaine){
        liste.add(chaine);
    }

    public String depiler(){
        String last = liste.getLast();
        liste.removeLast();
        return last;
    }
    public String toString(){
        String result = new String();
        for (String s : liste) {
            result += "element: " + s + "\n";
        }
        return result;
    }
}
