package com.goforit.firstapple.forum.node.engine;


import com.goforit.firstapple.forum.model.NodeResult;

public interface GraphNodeEngine {
    
    public NodeResult execute(Node node);
    
}
