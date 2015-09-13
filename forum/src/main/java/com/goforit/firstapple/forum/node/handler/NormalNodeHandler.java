package com.goforit.firstapple.forum.node.handler;

import org.springframework.stereotype.Service;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.model.NodeResult;
import com.goforit.firstapple.forum.model.NormalNode;
import com.goforit.firstapple.forum.node.engine.Node;

@Service
public class NormalNodeHandler implements NodeHandler{

    @Override
    public NodeResult execute(Node node) {
        NodeResult result=new NodeResult();
        
        NormalNode normalNode=(NormalNode)node;
        System.err.println("message:"+normalNode.getMsg());
        result.setStatus(NodeStatusEnum.SUCCESS);
        result.setMessage("success");
        return result;
    }

    @Override
    public void callBack(Node node, NodeResult result) {
        
        Node parent=node.getParent();
        if( parent!=null){
            switch (result.getStatus()) {
                case EXECUTING:
                    System.err.println("say hello");
                    callBack(parent, result);
                    break;
                case LOCK:
                    System.err.println("say lock");
                    callBack(parent, result);
                default:
                    break;
            }
        }
        
        
        
        
    }

    @Override
    public boolean validate(Node node) {
        return true;
    }

    @Override
    public void sentToChildren(Node node, NodeStatusEnum status) {
    }
    

}
