package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void doOperation(String fruit, int numbers) {
        Storage.storageMap.put(fruit, Storage.storageMap.get(fruit) + numbers);
    }
}