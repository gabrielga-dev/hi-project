package br.com.hiproject.hiproject.adapter.port;

import org.springframework.http.ResponseEntity;

public interface HiAPI {

    ResponseEntity<String> getHi();
}
