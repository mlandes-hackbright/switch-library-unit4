package com.hbdemos.switchlibrary.api;

import com.hbdemos.switchlibrary.dto.SwitchGameDTO;
import com.hbdemos.switchlibrary.repository.IGamesRepository;
import com.hbdemos.switchlibrary.service.GamesService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class GamesRestControllerTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private GamesService service;

    @InjectMocks
    private GamesRestController controller;

    @Test
    public void itListsGamesWhenThereAreNone() {
        // given
        given(service.listGames()).willReturn(List.of());

        // when
        var result = controller.listGames();

        // then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody().isEmpty());
    }

    @Test
    public void itListsGamesWhenThereAreOne() {
        given(service.listGames()).willReturn(List.of(new SwitchGameDTO(0L, "A", "B", "C")));

        var result = controller.listGames();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertFalse(result.getBody().isEmpty());
        assertEquals(1, result.getBody().size());
        assertEquals(0L, (long) result.getBody().get(0).getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void itThrowsOnBadId() {
        given(service.getGame(any())).willThrow(new NoSuchElementException("message"));

        var result = controller.viewGame(5L);
    }

    @Test
    public void itDeletesGame() {
//        given(service.removeGame(any()))
//        given(service.getGame(any())).willReturn(new SwitchGameDTO(5L, "A", "B", "C"));

        var result = controller.removeGame(5L);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
    }
}
