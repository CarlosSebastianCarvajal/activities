
package com.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian Carvajal
 */
@CrossOrigin(origins = "*")
@RestController
public class BienvenidaController {
    
    
    @GetMapping("/")
    public String Bienvenida(){
        return "Bienvenido!! Esta es tu api para comunicar tus aplicaciones a la base de datos :)";
    }
}
