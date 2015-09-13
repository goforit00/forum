package com.goforit.firstapple.forum.model;


import java.util.ArrayList;
import java.util.List;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.enums.NodeTypeEnum;
import com.goforit.firstapple.forum.node.engine.Node;

public class NormalNode implements Node{
    
    private NormalNode parent;
    
    private List<NormalNode> childrens;
    
    private NodeStatusEnum status;
    
    private NodeTypeEnum type=NodeTypeEnum.NORMAL;
    
    private boolean permissionFail=false;
    
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public List<Node> getChildrenNodes() {
        List<Node> nodes=new ArrayList<Node>();
        for(NormalNode normalNode:childrens){
            nodes.add(normalNode);
        }
        return nodes;
    }

    @Override
    public NodeStatusEnum getStatus() {
        return status;
    }

    @Override
    public NodeTypeEnum getType() {
        return type;
    }

    @Override
    public boolean permissionFail() {
        return false;
    }

    
    
    
    public List<NormalNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<NormalNode> childrens) {
        this.childrens = childrens;
    }

    public boolean isPermissionFail() {
        return permissionFail;
    }

    public void setPermissionFail(boolean permissionFail) {
        this.permissionFail = permissionFail;
    }

    public void setParent(NormalNode parent) {
        this.parent = parent;
    }

    public void setStatus(NodeStatusEnum status) {
        this.status = status;
    }

    public void setType(NodeTypeEnum type) {
        this.type = type;
    }
    
    

}
