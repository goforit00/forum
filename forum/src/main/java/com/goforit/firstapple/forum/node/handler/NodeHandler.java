package com.goforit.firstapple.forum.node.handler;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.model.NodeResult;
import com.goforit.firstapple.forum.node.engine.Node;

public interface NodeHandler {
    
    public NodeResult execute(Node node);
    
    public void callBack(Node node,NodeResult result);
    
    public void sentToChildren(Node node,NodeStatusEnum status);

    public  boolean validate(Node node);
}
