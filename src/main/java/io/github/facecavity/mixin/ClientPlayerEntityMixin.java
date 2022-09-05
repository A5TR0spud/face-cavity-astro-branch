package io.github.facecavity.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.network.encryption.Signer;
import net.minecraft.network.message.ChatMessageSigner;
import net.minecraft.network.message.MessageSignature;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.stat.StatHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tigereye.chestcavity.interfaces.ChestCavityEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.network.ClientPlayerEntity.field_39078;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    MinecraftClient client;
    public ClientPlayerEntityMixin(MinecraftClient client, ClientWorld world, ClientPlayNetworkHandler networkHandler, StatHandler stats, ClientRecipeBook recipeBook, boolean lastSneaking, boolean lastSprinting) {
        super(world, networkHandler.getProfile(), (PlayerPublicKey)client.getProfileKeys().getPublicKey().orElse(null));
        this.client = client;
    }

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile, @Nullable PlayerPublicKey publicKey) {
        super(world, profile, publicKey);
    }

    @Inject(at = @At(value = "HEAD"), method = "sendChatMessagePacket", cancellable = true)
    private void sendChatMessagePacket(ChatMessageSigner signer, String message1, @Nullable Text preview, CallbackInfo cir) {
        ClientPlayerEntity client = (ClientPlayerEntity) (Object) this;
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player instanceof ChestCavityEntity ccE) {
            if (0 >= ccE.getChestCavityInstance().getOrganScore(new Identifier("facecavity", "human_chat"))) {
                MessageSignature messageSignature;
                String[] randomNoises = {":(", "", "h", "?", "!", "uo", "", "ah", "", "uh", "", " ", "*", "eo", "", "$"};
                StringBuilder message3 = new StringBuilder();
                String message;
                if (random.nextFloat() > 0.995) {
                    message = "Hewwo! I am a' idiot. I am 'rying to s'eak, bu' I have 'o 'ongue. There is a 0.5% 'hance hor 'his 'essa'e to a'ear, wucky us! Have a 'rea' 'ay!";
                } else {
                    for (int i = 0; i < message1.toCharArray().length; i++) {
                        int r = random.nextInt(randomNoises.length);
                        message3.append(randomNoises[r]);
                    }
                    message = message3.toString();
                }

                if (preview != null) {
                    messageSignature = signChatMessage(signer, preview);
                    client.networkHandler.sendPacket(new ChatMessageC2SPacket(message, messageSignature, true));
                } else {
                    messageSignature = signChatMessage(signer, Text.literal(message));
                    client.networkHandler.sendPacket(new ChatMessageC2SPacket(message, messageSignature, false));
                }
                cir.cancel();
            }
        }
    }

    private MessageSignature signChatMessage(ChatMessageSigner signer, Text message) {
        try {
            Signer signer2 = this.client.getProfileKeys().getSigner();
            if (signer2 != null) {
                return signer.sign(signer2, message);
            }
        } catch (Exception var4) {
            field_39078.error("Failed to sign chat message: '{}'", message.getString(), var4);
        }

        return MessageSignature.none();
    }
}
