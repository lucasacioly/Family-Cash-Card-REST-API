package com.example.cashcard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardJsonTest {
    
    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    public void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);
        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
             .isEqualTo(123.45);
    }

    @Test
    public void cashCardDeserializationTest() throws IOException {
        String expected = """
                {
                    "id":99,
                    "amount":123.45
                }
                """;
        assertThat(json.parse(expected)).isEqualTo(new CashCard(1000L, 67.89));
        assertThat(json.parseObject(expected).id()).isEqualTo(1000);
        assertThat(json.parseObject(expected).amount()).isEqualTo(67.89);
    }

}
