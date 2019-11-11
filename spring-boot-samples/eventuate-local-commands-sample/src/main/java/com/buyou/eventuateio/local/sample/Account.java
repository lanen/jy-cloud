package com.buyou.eventuateio.local.sample;

import io.eventuate.Event;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import java.util.ArrayList;
import java.util.List;

/**
 * Create date 2019-11-12
 *
 * @author evan
 */
public class Account extends ReflectiveMutableCommandProcessingAggregate<Account, AccountCommand> {

  private String name;

  public List<Event> process(CreateAccountCommand cmd) {

    List<Event> e = new ArrayList<>();
    AccountCreatedEvent event = new AccountCreatedEvent(cmd.getName());
    e.add(event);
    return e;
  }


  public void apply(AccountCreatedEvent e) {
    this.name = e.getName();
    System.out.println(this.name);
  }

}
