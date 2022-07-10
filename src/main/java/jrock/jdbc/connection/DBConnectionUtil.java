package jrock.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static jrock.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    // java jdbc connection
    public static Connection getConnection() {

        try {
            /**
             * DriverManager - JDBC가 제공하는 DriverManager 는 라이브러리에 등록된 DB 드라이버들을 관리하고, 커넥션을 획득하는 기능을 제공한다.
             */
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 커넥션 요청
            log.info("get connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException(e); // checked exception -> runtime exception 으로 던짐.
        }
    }
}
