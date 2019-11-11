package com.buyou.eventuateio.local.sample;

import io.eventuate.AggregateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Create date 2019-11-12
 *
 * @author evan
 */
@Component
public class AccountRunner implements CommandLineRunner {


  private AggregateRepository<Account, AccountCommand> aggregateRepository;

  public AccountRunner(AggregateRepository<Account, AccountCommand> aggregateRepository) {
    this.aggregateRepository = aggregateRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    CreateAccountCommand command = new CreateAccountCommand();
    command.setName("hello");
    if (null != aggregateRepository) {
      aggregateRepository.save(command);
    }

  }
}
