package masa3mc.survivalrecipes;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class SurvivalRecipes extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        concretes();
        coal();
        boolean lightBlockAdd = getServer().addRecipe(lightBlock());
        Bukkit.addRecipe(pumpkin());
        Bukkit.addRecipe(xpBottle());
        Bukkit.addRecipe(book());
        Bukkit.addRecipe(paper());
        //スポーンエッグ的サムシング
        SpawnEgg spawnEgg = new SpawnEgg();
        spawnEgg.loadRecipes();
        //投票コイン的サムシング
        VoteCoin voteCoin = new VoteCoin();
        voteCoin.loop();
        getCommand("votecoin").setExecutor(voteCoin);
        getLogger().info(ChatColor.GREEN + "SurvivalRecipes was enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.GREEN + "SurvivalRecipes was disabled.");

    }

    private void concretes() {
        List<Material> concrete = new ArrayList<>();
        List<Material> concretePowder = new ArrayList<>();
        concrete.addAll(Arrays.asList(Material.WHITE_CONCRETE, Material.ORANGE_CONCRETE, Material.MAGENTA_CONCRETE, Material.LIGHT_BLUE_CONCRETE, Material.YELLOW_CONCRETE,
                Material.LIME_CONCRETE, Material.PINK_CONCRETE, Material.GRAY_CONCRETE, Material.LIGHT_GRAY_CONCRETE, Material.CYAN_CONCRETE, Material.PURPLE_CONCRETE,
                Material.BLUE_CONCRETE, Material.BROWN_CONCRETE, Material.GREEN_CONCRETE, Material.RED_CONCRETE, Material.BLACK_CONCRETE));
        concretePowder.addAll(Arrays.asList(Material.WHITE_CONCRETE_POWDER, Material.ORANGE_CONCRETE_POWDER, Material.MAGENTA_CONCRETE_POWDER, Material.LIGHT_BLUE_CONCRETE_POWDER,
                Material.YELLOW_CONCRETE_POWDER, Material.LIME_CONCRETE_POWDER, Material.PINK_CONCRETE_POWDER, Material.GRAY_CONCRETE_POWDER, Material.LIGHT_GRAY_CONCRETE_POWDER,
                Material.CYAN_CONCRETE_POWDER, Material.PURPLE_CONCRETE_POWDER, Material.BLUE_CONCRETE_POWDER, Material.BROWN_CONCRETE_POWDER, Material.GREEN_CONCRETE_POWDER,
                Material.RED_CONCRETE_POWDER, Material.BLACK_CONCRETE_POWDER));
        for (int i = 0; i < 16; i++) {
            ItemStack item = new ItemStack(concrete.get(i));
            ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft(concrete.get(i).name().toLowerCase()), item);
            recipe.addIngredient(1, concretePowder.get(i));
            Bukkit.addRecipe(recipe);
        }
    }

    public ShapelessRecipe pumpkin() {
        ItemStack item = new ItemStack(Material.CARVED_PUMPKIN, 4);
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("pumpkin"), item);
        recipe.addIngredient(4, Material.PUMPKIN);
        return recipe;
    }

    public ShapelessRecipe xpBottle() {
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("xp"), new ItemStack(Material.EXPERIENCE_BOTTLE));
        recipe.addIngredient(1, Material.ENDER_EYE);
        recipe.addIngredient(1, Material.GLASS_BOTTLE);
        return recipe;
    }

    public ShapedRecipe lightBlock() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "light"), new ItemStack(Material.LIGHT, 4));
        recipe.shape("ATA", "TGT", "ATA");
        recipe.setIngredient('G', Material.GLOWSTONE);
        recipe.setIngredient('T', Material.TINTED_GLASS);
        recipe.setIngredient('A', Material.AIR);
        return recipe;
    }

    public ShapelessRecipe book() {
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("book_shelf"), new ItemStack(Material.BOOK, 3));
        recipe.addIngredient(1, Material.BOOKSHELF);
        return recipe;
    }

    public ShapelessRecipe paper() {
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("paper_book"), new ItemStack(Material.PAPER, 3));
        recipe.addIngredient(1, Material.BOOK);
        return recipe;
    }

    public void coal() {
        HashMap<Material, Material> trans = new HashMap<>();
        trans.put(Material.CHARCOAL, Material.COAL);
        trans.put(Material.COAL, Material.CHARCOAL);
        List<Material> coals = new ArrayList<>(Arrays.asList(Material.CHARCOAL, Material.COAL));
        List<Material> logs = new ArrayList<>(Arrays.asList(Material.OAK_LOG, Material.SPRUCE_LOG, Material.BIRCH_LOG, Material.JUNGLE_LOG, Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.MANGROVE_LOG, Material.CRIMSON_STEM, Material.WARPED_STEM));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, coals.get(i).name() + "_" + logs.get(j)), new ItemStack(trans.get(coals.get(i)), 8));
                recipe.shape("LLL", "LCL", "LLL");
                recipe.setIngredient('L', logs.get(j));
                recipe.setIngredient('C', coals.get(i));
                Bukkit.addRecipe(recipe);
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (event.getClickedBlock().getType() == Material.LIGHT) {
                if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
                    Block block = event.getClickedBlock();
                    block.setType(Material.AIR);
                    block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.LIGHT));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPrepareItemCraft(PrepareItemCraftEvent e) {
        ItemStack targetItem = e.getInventory().getContents()[0];
        List<String> groupArray = new ArrayList<>(Arrays.asList("group.iron-2", "group.iron-3", "group.gold-1", "group.gold-2", "group.gold-3", "group.diamond-1", "group.diamond-2",
                "group.diamond-3", "group.netherite-1", "group.netherite-2", "group.netherite-3", "group.professional-crafter", "group.master", "group.emperor", "group.god"));
        SpawnEgg spawnEgg = new SpawnEgg();
        Player p = (Player) e.getView().getPlayer();
        /*
          123
          456 0
          789
        */
        if (e.getInventory().getItem(0) != null) {
            boolean craftable = false;
            //ケースバイケースで追加
            switch (targetItem.getType()) {
                case LIGHT:
                    for (String group : groupArray) {
                        if (p.hasPermission(group)) {
                            craftable = true;
                            break;
                        }
                    }
                    break;
                case CHARCOAL:
                case COAL:
                    HashMap<Material, Material> trans = new HashMap<>();
                    trans.put(Material.CHARCOAL, Material.COAL);
                    trans.put(Material.COAL, Material.CHARCOAL);
                    if (e.getInventory().containsAtLeast(new ItemStack(trans.get(targetItem.getType())), 1))
                        for (String group : groupArray) {
                            if (p.hasPermission(group)) {
                                craftable = true;
                                break;
                            }
                        }
                    break;
                case BOOK:
                    if (e.getInventory().containsAtLeast(new ItemStack(Material.BOOKSHELF), 1))
                        for (String group : groupArray) {
                            if (p.hasPermission(group)) {
                                craftable = true;
                                break;
                            }
                        }
                    break;
                case PAPER:
                    if (e.getInventory().containsAtLeast(new ItemStack(Material.BOOK), 1))
                        for (String group : groupArray) {
                            if (p.hasPermission(group)) {
                                craftable = true;
                                break;
                            }
                        }
                    break;
                case SHULKER_SPAWN_EGG:
                case WITCH_SPAWN_EGG:
                case VILLAGER_SPAWN_EGG:
                case PILLAGER_SPAWN_EGG:
                case GHAST_SPAWN_EGG:
                    if (e.getInventory().getContents()[2].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[4].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[6].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[8].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
                case SLIME_SPAWN_EGG:
                case HOGLIN_SPAWN_EGG:
                case CREEPER_SPAWN_EGG:
                    if (e.getInventory().getContents()[2].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[8].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
                case VINDICATOR_SPAWN_EGG:
                    if (e.getInventory().getContents()[2].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
                case WITHER_SKELETON_SPAWN_EGG:
                case GUARDIAN_SPAWN_EGG:
                    if (e.getInventory().getContents()[1].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[3].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[7].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[9].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
                case PIGLIN_SPAWN_EGG:
                    if (e.getInventory().getContents()[7].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[8].equals(spawnEgg.containerOfLives()))
                    if (e.getInventory().getContents()[9].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
                case PHANTOM_SPAWN_EGG:
                case ENDERMITE_SPAWN_EGG:
                case ENDERMAN_SPAWN_EGG:
                case AXOLOTL_SPAWN_EGG:
                    if (e.getInventory().getContents()[5].equals(spawnEgg.containerOfLives()))
                        craftable = true;
                    break;
            }
            if (!craftable) e.getInventory().setItem(0, new ItemStack(Material.AIR));
            else e.getInventory().setItem(0, targetItem);
        }
    }
}
