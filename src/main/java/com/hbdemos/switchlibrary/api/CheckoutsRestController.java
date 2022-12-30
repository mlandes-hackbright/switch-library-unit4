package com.hbdemos.switchlibrary.api;

import com.hbdemos.switchlibrary.dto.CheckoutSpecDTO;
import com.hbdemos.switchlibrary.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkouts")
public class CheckoutsRestController {
    CheckoutService service;

    @Autowired
    public CheckoutsRestController(CheckoutService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> checkoutGame(@RequestBody CheckoutSpecDTO spec) throws ApiBadRequest {
        var result = this.service.checkoutGame(spec);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> returnGame(@PathVariable Long id) throws ApiBadRequest {
        this.service.returnGame(id);
        return ResponseEntity.noContent().build();
    }
}