package com.buyou.eventuateio.local.sample;

/**
 * Create date 2019-11-12
 *
 * @author evan
 */
public class AccountCreatedEvent implements AccountEvent {

  private String name;

  public AccountCreatedEvent(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
