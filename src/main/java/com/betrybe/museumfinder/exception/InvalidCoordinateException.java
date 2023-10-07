package com.betrybe.museumfinder.exception;

/**
 * coordenada invalida.
 */

public class InvalidCoordinateException extends RuntimeException {
  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
