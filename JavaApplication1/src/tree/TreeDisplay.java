/*
 * Tree Display using JavaFX
 */
package tree;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rohan_000
 */
public class TreeDisplay extends Application {
    private static BinaryTree tree;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        int pX = 350;
        int pY = 200;
        int xDiff = 50;
        int yDiff = 50;
        List<BinaryTreeNode> list = tree.preOrderDisplay(pX, pY, xDiff, yDiff);
        Pane root = new Pane();
        Font font = new Font(20);
        for(BinaryTreeNode node: list){
            if(node != null){
                Line line = new Line();
                BinaryTreeNode parentNode = node.getParentNode();
                int a = pX;
                int b = pY;
                if(parentNode != null){
                    a = node.getParentNode().getX();
                    b = node.getParentNode().getY();
                }
                line.setStartX(a);
                line.setStartY(b);
                line.setEndX(node.getX());
                line.setEndY(node.getY());
                Circle circle = new Circle();
                circle.setCenterX(node.getX());
                circle.setCenterY(node.getY());
                circle.setRadius(5);
                Text text;
                if(node.getParentNode() != null && node.getParentNode().getLeftNode()==node){
                    text = new Text(node.getX()+0.2*xDiff, node.getY()+0.1*yDiff, ""+node.getValue());
                }
                else{
                    text = new Text(node.getX()-0.5*xDiff, node.getY()-0.1*yDiff, ""+node.getValue());
                }
                text.setFont(font);
                System.out.println(node);
                root.getChildren().add(line);
                root.getChildren().add(circle);
                root.getChildren().add(text);
            }
        }
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    /**
     * @return the tree
     */
    public static BinaryTree getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public static void setTree(BinaryTree aTree) {
        tree = aTree;
    }
    
    public static void main(String args[]){
        SecureRandom random = new SecureRandom();
        AVLTree t = new AVLTree();
        
        BinaryTreeNode root = new AVLTreeNode(50);
        t.setRoot(root);
        List<AVLTreeNode> list = new ArrayList();
        for(int i = 0; i < 20; i++){
            AVLTreeNode node = new AVLTreeNode((int)(Math.random()*100));
            root.addNode(node);  //insert word into Binary Search Tree
            list.add(node);
        }
        setTree(t);
        launch();
    }
    
}
