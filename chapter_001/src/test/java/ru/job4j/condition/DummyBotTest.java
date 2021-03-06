package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anatoli Shalobasov (proboostbiznes@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {
    DummyBot bot = new DummyBot();
    /**
     * Test answer when greetings
     */
    @Test
    public void whenGreetBot() {
        assertThat(
                bot.answer("Привет, Бот"),
                is("Привет, умник.")
        );
    }

    /**
     * Test answer when goodbye
     */
    @Test
    public void whenByuBot() {
        assertThat(
                bot.answer("Пока."),
                is("До скорой встречи.")
        );
    }

    /**
     * Test answer
     */
    @Test
    public void whenUnknownBot() {
        assertThat(
                bot.answer("Сколько будет 2 + 2?"),
                is("Это ставит меня в тупик. Спросите другой вопрос.")
        );
    }
}
