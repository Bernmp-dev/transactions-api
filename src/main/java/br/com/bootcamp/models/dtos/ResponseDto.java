package br.com.bootcamp.models.dtos;

/** Response Data Transfer Object. */
public record ResponseDto<T>(String message, T data) {
}