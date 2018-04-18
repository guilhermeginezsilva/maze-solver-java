package app.model;

import java.util.List;

public class Actor {

    public int[][] exploredMap;
    public Coord2D position;
    public Node currentNode;


    public Actor(int mapWidth, int mapHeight, Coord2D startPosition) {
        this.exploredMap = new int[mapWidth][mapHeight];
        this.position = startPosition;
    }

    public int act() {

        System.out.println("Posição: "+position.x + "/"+position.y);

        Coord2D end = World.scenery.hasEndAround(position);
        if(end != null) {
            return 1;
        }

        if(currentNode == null) {
            this.currentNode = new Node(this.position);
            this.exploredMap[position.x][position.y] = 1;
            findSomeWay();
        } else {
            if(currentNode.children.size() > 0) {
                Node parent = currentNode;
                currentNode = currentNode.children.get(0);
                currentNode.parent = parent;
                this.position = currentNode.nodeId;
                this.exploredMap[position.x][position.y] = 1;
                findSomeWay();
            } else {
                if(currentNode.parent != null) {
                    Node parent = currentNode.parent;
                    parent.children.remove(currentNode);
                    this.currentNode = parent;
                    this.position = currentNode.nodeId;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    private void findSomeWay() {
        List<Coord2D> pathCoords = World.scenery.hasPathAround(position);
        int iteration =0;
        for(Coord2D pathCoord: World.scenery.hasPathAround(position)) {
            if(this.exploredMap[pathCoord.x][pathCoord.y] == 0) {
                this.currentNode.children.add(new Node(pathCoord));
            }
            iteration++;
        }
    }
}
