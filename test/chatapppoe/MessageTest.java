/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapppoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khanyi
 */
public class MessageTest {

    @Test
    public void testCheckMessageIDSuccess() {
        Message m = new Message();
        assertTrue(m.checkMessageID("1234567890"));
    }

    @Test
    public void testCheckMessageIDFailure() {
        Message m = new Message();
        assertFalse(m.checkMessageID("12345678901"));
    }

    @Test
    public void testMessageLengthSuccess() {
        Message m = new Message();
        assertEquals("Message ready to send.",
                m.checkMessageLength("Hi Mike, can you join us for dinner tonight?"));
    }

    @Test
    public void testMessageLengthFailure() {
        Message m = new Message();
        String longMessage = "a".repeat(260);
        assertEquals("Message exceeds 250 characters by 10, please reduce the size.",
                m.checkMessageLength(longMessage));
    }

    @Test
    public void testRecipientCellSuccess() {
        Message m = new Message();
        assertEquals("Cell phone number successfully captured.",
                m.checkRecipientCell("+27718693002"));
    }

    @Test
    public void testRecipientCellFailure() {
        Message m = new Message();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                m.checkRecipientCell("08575975889"));
    }

    @Test
    public void testMessageHashMessage1() {
        Message m = new Message();
        assertEquals("00:0:HITONIGHT",
                m.createMessageHash("0012345678", 0, "Hi Mike, can you join us for dinner tonight?"));
    }

    @Test
    public void testMessageHashMessage2() {
        Message m = new Message();
        assertEquals("00:1:HIPAYMENT",
                m.createMessageHash("0012345678", 1, "Hi Keegan, did you receive the payment?"));
    }

    @Test
    public void testReturnTotalMessages() {
        Message m = new Message();
        m.recordSent("0012345678", "00:0:HITONIGHT", "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals(1, m.returnTotalMessages());
    }
}