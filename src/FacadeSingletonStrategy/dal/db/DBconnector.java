package FacadeSingletonStrategy.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DBconnector {

    private SQLServerDataSource dataSource;

    protected DBconnector()
    {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("CSe20B_19_FacadeSingletonStrategy");
        dataSource.setUser("CSe20B_19");
        dataSource.setPassword("snoozy1995");
        dataSource.setPortNumber(1433);
    }

    protected Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }


}
