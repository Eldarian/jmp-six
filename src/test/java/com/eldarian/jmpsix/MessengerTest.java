package com.eldarian.jmpsix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class MessengerTest {
    @Mock
    private EmailService mockEmailService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessage() {
        Messenger messenger = new Messenger(mockEmailService);

        Template template = new Template();
        template.setMessage("hey #{name}");
        template.addKeyValuePair("name", "man");

        // Set up the behavior of the mockEmailService
        when(mockEmailService.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);

        assertEquals(messenger.sendMessage("testTopic", "karpau.aliaksei@email.com", template),
                "hey man");
    }

    @Test
    void testConsumeMessage() {
        Messenger messenger = new Messenger(mockEmailService);

        // Create a spy of the messenger object
        Messenger spyMessenger = Mockito.spy(messenger);

        // Stub a method of the spy with a different behavior
        doReturn("some message").when(spyMessenger).consumeMessage();

        assertEquals("some message", spyMessenger.consumeMessage());
    }
}
