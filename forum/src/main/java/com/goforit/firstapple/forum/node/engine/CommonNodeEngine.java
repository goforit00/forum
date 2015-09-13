package com.goforit.firstapple.forum.node.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.model.NodeResult;
import com.goforit.firstapple.forum.node.handler.NodeHandler;


@Service
public  class CommonNodeEngine implements GraphNodeEngine {

    @Autowired
    private NodeHandlerFactory nodeHandlerFactory;

    @Override
    public NodeResult execute(Node node) {
        NodeResult result = new NodeResult();

        NodeHandler handler = nodeHandlerFactory.getHandler(node.getType());

        //validate
        if (!handler.validate(node)) {
            result.setStatus(NodeStatusEnum.FAILED);
            result.setMessage("validate error");
            return result;
        }

        //execute
        List<Node> childrenNodes = node.getChildrenNodes();
        for (Node child : childrenNodes) {

            //handler child
            NodeHandler childHandler = nodeHandlerFactory.getHandler(child.getType());
            NodeResult childResult = childHandler.execute(child);

            if (childResult.getStatus() == NodeStatusEnum.FAILED && !child.permissionFail()) {
                return childResult;
            }
        }

        //handler self
        result = handler.execute(node);

        return result;
    }

}
