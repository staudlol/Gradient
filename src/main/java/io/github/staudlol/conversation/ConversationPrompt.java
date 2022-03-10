package io.github.staudlol.conversation;

/*
 * Created by Kyle
 * Project: Gradient
 * Date: 10/03/2022 - 01:06
 */

import io.github.staudlol.util.CC;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

import java.util.function.Consumer;

@Getter
@Setter
@Builder
public class ConversationPrompt extends StringPrompt {

    private ConversationContext conversationPrompt;

    private final String promptText;
    private String receivedText;

    private final Prompt prompt;

    private Consumer<ConversationPrompt> conversationPromptConsumer;

    /**
     * Gets the text to display to the user when this prompt is first
     * presented.
     *
     * @param context Context information about the conversation.
     * @return The text to display.
     */
    @Override
    public String getPromptText(ConversationContext context) {
        return CC.translate(promptText);
    }

    /**
     * Accepts and processes input from the user. Using the input, the next
     * Prompt in the prompt graph is returned.
     *
     * @param context Context information about the conversation.
     * @param input   The input text from the user.
     * @return The next Prompt in the prompt graph.
     */
    @Override
    public Prompt acceptInput(ConversationContext context, String input) {
        this.conversationPrompt = context;
        this.receivedText = promptText;
        this.conversationPromptConsumer.accept(this);
        return prompt != null ? prompt : END_OF_CONVERSATION;
    }
}
