package com.danilo;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        } else {
            ListItem currentItem = this.root;

            while(currentItem != null) {
                int comparison = currentItem.comparetTo(newItem);
                if (comparison < 0) {
                    if (currentItem.next() == null) {
                        currentItem.setNext(newItem);
                        return true;
                    }

                    currentItem = currentItem.next();
                } else {
                    if (comparison <= 0) {
                        System.out.println(newItem.getValue() + " is already present");
                        return false;
                    }

                    if (currentItem.previous() == null) {
                        currentItem.setPrevious(newItem);
                        return true;
                    }

                    currentItem = currentItem.previous();
                }
            }

            return false;
        }
    }
    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem!=null){
            int comparison = currentItem.comparetTo(item);
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if(comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                this.performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            if (parent.next() == item) {
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            if (parent.next() == item) {
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                this.root = item.next();
            }
        } else {
            ListItem current = item.next();

            ListItem leftmostParent;
            for(leftmostParent = item; current.previous() != null; current = current.previous()) {
                leftmostParent = current;
            }

            item.setValue(current.getValue());
            if (leftmostParent == item) {
                item.setNext(current.next());
            } else {
                leftmostParent.setPrevious(current.next());
            }
        }

    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
