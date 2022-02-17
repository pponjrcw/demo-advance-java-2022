package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("null All")
    public void case01() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            business.register(null,null);
        });
        assertEquals("Speaker is null",exception.getMessage());
    }

    @Test
    @DisplayName("First name is required.")
    public void case02() {
        RegisterBusiness business = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,new Speaker());
        });
        assertEquals("First name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Last name is required.")
    public void case03() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,speaker);
        });
        assertEquals("Last name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Firstname = \"\"")
    public void case03_1() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,speaker);
        });
        assertEquals("First name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Lastname = \"\"")
    public void case03_2() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,speaker);
        });
        assertEquals("Last name is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email name is required.")
    public void case4() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        speaker.setLastName("W.");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,speaker);
        });
        assertEquals("Email is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email =\"\"")
    public void case4_1() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        speaker.setLastName("W.");
        speaker.setEmail("");
        Exception exception = assertThrows(ArgumentNullException.class, () -> {
            business.register(null,speaker);
        });
        assertEquals("Email is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email not contain @")
    public void case5() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        speaker.setLastName("W.");
        speaker.setEmail("jiratcha.wkbtg.tech");
        Exception exception = assertThrows(DomainEmailInvalidException.class,() -> {
            business.register(null,speaker);
        });
//        assertEquals("Email is required.",exception.getMessage());
    }

    @Test
    @DisplayName("Email not in Domian rules")
    public void case6() {
        RegisterBusiness business = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Jiratcha");
        speaker.setLastName("W.");
        speaker.setEmail("jiratcha.w@kbtg.tech");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class,() -> {
            business.register(null,speaker);
        });
        assertEquals("Speaker doesn't meet our standard rules.",exception.getMessage());
    }

}