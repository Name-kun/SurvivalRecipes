package masa3mc.survivalrecipes;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

import static java.util.UUID.randomUUID;

public class VoteCoin implements CommandExecutor {

    SurvivalRecipes plugin = JavaPlugin.getPlugin(SurvivalRecipes.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("votecoin")) {
            if (args.length == 0) sender.sendMessage("だめでーす");
            else {
                Player p = Bukkit.getPlayerExact(args[0]);
                if (p != null) {
                    if (args.length == 1) sender.sendMessage("なににするかえらんどけ");
                    else {
                        ItemStack item = null;
                        try {
                            switch (Integer.parseInt(args[1])) {
                                case 0:
                                    item = voteCoin(p);
                                    break;
                                case 1:
                                    item = bambooSpear();
                                    break;
                                case 2:
                                    item = nukeManObserver();
                                    break;
                                case 3:
                                    item = potion();
                                    break;
                                case 4:
                                    item = nameKunHead();
                                    break;
                            }
                            p.getInventory().addItem(item);
                        } catch (NumberFormatException e) {
                            p.sendMessage("うんちー");
                        }
                    }
                }
            }
        }
        return false;
    }

    ItemStack voteCoin(Player p) {
        int i = (!(p.hasPermission("sub.small") || p.hasPermission("sub.large")) ? 1 : (p.hasPermission("sub.large") ? 4 : 2));
        ItemStack item = new ItemStack(Material.SUNFLOWER, i);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§l投票コイン");
        meta.setLore(Arrays.asList("参加しながら投票をすることで貰えるコイン。", "色々なモノと交換できる。"));
        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    ItemStack bambooSpear() {
        ItemStack item = new ItemStack(Material.BAMBOO);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§l竹§2§l槍");
        meta.setLore(Collections.singletonList("なお性能は普通の木の剣。"));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(randomUUID(), "attr", -2.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(randomUUID(), "attr", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    ItemStack nukeManObserver() {
        ItemStack item = new ItemStack(Material.OBSERVER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§lなめくん§7§lオブザーバー");
        meta.setLore(Arrays.asList("どこかで見たことのあるオブザーバー。", "これを被っていた人がどこかにいたような...？"));


        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setString("voteCoin", "nukeManObserver");
        nbtItem.applyNBT(item);
        item.setItemMeta(meta);

        return item;
    }

    ItemStack potion() {
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setDisplayName("§5§lインスタントどうやってここまで？");
        List<PotionEffectType> potionEffects = new ArrayList<>(Arrays.asList(PotionEffectType.BLINDNESS, PotionEffectType.ABSORPTION, PotionEffectType.BAD_OMEN, PotionEffectType.CONDUIT_POWER, PotionEffectType.CONFUSION,
                PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.DARKNESS, PotionEffectType.DOLPHINS_GRACE, PotionEffectType.FAST_DIGGING, PotionEffectType.FIRE_RESISTANCE, PotionEffectType.GLOWING,
                PotionEffectType.HARM, PotionEffectType.HEAL, PotionEffectType.HEALTH_BOOST, PotionEffectType.HERO_OF_THE_VILLAGE, PotionEffectType.HUNGER, PotionEffectType.INCREASE_DAMAGE, PotionEffectType.INVISIBILITY,
                PotionEffectType.JUMP, PotionEffectType.LEVITATION, PotionEffectType.LUCK, PotionEffectType.NIGHT_VISION, PotionEffectType.POISON, PotionEffectType.REGENERATION, PotionEffectType.SATURATION,
                PotionEffectType.SLOW, PotionEffectType.SLOW_DIGGING, PotionEffectType.SLOW_FALLING, PotionEffectType.SPEED, PotionEffectType.UNLUCK, PotionEffectType.WATER_BREATHING, PotionEffectType.WEAKNESS,
                PotionEffectType.WITHER));
        potionEffects.forEach(effects -> meta.addCustomEffect(new PotionEffect(effects, 36000, 0), false));
        meta.setColor(Color.GREEN);
        meta.setLore(Arrays.asList("飲むと\"どうやってここまで？\"が解放される。", "牛乳は絶対に用意しようね！"));
        item.setItemMeta(meta);
        return item;
    }

    ItemStack nameKunHead() {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString("562af224-aaf9-4141-af00-44ebda30cbbc")));
        meta.setDisplayName("§e§lなめくじ体験用ヘッド");
        meta.setLore(Collections.singletonList("これを付けたら君もOwner！？"));
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(randomUUID(), "attr", -0.09, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        item.setItemMeta(meta);
        return item;
    }

    void loop() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().equals(nukeManObserver()))
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 0));
            }
        }, 0L, 20L);
    }
}
