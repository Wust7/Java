package com.wust.test;

import com.wust.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;


public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);

        }
    }
}
