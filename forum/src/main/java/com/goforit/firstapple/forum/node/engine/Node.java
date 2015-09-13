package com.goforit.firstapple.forum.node.engine;

import java.util.List;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.enums.NodeTypeEnum;


public interface Node{
    
    Node getParent();
    
    List<Node> getChildrenNodes();

    NodeStatusEnum getStatus();
    
    NodeTypeEnum getType();
    
    boolean permissionFail();
}
