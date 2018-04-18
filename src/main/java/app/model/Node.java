package app.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public final Coord2D nodeId;

    public Node parent;
    public List<Node> children = new ArrayList<Node>();

    public Node(Coord2D nodeId) {
        this.nodeId = nodeId;
    }

    public Node(Coord2D nodeId, Node parent) {
        this.nodeId = nodeId;
        this.parent = parent;
    }

    public Node(Coord2D nodeId, List<Node> children) {
        this.nodeId = nodeId;
        this.children = children;
    }

    public Node(Coord2D nodeId, List<Node> children, Node parent) {
        this.nodeId = nodeId;
        this.children = children;
        this.parent = parent;
    }
}
