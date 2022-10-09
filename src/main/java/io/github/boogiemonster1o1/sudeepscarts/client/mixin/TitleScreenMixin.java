package io.github.boogiemonster1o1.sudeepscarts.client.mixin;

import io.github.boogiemonster1o1.sudeepscarts.client.gui.ScreenUtils;
import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
	protected TitleScreenMixin(Text title) {
		super(title);
	}

	@Redirect(at = @At(value = "INVOKE", ordinal = 2, target = "Lnet/minecraft/client/gui/screen/TitleScreen;addDrawableChild(Lnet/minecraft/client/gui/Element;)Lnet/minecraft/client/gui/Element;"), method = "initWidgetsNormal")
	private Element replaceRealms(TitleScreen instance, Element element, int y, int spacingY) {
		LibGuiClient.config.darkMode = true;
		return this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y + spacingY * 2, 200, 20, Text.translatable("sudeepscarts.menu.button"), (button) -> ScreenUtils.openSearchScreen()));
	}
}
