package org.badcoding;

import org.badcoding.hibernate.logic.Factory;
import org.badcoding.hibernate.stored.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class UserDAOImplTest {

    @Test
    public void testGetUserById() {
        User user = Factory.GetInstance().getUserDAO().getUserById(1);
        assertEquals(user.getUserId(), (Integer)1);
    }

}