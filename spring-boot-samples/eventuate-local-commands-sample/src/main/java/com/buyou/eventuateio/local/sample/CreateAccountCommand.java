package com.buyou.eventuateio.local.sample;

/**
 * Create date 2019-11-12
 *
 * @author evan
 */
public class CreateAccountCommand implements AccountCommand {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
