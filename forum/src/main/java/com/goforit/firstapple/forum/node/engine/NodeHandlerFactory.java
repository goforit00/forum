package com.goforit.firstapple.forum.node.engine;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.goforit.firstapple.forum.enums.NodeTypeEnum;
import com.goforit.firstapple.forum.node.handler.NodeHandler;

@Service
public class NodeHandlerFactory {
    
    private Map<NodeTypeEnum, NodeHandler> nodeHandlerMap;

    public Map<NodeTypeEnum, NodeHandler> getNodeHandlerMap() {
        return nodeHandlerMap;
    }

    public void setNodeHandlerMap(Map<NodeTypeEnum, NodeHandler> nodeHandlerMap) {
        this.nodeHandlerMap = nodeHandlerMap;
    }
    
    public NodeHandler getHandler(NodeTypeEnum type){
        return nodeHandlerMap.get(type);
    }
    

}
