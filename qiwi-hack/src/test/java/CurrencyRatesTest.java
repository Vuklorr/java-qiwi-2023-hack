import jakarta.xml.bind.JAXBException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.qiwi.hack.CurrencyRates;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CurrencyRatesTest {

    @Test
    public void testMain() throws JAXBException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"--code=USD", "--date=2022-10-08"};
        CurrencyRates.main(args);

        String expectedOutput = "USD(Доллар США): 61,2475";
        Assertions.assertEquals(expectedOutput, outputStream.toString().trim());

    }

    @Test
    public void testBYNRequest() throws JAXBException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"--code=BYN", "--date=2022-10-08"};
        CurrencyRates.main(args);

        String expectedOutput = "BYN(Белорусский рубль): 24,4286";
        Assertions.assertEquals(expectedOutput, outputStream.toString().trim());

    }

    @Test
    public void testInvalidArgs() throws JAXBException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"--code=USD"};
        CurrencyRates.main(args);

        String expectedOutput = "Введите валидные арргументы! Используйте формат ввода: currency_rates --code=USD --date=2022-10-08";
        Assertions.assertEquals(expectedOutput, outputStream.toString().trim());

    }
}
