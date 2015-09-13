package com.goforit.firstapple.forum.model;

import java.sql.Date;
import java.util.List;

import com.goforit.firstapple.forum.enums.NodeStatusEnum;
import com.goforit.firstapple.forum.enums.NodeTypeEnum;
import com.goforit.firstapple.forum.node.engine.Node;

public class GraphNode implements Node{
    
    private long id;
    
    private long parentId;
    
    private NodeStatusEnum status;
    
    private NodeTypeEnum type;
    
    private Date beginTime;
    
    private Date endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public NodeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(NodeStatusEnum status) {
        this.status = status;
    }

    public NodeTypeEnum getType() {
        return type;
    }

    public void setType(NodeTypeEnum type) {
        this.type = type;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public Node getParent() {
        return null;
    }

    @Override
    public List<Node> getChildrenNodes() {
        return null;
    }

    @Override
    public boolean permissionFail() {
        return false;
    }
    
    

}
