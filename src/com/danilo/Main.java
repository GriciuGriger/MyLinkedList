package com.danilo;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree((ListItem) null);
        tree.traverse(tree.getRoot());

      //  String stringData = "5 7 3 9 8 2 1 0 4 6";

        String stringData = "Dawrin Brisbane Perth Melbourne Canberra Adelaide Sydney";

        String[] data = stringData.split(" ");
        for(String s : data){
            tree.addItem(new Node(s));
        }


        tree.traverse(tree.getRoot());

        /*searchTree.removeItem(new Node("3"));
        searchTree.traverse(searchTree.getRoot());

        searchTree.removeItem(new Node("0"));
        searchTree.traverse(searchTree.getRoot());*/
    }
}
