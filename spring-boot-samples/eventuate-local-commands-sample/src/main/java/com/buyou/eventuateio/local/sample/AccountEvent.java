package com.buyou.eventuateio.local.sample;

import io.eventuate.Event;
import io.eventuate.EventEntity;

/**
 * Create date 2019-11-12
 *
 * @author evan
 */
@EventEntity(entity = "com.buyou.eventuateio.local.sample.Account")
public interface AccountEvent extends Event {

}
