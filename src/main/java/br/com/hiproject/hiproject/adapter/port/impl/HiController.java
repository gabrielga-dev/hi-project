package br.com.hiproject.hiproject.adapter.port.impl;

import br.com.hiproject.hiproject.adapter.port.HiAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/get-hi")
public class HiController implements HiAPI {

    private static final List<String> SALUTATIONS = List.of(
            "Oi",
            "Olá",
            "Opa",
            "E aí",
            "Bom dia",
            "Boa tarde",
            "Boa noite",
            "Como vai?",
            "Tudo bem?",
            "Beleza?",
            "Tranquilo?",
            "Salve",
            "Fala aí",
            "Saudações",
            "Oiê"
    );
    private static final int QUANTITY_OF_SALUTATION = SALUTATIONS.size();
    private static final Random random = new Random();

    @Override
    @GetMapping
    public ResponseEntity<String> getHi() {
        final int randomIndex = random.nextInt(QUANTITY_OF_SALUTATION);
        final String selectedSalutation = SALUTATIONS.get(randomIndex);
        return ResponseEntity.ok(selectedSalutation);
    }
}
