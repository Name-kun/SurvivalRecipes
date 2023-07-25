package masa3mc.survivalrecipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpawnEgg implements Listener {

    SurvivalRecipes plugin = JavaPlugin.getPlugin(SurvivalRecipes.class);

    public void loadRecipes() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        containerOfLivesRecipe();
        shulker();
        slime();
        vindicator();
        witch();
        witherSkeleton();
        villager();
        zombieVillager();
        zoglin();
        zombifiedPiglin();
        pillager();
        piglin();
        phantom();
        hoglin();
        guardian();
        ghast();
        enderMan();
        enderMite();
        creeper();
        axolotl();
    }

    //生命の器
    public ItemStack containerOfLives() {
        ItemStack container = new ItemStack(Material.NETHER_STAR);
        ItemMeta containerMeta = container.getItemMeta();
        containerMeta.setDisplayName("§e§l生命の器");
        List<String> lore = new ArrayList<>();
        lore.addAll(Arrays.asList("スポーンエッグを作るための材料。", "アドミンショップのNPCに中身を入れてもらうか、", "自分でクラフトして中身を入れよう。"));
        containerMeta.setLore(lore);
        container.setItemMeta(containerMeta);
        return container;
    }

    //生命の器レシピ登録
    private void containerOfLivesRecipe() {
        NamespacedKey containerKey = new NamespacedKey(plugin, "containerOfLives");
        ShapedRecipe containerRecipe = new ShapedRecipe(containerKey, containerOfLives());
        containerRecipe.shape("NEN", "TAT", "NEN");
        containerRecipe.setIngredient('N', Material.NETHER_STAR);
        containerRecipe.setIngredient('E', Material.EGG);
        containerRecipe.setIngredient('T', Material.TURTLE_EGG);
        containerRecipe.setIngredient('A', Material.AIR);
        Bukkit.addRecipe(containerRecipe);
    }

    private void shulker() {
        NamespacedKey shulkerKey = new NamespacedKey(plugin, "shulkerEgg");
        ShapedRecipe shulkerRecipe = new ShapedRecipe(shulkerKey, new ItemStack(Material.SHULKER_SPAWN_EGG));
        shulkerRecipe.shape("SNS", "NCN", "SNS");
        shulkerRecipe.setIngredient('S', Material.SHULKER_SHELL);
        shulkerRecipe.setIngredient('N', Material.NETHER_STAR);
        shulkerRecipe.setIngredient('C', Material.CHORUS_FRUIT);
        Bukkit.addRecipe(shulkerRecipe);
    }

    private void slime() {
        NamespacedKey slimeKey = new NamespacedKey(plugin, "slimeEgg");
        ShapedRecipe slimeRecipe = new ShapedRecipe(slimeKey, new ItemStack(Material.SLIME_SPAWN_EGG));
        slimeRecipe.shape("SNS", "BSB", "SNS");
        slimeRecipe.setIngredient('S', Material.SLIME_BLOCK);
        slimeRecipe.setIngredient('B', Material.SLIME_BALL);
        slimeRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(slimeRecipe);
    }

    private void vindicator() {
        NamespacedKey vindicatorKey = new NamespacedKey(plugin, "vindicatorEgg");
        ShapedRecipe vindicatorRecipe = new ShapedRecipe(vindicatorKey, new ItemStack(Material.VINDICATOR_SPAWN_EGG));
        vindicatorRecipe.shape("ENE", "EPE", "EIE");
        vindicatorRecipe.setIngredient('E', Material.EMERALD);
        vindicatorRecipe.setIngredient('N', Material.NETHER_STAR);
        vindicatorRecipe.setIngredient('P', Material.PILLAGER_SPAWN_EGG);
        vindicatorRecipe.setIngredient('I', Material.IRON_AXE);
        Bukkit.addRecipe(vindicatorRecipe);
    }

    private void witch() {
        NamespacedKey witchKey = new NamespacedKey(plugin, "witchEgg");
        ShapedRecipe witchRecipe = new ShapedRecipe(witchKey, new ItemStack(Material.WITCH_SPAWN_EGG));
        witchRecipe.shape("RNG", "NBN", "PNW");
        witchRecipe.setIngredient('R', Material.REDSTONE);
        witchRecipe.setIngredient('N', Material.NETHER_STAR);
        witchRecipe.setIngredient('G', Material.GLOWSTONE_DUST);
        witchRecipe.setIngredient('B', Material.BREWING_STAND);
        witchRecipe.setIngredient('P', Material.GUNPOWDER);
        witchRecipe.setIngredient('W', Material.NETHER_WART);
        Bukkit.addRecipe(witchRecipe);
    }

    private void witherSkeleton() {
        NamespacedKey witherSkeletonKey = new NamespacedKey(plugin, "witherSkeletonEgg");
        ShapedRecipe witherSkeletonRecipe = new ShapedRecipe(witherSkeletonKey, new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG));
        witherSkeletonRecipe.shape("NCN", "WEW", "NSN");
        witherSkeletonRecipe.setIngredient('N', Material.NETHER_STAR);
        witherSkeletonRecipe.setIngredient('C', Material.COAL_BLOCK);
        witherSkeletonRecipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        witherSkeletonRecipe.setIngredient('E', Material.SKELETON_SPAWN_EGG);
        witherSkeletonRecipe.setIngredient('S', Material.STONE_SWORD);
        Bukkit.addRecipe(witherSkeletonRecipe);
    }

    private void villager() {
        NamespacedKey villagerKey = new NamespacedKey(plugin, "villagerEgg");
        ShapedRecipe villagerRecipe = new ShapedRecipe(villagerKey, new ItemStack(Material.VILLAGER_SPAWN_EGG));
        villagerRecipe.shape("ENE", "NBN", "ENE");
        villagerRecipe.setIngredient('N', Material.NETHER_STAR);
        villagerRecipe.setIngredient('E', Material.EMERALD);
        villagerRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        Bukkit.addRecipe(villagerRecipe);
    }

    private void zombieVillager() {
        NamespacedKey zombieVillagerKey = new NamespacedKey(plugin, "zombieVillagerEgg");
        ShapedRecipe zombieVillagerRecipe = new ShapedRecipe(zombieVillagerKey, new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
        zombieVillagerRecipe.shape("AVA", "RAR", "AZA");
        zombieVillagerRecipe.setIngredient('A', Material.AIR);
        zombieVillagerRecipe.setIngredient('V', Material.VILLAGER_SPAWN_EGG);
        zombieVillagerRecipe.setIngredient('R', Material.ROTTEN_FLESH);
        zombieVillagerRecipe.setIngredient('Z', Material.ZOMBIE_SPAWN_EGG);
        Bukkit.addRecipe(zombieVillagerRecipe);
    }

    private void zoglin() {
        NamespacedKey zoglinKey = new NamespacedKey(plugin, "zoglinEgg");
        ShapedRecipe zoglinRecipe = new ShapedRecipe(zoglinKey, new ItemStack(Material.ZOGLIN_SPAWN_EGG));
        zoglinRecipe.shape("ARA", "RHR", "ARA");
        zoglinRecipe.setIngredient('A', Material.AIR);
        zoglinRecipe.setIngredient('R', Material.ROTTEN_FLESH);
        zoglinRecipe.setIngredient('H', Material.HOGLIN_SPAWN_EGG);
        Bukkit.addRecipe(zoglinRecipe);
    }

    private void zombifiedPiglin() {
        NamespacedKey zombifiedPiglinKey = new NamespacedKey(plugin, "zombifiedPiglinEgg");
        ShapedRecipe zombifiedPiglinRecipe = new ShapedRecipe(zombifiedPiglinKey, new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG));
        zombifiedPiglinRecipe.shape("ARA", "RPR", "ARA");
        zombifiedPiglinRecipe.setIngredient('A', Material.AIR);
        zombifiedPiglinRecipe.setIngredient('R', Material.ROTTEN_FLESH);
        zombifiedPiglinRecipe.setIngredient('P', Material.PIGLIN_SPAWN_EGG);
        Bukkit.addRecipe(zombifiedPiglinRecipe);
    }

    private void pillager() {
        NamespacedKey pillagerKey = new NamespacedKey(plugin, "pillagerEgg");
        ShapedRecipe pillagerRecipe = new ShapedRecipe(pillagerKey, new ItemStack(Material.PILLAGER_SPAWN_EGG));
        pillagerRecipe.shape("ENE", "NCN", "ENE");
        pillagerRecipe.setIngredient('E', Material.EMERALD);
        pillagerRecipe.setIngredient('N', Material.NETHER_STAR);
        pillagerRecipe.setIngredient('C', Material.CROSSBOW);
        Bukkit.addRecipe(pillagerRecipe);
    }

    private void piglin() {
        NamespacedKey piglinKey = new NamespacedKey(plugin, "piglinEgg");
        ShapedRecipe piglinRecipe = new ShapedRecipe(piglinKey, new ItemStack(Material.PIGLIN_SPAWN_EGG));
        piglinRecipe.shape("SIS", "CIC", "NNN");
        piglinRecipe.setIngredient('S', Material.GOLDEN_SWORD);
        piglinRecipe.setIngredient('I', Material.GOLD_INGOT);
        piglinRecipe.setIngredient('C', Material.CROSSBOW);
        piglinRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(piglinRecipe);
    }

    private void phantom() {
        NamespacedKey phantomKey = new NamespacedKey(plugin, "phantomEgg");
        ShapedRecipe phantomRecipe = new ShapedRecipe(phantomKey, new ItemStack(Material.PHANTOM_SPAWN_EGG));
        phantomRecipe.shape("APA", "PNP", "APA");
        phantomRecipe.setIngredient('A', Material.AIR);
        phantomRecipe.setIngredient('P', Material.PHANTOM_MEMBRANE);
        phantomRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(phantomRecipe);
    }

    private void hoglin() {
        NamespacedKey hoglinKey = new NamespacedKey(plugin, "hoglinEgg");
        ShapedRecipe hoglinRecipe = new ShapedRecipe(hoglinKey, new ItemStack(Material.HOGLIN_SPAWN_EGG));
        hoglinRecipe.shape("RNR", "LPL", "RNR");
        hoglinRecipe.setIngredient('R', Material.PORKCHOP);
        hoglinRecipe.setIngredient('L', Material.LEATHER);
        hoglinRecipe.setIngredient('P', Material.PIG_SPAWN_EGG);
        hoglinRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(hoglinRecipe);
    }

    private void guardian() {
        NamespacedKey guardianKey = new NamespacedKey(plugin, "guardianEgg");
        ShapedRecipe guardianRecipe = new ShapedRecipe(guardianKey, new ItemStack(Material.GUARDIAN_SPAWN_EGG));
        guardianRecipe.shape("NCN", "SRS", "NCN");
        guardianRecipe.setIngredient('C', Material.PRISMARINE_CRYSTALS);
        guardianRecipe.setIngredient('S', Material.PRISMARINE_SHARD);
        guardianRecipe.setIngredient('R', Material.COD);
        guardianRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(guardianRecipe);
    }

    private void ghast() {
        NamespacedKey ghastKey = new NamespacedKey(plugin, "ghastEgg");
        ShapedRecipe ghastRecipe = new ShapedRecipe(ghastKey, new ItemStack(Material.GHAST_SPAWN_EGG));
        ghastRecipe.shape("TNT", "NGN", "TNT");
        ghastRecipe.setIngredient('T', Material.GHAST_TEAR);
        ghastRecipe.setIngredient('G', Material.GUNPOWDER);
        ghastRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(ghastRecipe);
    }

    private void enderMite() {
        NamespacedKey enderMiteKey = new NamespacedKey(plugin, "enderMiteEgg");
        ShapedRecipe enderMiteRecipe = new ShapedRecipe(enderMiteKey, new ItemStack(Material.ENDERMITE_SPAWN_EGG));
        enderMiteRecipe.shape("PPP", "PNP", "PSP");
        enderMiteRecipe.setIngredient('P', Material.ENDER_PEARL);
        enderMiteRecipe.setIngredient('S', Material.SILVERFISH_SPAWN_EGG);
        enderMiteRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(enderMiteRecipe);
    }

    private void enderMan() {
        NamespacedKey enderManKey = new NamespacedKey(plugin, "enderManEgg");
        ShapedRecipe enderManRecipe = new ShapedRecipe(enderManKey, new ItemStack(Material.ENDERMAN_SPAWN_EGG));
        enderManRecipe.shape("APA", "PNP", "APA");
        enderManRecipe.setIngredient('A', Material.AIR);
        enderManRecipe.setIngredient('P', Material.ENDER_PEARL);
        enderManRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(enderManRecipe);
    }

    private void creeper() {
        NamespacedKey creeperKey = new NamespacedKey(plugin, "creeperEgg");
        ShapedRecipe creeperRecipe = new ShapedRecipe(creeperKey, new ItemStack(Material.CREEPER_SPAWN_EGG));
        creeperRecipe.shape("GNG", "TTT", "GNG");
        creeperRecipe.setIngredient('G', Material.GUNPOWDER);
        creeperRecipe.setIngredient('T', Material.TNT);
        creeperRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(creeperRecipe);
    }

    private void axolotl() {
        NamespacedKey axolotlKey = new NamespacedKey(plugin, "axolotlEgg");
        ShapedRecipe axolotlRecipe = new ShapedRecipe(axolotlKey, new ItemStack(Material.AXOLOTL_SPAWN_EGG));
        axolotlRecipe.shape("ACA", "ING", "ABA");
        axolotlRecipe.setIngredient('A', Material.AIR);
        axolotlRecipe.setIngredient('C', Material.COD);
        axolotlRecipe.setIngredient('I', Material.INK_SAC);
        axolotlRecipe.setIngredient('G', Material.GLOW_INK_SAC);
        axolotlRecipe.setIngredient('B', Material.AXOLOTL_BUCKET);
        axolotlRecipe.setIngredient('N', Material.NETHER_STAR);
        Bukkit.addRecipe(axolotlRecipe);
    }
}
