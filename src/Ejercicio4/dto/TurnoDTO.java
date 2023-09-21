package Ejercicio4.dto;

import java.io.Serializable;

public class TurnoDTO implements Serializable {

        private int turno;
        private boolean atendido;

        public TurnoDTO(int numero) {
            this.turno = numero;
            this.atendido = false; // Inicialmente, el turno no ha sido atendido
        }

        public int getTurno() {
            return turno;
        }

        public boolean isAtendido() {
            return atendido;
        }

        public void setAtendido(boolean atendido) {
            this.atendido = atendido;
        }
    }


