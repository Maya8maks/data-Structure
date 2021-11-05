package com.borshcheva.datastructure;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class ReflectionUtilsTest {

    @Test
    public void testCreateObjectBasedOnDefaultConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

      Object obj =  ReflectionUtils.create(TestVo.class);
      assertNotNull(obj);
      assertEquals(TestVo.class, obj.getClass() );
      TestVo testVo = (TestVo) obj;

      assertTrue(testVo.isCreatedWithDefaultConstructor);
      assertFalse(testVo.isCreatedWithIntConstructor);
    }
}
