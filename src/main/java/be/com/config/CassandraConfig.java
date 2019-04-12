package be.com.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;

import static be.com.config.Properties.getProperties;

public class CassandraConfig {


    private static Cluster cassanddraCluster() {
        return Cluster.builder().withPort(getPort()).addContactPoint(getIp()).build();
    }

    private static Session session() {
        return cassanddraCluster().connect(getKeyspace());
    }

    public static MappingManager mappingManager() {
        return new MappingManager(session());
    }

    public static void close(){
        session().close();
        cassanddraCluster().close();
    }

    private static String getIp() {
        return getProperties().getProperty("cassandra.ip");
    }

    private static String getKeyspace() {
        return getProperties().getProperty(("cassandra.keyspace"));
    }

    private static int getPort() {
        return Integer.parseInt(getProperties().getProperty("cassandra.port"));
    }
}
