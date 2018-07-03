/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class NewEmptyJUnitTest {
    
    private EJBContainer container;
    
    public NewEmptyJUnitTest() {
    }

    
    @Before
    public void setUp() {
         container = EJBContainer.createEJBContainer();
         System.out.println("EJBContainer instantiated");
    }
    
    @Test
    public void tearDown() {
        System.out.println("container: " + container);
                
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
