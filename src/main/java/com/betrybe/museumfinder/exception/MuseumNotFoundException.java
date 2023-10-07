package com.betrybe.museumfinder.exception;

/**
 * museu nao encontrado.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
