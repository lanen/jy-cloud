package com.buyou.spring.boot.autoconfigure.eventuateio.local;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 事件 Create date 2019-11-11.
 *
 * @author evan
 */
@ConfigurationProperties(prefix = "cqrs")
public class EventSourcingProperties {

  /**
   * 开启事件溯源.
   */
  private boolean enabled = false;

  /**
   * Eventuate Local Database.
   */
  private String database;

  /**
   * Kafka event store.
   */
  private Kafka kafka;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public Kafka getKafka() {
    return kafka;
  }

  public void setKafka(
      Kafka kafka) {
    this.kafka = kafka;
  }


  public static class Kafka {

    /**
     * kafka event store.
     */
    private String servers;

    public String getServers() {
      return servers;
    }

    public void setServers(String servers) {
      this.servers = servers;
    }
  }
}
