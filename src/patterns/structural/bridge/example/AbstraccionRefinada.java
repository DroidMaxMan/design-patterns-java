package patterns.structural.bridge.example;

class AbstraccionRefinada implements Abstraccion {

    private Implementador implementador;

    public AbstraccionRefinada(Implementador implementador) {
        this.implementador = implementador;
    }

    public void operacion() {
        implementador.operacion();
    }

}
