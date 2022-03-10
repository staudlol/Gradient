package io.github.staudlol.conversation;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 10/03/2022 - 01:12
 */

import io.github.staudlol.GradientPlugin;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.conversations.Prompt;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

public class ConversationHandler {

    /**
     * Constructor to build a {@link Conversation}
     *
     * @param player the player.
     * @param prompt the prompt.
     * @param timeout the timeout.
     * @param quitSequence the quitSequence.
     * @param event the event.
     */

    public void build(Player player, Prompt prompt, int timeout, String quitSequence, Consumer<ConversationAbandonedEvent> event) {
        final Conversation conversation = new ConversationFactory(GradientPlugin.getPlugin(GradientPlugin.class))
                .withModality(true)
                .withEscapeSequence(quitSequence)
                .addConversationAbandonedListener(event::accept)
                .withTimeout(timeout)
                .withFirstPrompt(prompt)
                .withLocalEcho(false)
                .buildConversation(player);

        player.beginConversation(conversation);
    }

    /**
     * Constructor to build a {@link Conversation}
     *
     * @param player the player.
     * @param prompt the prompt.
     * @param timeout the timeout.
     * @param quitSequence the quitSequence.
     */

    public void build(Player player, Prompt prompt, int timeout, String quitSequence) {
        final Conversation conversation = new ConversationFactory(GradientPlugin.getPlugin(GradientPlugin.class))
                .withModality(true)
                .withEscapeSequence(quitSequence)
                .withTimeout(timeout)
                .withFirstPrompt(prompt)
                .withLocalEcho(false)
                .buildConversation(player);

        player.beginConversation(conversation);
    }
}
