package ar.unrn.eje1;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.eje1.libro.Libro;

public class Cliente {
  private List<Alquiler> alquileres = new ArrayList<Alquiler>();
  private String nombre;

  public Cliente(String nombre) {
    this.nombre = nombre;
  }

  public Object[] calcularDeudaYPuntosObtenidos() {
    Object[] resultado = new Object[2];
    double total = 0;
    int puntosAlquilerFrecuente = 0;
    double monto = 0;
    for (Alquiler alquiler : alquileres) {
      monto += alquiler.precioCopia(alquiler);
    }
    total += monto;
    puntosAlquilerFrecuente++;
    resultado[0] = total;
    resultado[1] = puntosAlquilerFrecuente;
    return resultado;
  }

  public void alquilar(Alquiler rentar) {
    alquileres.add(rentar);
  }
}