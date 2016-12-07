/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Luis G
 */
public class Node {

    Node left = null;
    Node right = null;
    int data;

    public Node(int dato) {
        this.data = dato;
    }
}
