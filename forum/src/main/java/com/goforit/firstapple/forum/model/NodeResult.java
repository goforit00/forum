package com.goforit.firstapple.forum.model;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;

public class NodeResult {
    
    private NodeStatusEnum status;
    
    private String message;

    public NodeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(NodeStatusEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

}
