public class GameSimulation {
    public static void main(String[] args) {
        Inventory heroInventory = new Inventory();

        heroInventory.addItem("silver coin", 11);

        Mission mission1 = new Mission("gold coin", 5, heroInventory);
        Mission mission2 = new Mission("silver coin", 10, heroInventory);

        heroInventory.addItem("gold coin", 3);
        heroInventory.addItem("gold coin", 2);
        heroInventory.addItem("silver coin", 8);
    }
}