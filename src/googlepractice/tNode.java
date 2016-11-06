package googlepractice;
public class tNode {

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public tNode getLeft() {
        return left;
    }

    public void setLeft(tNode left) {
        this.left = left;
    }

    public tNode getRight() {
        return right;
    }

    public void setRight(tNode right) {
        this.right = right;
    }
    
    public void setRightAndLeft(tNode l, tNode r){
        this.right = r;
        this.left = l;
    }

    public tNode(int value) {
        this.value = value;
    }
    
    
    private int value;
    
    private tNode left;
    
    private tNode right;
}
