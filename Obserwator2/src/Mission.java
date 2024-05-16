public class Mission implements Observer {
    private String itemName;
    private int requiredQuantity;
    private int currentQuantity;
    private Inventory inventory;

    public Mission(String itemName, int requiredQuantity, Inventory inventory) {
        System.out.println("Mission: Collect " + requiredQuantity + " " + itemName + "(s).");
        this.itemName = itemName;
        this.requiredQuantity = requiredQuantity;
        this.inventory = inventory;
        this.currentQuantity = inventory.getItemQuantity(itemName);
        this.inventory.subscribe(this);
        checkCompletion();
    }

    @Override
    public void update(String item, int quantity) {
        if (item.equals(itemName)) {
            currentQuantity = quantity;
            checkCompletion();
        }
    }

    private void checkCompletion() {
        if (currentQuantity >= requiredQuantity) {
            System.out.println("Mission complete: Collected " + requiredQuantity + " " + itemName + "(s).");
            inventory.unsubscribe(this);
        }
    }
}