package example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashcardController {

    @GetMapping("/{requestId}")
    public ResponseEntity<CashCard> findById() {
        CashCard cashCard = new CashCard(1000L, 0.0);
        return ResponseEntity.ok(cashCard);
    }
 }