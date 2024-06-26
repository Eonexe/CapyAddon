package com.capy.capyaddon.modules;

import com.capy.capyaddon.CapyAddon;
import com.capy.capyaddon.utils.LogUtils;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.InvUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;

public class ShulkerDrop extends Module {
    public ShulkerDrop() {
        super(CapyAddon.CATEGORY, "ShulkerDrop", "a module that drops all shulkers in the inventory on the ground");
    }

    @Override
    public void onActivate() {
        LogUtils.sendMessage(Formatting.WHITE + "Turned the module called " + Formatting.GOLD + "ShulkerDrop" + Formatting.GREEN + " On");
        Inventory inventory = MinecraftClient.getInstance().player.getInventory();
        PlayerEntity player = MinecraftClient.getInstance().player;
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack itemStack = inventory.getStack(i);
            if (isShulker(itemStack)) {
                InvUtils.drop().slot(i);
            }
        }
        this.toggle();
    }

    private boolean isShulker(ItemStack itemStack) {
        String translationKey = itemStack.getTranslationKey();
        return translationKey.contains("shulker_box");
    }

    public void onDeactivate() {
        LogUtils.sendMessage(Formatting.WHITE + "Turned the module called " + Formatting.GOLD + "ShulkerDrop" + Formatting.RED + " Off");
    }
}
