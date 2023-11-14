package ru.infoza.grabcontact.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.infoza.grabcontact.dto.PhoneDTO;
import ru.infoza.grabcontact.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/phones")
public class PhoneController {
    private final PhoneService phoneService;
    @Value("${api.key}")
    private String apiKey;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/{vcPhone}")
    public ResponseEntity<List<PhoneDTO>> getPhoneDetails(
            @PathVariable String vcPhone,
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        // Check if the provided API key matches the expected key
        if (!isValidApiKey(authorizationHeader)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // Process the request if the API key is valid
        List<PhoneDTO> phoneInfoList = phoneService.getPhoneByNumber(vcPhone);
        return phoneInfoList != null && !phoneInfoList.isEmpty()
                ? new ResponseEntity<>(phoneInfoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private boolean isValidApiKey(String authorizationHeader) {
        // Extract the API key from the Authorization header (Bearer <api_key>)
        String[] parts = authorizationHeader.split(" ");
        if (parts.length == 2 && "Bearer".equals(parts[0])) {
            String providedApiKey = parts[1];
            return apiKey.equals(providedApiKey);
        }
        return false;
    }
}
