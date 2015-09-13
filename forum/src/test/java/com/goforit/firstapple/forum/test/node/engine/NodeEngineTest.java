package com.goforit.firstapple.forum.test.node.engine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goforit.firstapple.forum.model.NormalNode;
import com.goforit.firstapple.forum.node.engine.CommonNodeEngine;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class NodeEngineTest {
    
    @Autowired
    private CommonNodeEngine commonNodeEngine;

    @Test
    public void testEngine(){
        NormalNode node=new NormalNode();
        node.setMsg("this is node");
        
        NormalNode parent=new NormalNode();
        parent.setMsg("this is parent");
        
        NormalNode child1=new NormalNode();
        child1.setMsg("this is child 1");
        
        NormalNode child2=new NormalNode();
        child2.setMsg("this is child 2");
        
        node.setParent(parent);
        List<NormalNode> childrens=new ArrayList<NormalNode>();
        childrens.add(child2);
        childrens.add(child1);
        node.setChildrens(childrens);
        
        commonNodeEngine.execute(node);
        
    }
}
